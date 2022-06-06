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
	 * pipe connect only to filter and vice versa 
	 */	
	//TODO add Abstraction function
	
	/*
	 * Abstraction function: 
	 * AF(s) = A simulator so that 
	 * s.round = The current round
	 * state of this simulation s.graph.blackNodes() = all the pipes in this
	 * simulator s.graph.whiteNoeds() = all the filters in this simulator
	 * foreach filter in this simulator (pipe or filter)
	 * for(0<i<num of pipes+filters) 
	 * s.graph.node[i].parents.Keys = the connections between this 
	 * and
	 * 
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
	}
    /**
     * @modifies this
     * @effects adds a new pipe with object job which represent the functionality of pipe
     * 			if there is already another pipe with the same label in this
     * 			then do nothing
     */
	public void addPipe(T pipe, Object job) {
		graph.addBlackNode(pipe,job);
	}
    /**
     * @modifies this
     * @effects adds a new filter with object job which represent the functionality of filter
     * 			if there is already another filter with the same label in this
     * 			then do nothing
     */
	public void addFilter(T filter, Object job) {
		graph.addWhiteNode(filter,job);
	}
    /**
     * @modifies this
     * @effects adds a new edge between parentName and childName in this
     * 			
     * 
     */
	public void addEdge(T parentName,
						T childName, T edgeLabel) {
		graph.addEdge(parentName, childName, edgeLabel);
	}
	//TODO add specs
	public Object getPipe(T pipeName) {
		if(Arrays.asList(graph.listBlackNodes()).contains(pipeName)) {
			return graph.getJob(pipeName);
		}
		return null;
	}
	//TODO add specs
	public Object getFilter(T filterName) {
		if(Arrays.asList(graph.listWhiteNodes()).contains(filterName)) {
			return graph.getJob(filterName);
		}
		return null;
	}
	
	
	//TODO add specs
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
	}
	/**
	 * @return the round
	 */
	public Integer getRound() {
		return round;
	}
}