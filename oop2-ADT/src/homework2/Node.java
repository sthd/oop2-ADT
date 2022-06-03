package homework2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
	overview:
	A Node is a mutable representation of a node with parent node 
	and children nodes which connected by edges with direction 
		*/
public class Node<T> {
	//TODO add AF and REP variant
	private T nodeLabel;
//	private Map<L, Node<L>> parentNodes; // key is an edge, Value is a Node
//	private Map<L, Node<L>> childrenNodes; // key is an edge, Value is a Node
	private Map<T, T> parentNodes; // key is an edge, Value is a Node
	private Map<T, T> childrenNodes; // key is an edge, Value is a Node
	
    /**
     * @effects Creates New node with label nodeLabel with no parents or children
     */ 
    public Node(T nodeLabel) {
        // the key in the map is an edge and the value is a node, either a parent or a child
        this.nodeLabel = nodeLabel;
        parentNodes = new HashMap<>();
        childrenNodes = new HashMap<>();
    }

    //TODO add specs 
    public void addChildNode(T edge, T childNode){
        if(!childrenNodes.containsValue(childNode)) {
        	childrenNodes.putIfAbsent(edge, childNode);
        }
    }
  //TODO add specs 
    public void addParentNode(T edge, T parentNode) {
 	   if(!parentNodes.containsValue(parentNode)) {
 		  parentNodes.putIfAbsent(edge, parentNode);
        }
    }
  //TODO add specs 
    public Object[] getChildren() {
        return childrenNodes.values().toArray();
    }
  //TODO add specs 
    public Object[] getParents() {
    	return parentNodes.values().toArray();
    }
  //TODO add specs 
    public T getLabel() {
    	return nodeLabel;
    }
  //TODO add specs 
    public T getChild(T edge) {
    	return childrenNodes.get(edge);
    }
  //TODO add specs 
    public T getParent(T edge) {
    	return parentNodes.get(edge);
    }
    

//	@Override
//	public int compareTo(Node<T> node) {
//		return nodeLabel.compareTo(node.getLabel());
//	}
}



