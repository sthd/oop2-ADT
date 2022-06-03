package homework2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
	overview:
	A Node is a mutable representation of a node with parent node 
	and children nodes which conntected by edges with direction 
		*/
public class Node<L>{
	//TODO add AF and REP variant
	private L nodeLabel;
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

    public void addChildNode(L edge, Node<L> childNode){
        if(!childrenNodes.containsValue(childNode)) {
        	childrenNodes.putIfAbsent(edge, childNode);
        }
    }

    public void addParentNode(L edge, Node<L> parentNode) {
 	   if(!parentNodes.containsValue(parentNode)) {
 		  parentNodes.putIfAbsent(edge, parentNode);
        }
    }
         
        
    	
        
    }


}
