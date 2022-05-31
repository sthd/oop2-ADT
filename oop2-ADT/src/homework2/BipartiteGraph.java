package homework2;

import java.util.*;

public class BipartiteGraph<T> {
	
	private final String name_;
	private Map<T, List<T>> nodes_;
	
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
		//System.out.println("work");

		
		
	}
	
	
    /**
     * @requires 
     * @modifies
     * @effects
     * 
     */
    public BipartiteGraph(String name) {
    	//TODO
    	this.name_= name;
    	this.nodes_ = new HashMap<T, List<T>>();
    	checkRep();
    }
    //added
    
    /**
     * @requires 
     * @modifies
     * @effects
     * 
     */
    public boolean addBlackNode(T blackNode) {
    	//TODO
    	// make sure node isn't in graph (using unique label)
    	
    	
    	return true;
    }
    

    
    /**
     * @requires 
     * @modifies
     * @effects
     * 
     */
    public boolean addWhiteNode() {
    	//TODO
    	
    	return true;
    	
    }
    
    
    /**
     * @requires 
     * @modifies
     * @effects
     * 
     */
    public boolean addEdge(T sourceNode, T destinationNode, T edgeLabel) {
    	//TODO
    	// check that nodes are not null
    	// ?? check that the nodes are different??
    	// ?? check that the nodes of different type (i.e. black or white) ??
    	
    	
    	return true;
    }
    
    @Override
    public String toString() {
    	String s = "What to override";
    	return s;
    }
    
    
    /**
     * Checks to see if the representation invariant is being violated
     * @throws AssertionError if representation invariant is violated
     * 
     */
    private void checkRep() {
    	//TODO
    	//assert 
    }
    
    
    

    
}
