package homework2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
	overview:
	A Node is a mutable representation of a node with parent node 
	and children nodes which conntected by edges with direction 
		*/
public class Node<L extends Comparable<L>> implements Comparable<Node<L>> {
	//TODO add AF and REP variant
	private L nodeLabel;
//	private Map<L, Node<L>> parentNodes; // key is an edge, Value is a Node
//	private Map<L, Node<L>> childrenNodes; // key is an edge, Value is a Node
	private Map<L, Node<L>> parentNodes; // key is an edge, Value is a Node
	private Map<L, Node<L>> childrenNodes; // key is an edge, Value is a Node
	
    /**
     * @effects Creates New node with label nodeLabel with no parents or children
     */ 
    public Node(L nodeLabel) {
        // the key in the map is an edge and the value is a node, either a parent or a child
        this.nodeLabel = nodeLabel;
        parentNodes = new HashMap<>();
        childrenNodes = new HashMap<>();
    }

    //TODO add specs 
    public void addChildNode(L edge, Node<L> childNode){
        if(!childrenNodes.containsValue(childNode)) {
        	childrenNodes.putIfAbsent(edge, childNode);
        }
    }
  //TODO add specs 
    public void addParentNode(L edge, Node<L> parentNode) {
 	   if(!parentNodes.containsValue(parentNode)) {
 		  parentNodes.putIfAbsent(edge, parentNode);
        }
    }
  //TODO add specs 
    public Object[] getChildren() {
//        ArrayList<T> childrenList = new ArrayList<T>(childrenNodes.values());
        return childrenNodes.values().toArray().clone();
    }
  //TODO add specs 
    public Object[] getParents() {
//        ArrayList<T> parentsList = new ArrayList<T>(parentNodes.keySet());
//        return Collections.unmodifiableList(parentsList);
    	return parentNodes.values().toArray().clone();
    }
    
    public L getLabel() {
    	return nodeLabel;
    }
    

	@Override
	public int compareTo(Node<L> node) {
		return nodeLabel.compareTo(node.getLabel());
	}
}



