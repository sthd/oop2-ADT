package homework2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Node<T>{
    private T nodeLabel;
    private Map<T, Node<T>> parentNodes; // key is an edge, Value is a Node
    private Map<T, Node<T>> childrenNodes; // key is an edge, Value is a Node

    public Node(){}

    public Node(T nodeLabel) {
        //TODO
        // the key in the map is an edge and the value is a node, either a parent or a child
        this.nodeLabel = nodeLabel;
        parentNodes = new HashMap<>();
        childrenNodes = new HashMap<>();
    }

    public void addEdge(T edge, Node<T> childNode){
        this.childrenNodes.put(edge, childNode);


    }


}
