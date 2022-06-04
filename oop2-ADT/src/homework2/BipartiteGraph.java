package homework2;

import java.util.*;



/*Overview:
 *  A BipartiteGraph is a mutable representation of a graph
 *	made of two types of nodes (black and white) and one type of edges.
 *	Edge has direction, from src node to dst node
 *	there can't be more then one edge with the same src and dst node.
 *	Each Edge and Node has general label of the same type
 *	There can't be edge from same type of node (black to black or white to white etc).
 *
 *
*/
public class BipartiteGraph<T> {


    // TODO repInvariant BipartiteGraph
    // RepInvariant:
    //
    //
    //

    // TODO abstract function BipartiteGraph
    // Abstraction Function:
    //
    //
    //

	private Map<T, Node<T> > blackNodes;
	private Map<T, Node<T> > whiteNodes;

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
//        Node<L> newBlackNode = new Node<>(blackNode);
//        this.blackNodes.add(newBlackNode);
    	if(blackNode!=null || !this.contains(blackNode)) {
    	blackNodes.put(blackNode, new Node<>(blackNode));
    	}
    }


    /**
     * @modifies this
     * @effects if blackNode !=null and there is no other node with the same label
     * 			Add a node blackNode to this BipartiteGraph
     * 			else do nothing
     */
    public void addWhiteNode(T whiteNode) {
    	if(whiteNode!=null && !this.contains(whiteNode)) {
    	whiteNodes.put(whiteNode, new Node<>(whiteNode));
    	}
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
    	src.addChildNode(edgeLabel, dst.getLabel());
    	dst.addParentNode(edgeLabel, src.getLabel());
    	
    }
    
    /**
     * @effects return a copy of Array of Objects that presents of all the Black Nodes in this
     */
	public Object[] listBlackNodes() {
		return blackNodes.keySet().toArray();
	}
    /**
     * @effects return a copy of Array of Objects that presents of all the white Nodes in this
     */
	public Object[] listWhiteNodes() {
		return whiteNodes.keySet().toArray();
	}
    /**
     * @effects return a copy of Array of Objects that presents children nodes of a parentName 
     * 			or null if parentName is not in the graph
     * 			if parentName has no children return empty array
     */ 
	public Object[] listChildren(T parentName) {
		return getNode(parentName).getChildren();
	}
    /**
     * @effects return a copy of Array of Objects that presents parents nodes of a childName 
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
        //TODO Graph CheckRep
    	return true;


    }

    
    private Node<T> getNode(T node){
    	Node<T> v = blackNodes.get(node);
    	if(v!=null) return v;
    	else return whiteNodes.get(node);
    }
    




}
