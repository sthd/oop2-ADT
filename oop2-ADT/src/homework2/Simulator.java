package homework2;

import java.util.Arrays;
/*Overview:
	This class represent generic simulator of pipes and filters
	There are job objects that transfered between stations
	simulate() are the simulation action which advance the simuation in one round
 	each round, all the pipes will transfer job objects to the next target 
	 and all the filters will do work on the job objects and passed them on when done.
*/

public class Simulator<T> {
	
	/*
	 * rep invariant: 
	 * round >=0 && round != null && graph !=null
	 * a pipe connect only to a filter and vice versa 
	 */	
	
	/*
	 * Abstraction function: 
	 * AF(s) = A simulator so that 
	 * s.round = The current round of this simulation 
	 * s.graph.blackNodes() = all the pipes in this simulator 
	 * s.graph.whiteNoeds() = all the filters in this simulator
	 * 
	 * foreach black node in s.graph
	 * black node's children labels are the labels of the edges of all children pipes
	 * and
	 * black node's parents edge's labels are the labels of the edges of all parent pipes
	 * 
	 * 
	 * foreach white node in s.graph
	 * white node's children labels are the labels of the edges of all children filters
	 * and
	 * white node's parents edge's labels are the labels of the edges of all parents filters
	 * 
	 * 
	 */	
	private Integer round;
	private BipartiteGraph<T> graph;
	
	
    /**
     * @effects creates empty simulator with round initialized to 0
     */
	public Simulator() {
		this.graph = new BipartiteGraph<T>();
		round = 0;
		checkRep();
	}
    /**
     * @modifies this
     * @effects adds a new pipe with object job which represent the functionality of pipe
     * 			if there is already another pipe with the same label in this
     * 			then do nothing
     */
	public void addPipe(T pipe, Object job) {
		graph.addBlackNode(pipe,job);
		checkRep();
	}
    /**
     * @modifies this
     * @effects adds a new filter with object job which represent the functionality of filter
     * 			if there is already another filter with the same label in this
     * 			or job=null
     * 			then do nothing.
     */
	public void addFilter(T filter, Object job) {
		if(job!=null) {
		graph.addWhiteNode(filter,job);
		}
		checkRep();
	}
    /**
     * @modifies this
     * @effects adds a new edge with label=edgeLabel between parentName and childName in this.
     * 			if
     * 			 parent and child are the same type (both of them are pipe or filter)
     * 			or 
     * 			edgeLabel==null or (parentaName or childName are not contained in this)
     * 			then do nothing
     * 			
     */
	public void addEdge(T parentName,
						T childName, T edgeLabel) {
		graph.addEdge(parentName, childName, edgeLabel);
		checkRep();
	}
    /**
     * @effects return the object job of pipeName or null if pipeName is not in this
     */
	public Object getPipe(T pipeName) {
		if(Arrays.asList(graph.listBlackNodes()).contains(pipeName)) {
			return graph.getJob(pipeName);
		}
		return null;
	}
    /**
     * @effects return the object job of filterName or null if filterName is not in this
     */
	public Object getFilter(T filterName) {
		if(Arrays.asList(graph.listWhiteNodes()).contains(filterName)) {
			return graph.getJob(filterName);
		}
		return null;
	}
	
	
    /**
     * @requires all pipes and filters object job in this need to implement Simulatable
     * @modifies this
     * @effects Simulation step. Will round robin the pipes by calling pipe.simulate() one time for each pipe
     * 			and then round robin the filters by calling filter.simulate() one time for each filter
     * 			then advance the this.round in 1.
     */
	public void simulate() {
		for (Object pipeLabel: graph.listBlackNodes()) {
			Object pipe =graph.getJob((T)pipeLabel);
			((Simulatable<T>)pipe).simulate(graph);
		}
		for (Object filterLabel: graph.listWhiteNodes()) {
			Object filter = graph.getJob((T)filterLabel);
			((Simulatable<T>)filter).simulate(graph);
		}
		round=+1;
		checkRep();
	}
	/**
	 * @effects return the round number of this
	 */
	public Integer getRound() {
		return round;
	}
	
	private boolean checkRep() {
		if(round<0 || graph==null) return false;
		else return true;
	}
}