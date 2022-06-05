package homework2;

import java.util.*;
import java.util.Map.Entry;



/*Overview:
 *  A BipartiteGraph is a mutable representation of a Bipartite graph
 *	made of two types of nodes (black and white) and one type of directional edges.
 *	Each Edge and Node has general label of the same type
 *	There can't be edge from same type of node (black to black or white to white etc).
 *
 *
*/
public class BipartiteGraph<T> {
	private Map<T, Node<T> > blackNodes;
	private Map<T, Node<T> > whiteNodes;
	
	/*
	 * Abstract Function:
	 * 	AF(g) = represents a Bipartite graph
	 *	blackNodes<key,value> = <label of black node , The black node associated with the label>
	 *  and 
	 *  whiteNodes<key,value> = <label of white node , The white node associated with the label>
	 */
	
	/*
	 * Rep invariant:
	 * All nodes' label are unique 
	 * and 
	 * No edge from white node to white node 
	 * and 
	 * No edge from black node to black node
	 * and
	 * blackNodes.keys() != null && blackNodes.values() != null
	 * whiteNodes.keys() != null && whiteNodes.values() != null
	 */


    /**
     * @effects Creates a new empty BipartiteGraph
     */
    public BipartiteGraph() {
        blackNodes = new HashMap<>();
        whiteNodes = new HashMap<>();
        assert checkRep();
    }


    /**
     * @modifies this
     * @effects if whiteNode!=null and there is no other node with the same label
 * 				Add a node blackNode to this BipartiteGraph
 * 				else do nothing
     */
    public void addBlackNode(T blackNode) {
    	if(blackNode!=null || !this.contains(blackNode)) {
    	blackNodes.put(blackNode, new Node<>());
    	}
    	assert checkRep();
    }
	//TODO add specs
    public void addBlackNode(T blackNode, Object job) {
    	addBlackNode(blackNode);
		getNode(blackNode).setJob(job);
    }
    
	//TODO add specs
    public void addWhiteNode(T whiteNode, Object job) {
    	addWhiteNode(whiteNode);
		getNode(whiteNode).setJob(job);
    }

    /**
     * @modifies this
     * @effects if blackNode !=null and there is no other node with the same label
     * 			Add a node blackNode to this BipartiteGraph
     * 			else do nothing
     */
    public void addWhiteNode(T whiteNode) {
    	if(whiteNode!=null && !this.contains(whiteNode)) {
    	whiteNodes.put(whiteNode, new Node<>());
    	}
    	assert checkRep();
    }

    /**
     * @modifies this
     * @effects Adds an edge with direction from the node sourceNode to the node destinationNode
     * 			only if there is no other edge that connects between the nodes with the same direction
     * 			or there is no edge with same name that goes from this node
     * 			also destinationNode and sourceNode need to be of opposite type
     * 			(destinationNode is white Node and sourceNode is black etc.)
     * 			and destinationNode and sourceNode needs to be contained in the graph
     * 			else do nothing
     *			if the edge is created it will be labeled with the edgeLabel
     */
    public void addEdge(T sourceNode, T destinationNode, T edgeLabel) {
    	//Check if src and dst are contained in the graph
    	if( !this.contains(destinationNode) || !this.contains(sourceNode) || edgeLabel == null) {
    		return;    		
    	}
    	//check if src and dst are not the same color white/black
    	if(!((blackNodes.containsKey(sourceNode)
    			&&whiteNodes.containsKey(destinationNode))||(whiteNodes.containsKey(sourceNode)
    					&&blackNodes.containsKey(destinationNode)))) {
    		return;
    	}
    	
    	Node<T> src = getNode(sourceNode);
    	Node<T> dst = getNode(destinationNode);
    	src.addChildNode(edgeLabel, destinationNode);
    	dst.addParentNode(edgeLabel, sourceNode);
    	assert checkRep();
    	
    }
    
    /**
     * @effects return a copy of Array of Objects that represents the label of Black Nodes in this
     */
	public Object[] listBlackNodes() {
		return blackNodes.keySet().toArray();
	}
    /**
     * @effects return a copy of Array of Objects that represents the label of all the white Nodes in this
     */
	public Object[] listWhiteNodes() {
		return whiteNodes.keySet().toArray();
	}
    /**
     * @effects return a copy of Array of Objects that represents children nodes of a parentName 
     * 			or null if parentName is not in the graph
     * 			if parentName has no children return empty array
     */ 
	public Object[] listChildren(T parentName) {
		return getNode(parentName).getChildren();
	}
    /**
     * @effects return a copy of Array of Objects that represents parents nodes of a childName 
     			or null if childName is not in the graph
     * 			if childName has no parent return empty array
     */  
	public Object[] listParents(T childName) {
		return getNode(childName).getParents();
	}
    /**
     * @effects return a label that represent child node that has parent node with label=parentName 
     * 			and edge with label = edgeLabel
     *			if parentName is not in the graph or there is no edgeLabel associated with parentName 
     *			return null 
     */  
   public T getChildByEdgeLabel(T parentName, T edgeLabel) {
	   return getNode(parentName).getChild(edgeLabel);
   }
	
   /**
    * @effects return a label that represent parent node that has child node with label=childName 
    * 			and edge with label = edgeLabel
    *			if childName is not in the graph or there is no edgeLabel associated with childName 
    *			return null 
    */ 
   
   public T getParentByEdgeLabel(T childName, T edgeLabel) {
	   return getNode(childName).getParent(edgeLabel);
}
   
   //TODO add specs
   private Node<T> getNode(T nodeLabel){
	   Node<T> v = blackNodes.get(nodeLabel);
	   if(v!=null) return v;
	   else return whiteNodes.get(nodeLabel);
   }
  public Object getJob(T node) {
	  return getNode(node).getJob();
  }
	//TODO add specs
  public T getNodeLabelByJob(Object job) {
	for( Entry<T, Node<T>> entry : blackNodes.entrySet()) {
		if(entry.getValue().getJob() == job ) {
			return entry.getKey();
		}
	}
	for( Entry<T, Node<T>> entry : whiteNodes.entrySet()) {
		if(entry.getValue().getJob() == job ) {
			return entry.getKey();
		}
	}
	
	return null;
	  
  }
    
   /**
    * @effects return true if the node is contained in this
    */ 
   public boolean contains(T node) {
	   return (blackNodes.containsKey(node) 
			   || whiteNodes.containsKey(node));
   }

     
    /**
     * Checks to see if the representation invariant is being violated
     * @throws AssertionError if representation invariant is violated
     *
     */
    private boolean checkRep() {
       if(blackNodes.containsKey(null)||blackNodes.containsValue(null)
    		   ||whiteNodes.containsKey(null)||whiteNodes.containsValue(null)) {
    	   return false;
       }
       //Checking if the relative of each black node is white
       
       for(Node<T> blackNode: blackNodes.values()) {
    	   if(!allRelativesAreInSet(blackNode,whiteNodes.keySet())) {
    		   return false;
    	   }
       }
   
     //Checking if the relative of each white node is black
       for(Node<T> whiteNode: whiteNodes.values()) {
    	   if(!allRelativesAreInSet(whiteNode,blackNodes.keySet())) {
    		   return false;
    	   }
    		   
       }
       return true;
    }

    private boolean allRelativesAreInSet(Node<T> n, Set<T> s) {
    	 List<Object> listOfParents = Arrays.asList(n.getParents());
 	     List<Object> listOfChildren= Arrays.asList(n.getChildren());  
	     if(!s.containsAll(listOfParents)||
	    		 !s.containsAll(listOfChildren)) {
	     					return false;
	     }
	     return true;
    }




}
