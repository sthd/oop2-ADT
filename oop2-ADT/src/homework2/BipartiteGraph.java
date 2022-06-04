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
     * @effects if whiteNode!=null Add a node blackNode to this BipartiteGraph
     * else do nothing
     */
    public void addBlackNode(T blackNode) {
//        Node<L> newBlackNode = new Node<>(blackNode);
//        this.blackNodes.add(newBlackNode);
    	if(blackNode!=null) {
    	blackNodes.putIfAbsent(blackNode, new Node<>(blackNode));
    	}
    }


    /**
     * @modifies this
     * @effects if blackNode !=null Add a node blackNode to this BipartiteGraph
     * else do nothing
     */
    public void addWhiteNode(T whiteNode) {
    	if(whiteNode!=null) {
    	whiteNodes.putIfAbsent(whiteNode, new Node<>(whiteNode));
    	}
    }

    /**
     * @modifies this
     * @effects Adds an edge from the node sourceNode to the node destinationNode.
     * 			The node is with label edgeLabel
     *
     */
    public void addEdge(T sourceNode, T destinationNode, T edgeLabel) {
        // check that nodes  are not null
        // ?? check that the nodes are different??
        // ?? check that the nodes of different type (i.e. black or white) ??
        //if (!map.containsKey(sourceNode) || !map.containsKey(destinationNode) ) {
        //    // nodes do not exist!!
        //}
        //map.get(sourceNode).add(destinationNode);
//        this.blackNodes.get(0).addEdge(edgeLabel, (Node<T>) destinationNode);
    	
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

    private Node<T> getNode(T node){
    	Node<T> v = blackNodes.get(node);
    	if(v!=null) return v;
    	else return whiteNodes.get(node);
    }
    
    public boolean contains(T node) {
    	return (blackNodes.containsKey(node) 
    			|| whiteNodes.containsKey(node));
    }
    
    //TODO add specs
	public Object[] listBlackNodes() {
		return blackNodes.keySet().toArray();
	}
	//TODO add specs    
	public Object[] listWhiteNodes() {
		return whiteNodes.keySet().toArray();
	}
	//TODO add specs 
	public Object[] listChildren(T parentName) {
		return getNode(parentName).getChildren();
	}
	//TODO add specs 
	public Object[] listParents(T childName) {
		return getNode(childName).getParents();
	}
	//TODO add specs 
   public T getChildByEdgeLabel(T parentName, T edgeLabel) {
	   return getNode(parentName).getChild(edgeLabel);
   }
	
   public T getParentByEdgeLabel(T childName, T edgeLabel) {
   return getNode(childName).getParent(edgeLabel);
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





}
