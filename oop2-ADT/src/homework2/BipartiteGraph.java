package homework2;

import java.util.*;



// A BipartiteGraph is a ??mutable/immutable?? representation of a graph
// made of two types of nodes and one type of edges.
//

//public class BipartiteGraph<T extends Comparable <T>>
public class BipartiteGraph<T> {

    //private Map<T, List<T>> nodes_;

    private Map<T, List<T> > map = new HashMap<>(); //for edges in the graph
    private ArrayList<Node<T>> blackNodes; // here they are objects
    private ArrayList<Node<T>> whiteNodes;


    //private Map<T, List<T> > blackNodes = new HashMap<>(); //for edges in the graph
    //private Map<T, List<T> > whiteNodes = new HashMap<>(); //for edges in the graph


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

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BipartiteGraph bn = new BipartiteGraph();
    }

    /**
     * @requires
     * @modifies
     * @effects Creates a new empty BipartiteGraph
     * ??throws exception???
     */
    public BipartiteGraph() {
        //TODO
        checkRep();
        this.blackNodes = new ArrayList<Node<T>>();
        checkRep();
        this.whiteNodes = new ArrayList<Node<T>>();
        checkRep();
    }


    /**
     * @requires
     * @modifies this
     * @effects Add a node blackNode to this BipartiteGraph
     */
    public boolean addBlackNode(T blackNode) {
        //TODO
        // make sure node isn't in graph (using unique label)
        Node<T> newBlackNode = new Node<>(blackNode);
        this.blackNodes.add(newBlackNode);
        return true;
    }


    /**
     * @requires
     * @modifies this
     * @effects Add a node blackNode to this BipartiteGraph
     * ??throws exception???
     */
    public boolean addWhiteNode(T whiteNode) {
        //TODO
        // make sure node isn't in graph (using unique label)

        return true;

    }

    public boolean addNode(T node) {
        //TODO
        if (this.blackNodes.contains(node) ||  this.whiteNodes.contains(node)) {
            //Node exists already!
        }
        else {

        }


        return true;

    }


    /**
     * @requires
     * @modifies this
     * @effects Adds an edge from the node sourceNode to the node destinationNode.
     * 			The node is with label edgeLabel
     *
     */
    public boolean addEdge(T sourceNode, T destinationNode, T edgeLabel) {
        //TODO
        // check that nodes  are not null
        // ?? check that the nodes are different??
        // ?? check that the nodes of different type (i.e. black or white) ??
        //if (!map.containsKey(sourceNode) || !map.containsKey(destinationNode) ) {
        //    // nodes do not exist!!
        //}
        //map.get(sourceNode).add(destinationNode);
        this.blackNodes.get(0).addEdge(edgeLabel, (Node<T>) destinationNode);


        return true;
    }

    @Override
    public String toString() {
        String s = "What to override";
        return s;
    }

    public List<T> getChildren(T node) {
        assert (node!= null): "node is null";
        assert (nodes.containsKey(node)): "node is not in the graph";

        return  Collections.unmodifiableList(node.));
    }


    public List<Integer> getChildren() {
        Map<Integer, String> myMap = new HashMap<>();
        myMap.put(1, "Java");
        myMap.put(2, "JavaFX");
        myMap.put(3, "CoffeeScript");
        myMap.put(4, "TypeScript");

        ArrayList<Integer> keyList = new ArrayList<Integer>(myMap.keySet());
        ArrayList<String> valueList = new ArrayList<String>(myMap.values());
        System.out.println("contents of the list holding keys the map ::" + keyList);
        System.out.println("contents of the list holding values of the map ::" + valueList);

        return  Collections.unmodifiableList(keyList);
    }



    /**
     * Checks to see if the representation invariant is being violated
     * @throws AssertionError if representation invariant is violated
     *
     */
    private void checkRep() {
        //TODO
        //assert name_ != null :
        //	"Graph name cannot be null";

        //assert this.name_.equals("jalou") :
        //	"Not jalou";

    }





}
