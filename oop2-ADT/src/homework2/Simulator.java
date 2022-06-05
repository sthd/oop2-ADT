package homework2;

import java.util.Arrays;

public class Simulator<T> {
	
	//TODO add rep invariant
	//TODO add Abstraction function
	
	
	private Integer round;
	private BipartiteGraph<T> graph;
	
	
	//TODO add specs
	public Simulator() {
		this.graph = new BipartiteGraph<T>();
		round = 0;
	}
	//TODO add specs
	public void addPipe(T pipe, Object job) {
		graph.addBlackNode(pipe,job);
	}
	//TODO add specs
	public void addFilter(T filter, Object job) {
		graph.addWhiteNode(filter,job);
	}
	//TODO add specs
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
	@SuppressWarnings("unchecked")
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