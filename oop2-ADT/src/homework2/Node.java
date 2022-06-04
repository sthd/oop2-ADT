package homework2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*	overview:
	A Node is a mutable representation of a node with parent nodes
	and children nodes which connected by edges with direction 
*/	
public class Node<T> {
	private Map<T, T> parentNodes; // pairs of <Edge,parentNode>
	private Map<T, T> childrenNodes; // pairs of <Edge,childNode>
	
	/*
	 * Abstract Function:
	 * 	AF(n) = represents a node in directional graph that has edges with direction
	 *	that can go to n or from n. 
	 *	parentNodes<key,value> = <label of edge from parent to this, the label of parent associated with edge>
	 *  and 
	 *  childrenNodes<key,value> = <label of edge from this to child node, the label of the child associated with edge>
	 */
	
	/*
	 * Rep invariant:
	 * ParentNodes.keys() are all unique label of edge and ParentNodes.values() are unique label of parents' nodes
	 * and 
	 * childNodes.keys() are all unique label of edge and childNodes.values() are unique label of children's nodes
	 * So there can't be the same edge for two different
	 * child/parent nodes or two different edges to/from the same child/parent node.
	 * Between two nodes there can be at most only one edge 
	 * with the same direction. 
	 * Each Edge and Node has general label of the same type
	 * 
	 */

	
	
	
	/**
	 * @modifies this
     * @effects Creates New node with label nodeLabel with no parents or children
     */ 
    public Node() {
        // the key in the map is an edge and the value is a node, either a parent or a child
//        this.nodeLabel = nodeLabel;
        parentNodes = new HashMap<>();
        childrenNodes = new HashMap<>();
    }

    /**
     * @modifies this
     * @effects if childNode is not contained in this's children list and 
     * 			there is no other edge with same name from this node then
     * 			add childNode to this's children associated with edge
     * 			else do nothing
     */
    public void addChildNode(T edge, T childNode){
        if(!childrenNodes.containsValue(childNode)) {
        	childrenNodes.putIfAbsent(edge, childNode);
        }
    }

    /**
     * @modifies this
     * @effects if parentNode is not contained in this's parents list and 
     * 			there is no other edge with same name to this node then
     * 			add parentNode to this's parents' list associated with edge
     * 			else do nothing
     */
    public void addParentNode(T edge, T parentNode) {
 	   if(!parentNodes.containsValue(parentNode)) {
 		  parentNodes.putIfAbsent(edge, parentNode);
        }
    }
    /**
     * @effects return a copy of Array of Objects that represents children nodes of a this
     * 			if this has no child return an empty array
     */  
    public Object[] getChildren() {
        return childrenNodes.values().toArray();
    }
    /**
     * @effects return a copy of Array of Objects that represents parents nodes of a this
     * 			if this has no parent return an empty array
     */  
    public Object[] getParents() {
    	return parentNodes.values().toArray();
    }
//    /**
//     * @effects return the label of this
//     */  
//    public T getLabel() {
//    	return nodeLabel;
//    }
    /**
     * @effects return the child node associated edge in this
     * 			if there is no child with edge from this to child, return null
     */  
    public T getChild(T edge) {
    	return childrenNodes.get(edge);
    }
    /**
     * @effects return the parent node associated edge in this
     * 			if there is no parent with edge from parent to this , return null
     */  
    public T getParent(T edge) {
    	return parentNodes.get(edge);
    }
    
}



