package homework2;

public class Simulator<T> {
	
	//TODO add rep invariant
	//TODO add Abstraction function
	
	
	private int round;
	private BipartiteGraph<T> graph;
	
	
	//TODO add specs
	public Simulator(BipartiteGraph<T> graph) {
		this.graph = graph;
		round = 0;
	}
	
	@SuppressWarnings("unchecked")
	
	//TODO add specs
	public void simulate() {
		for (Object pipeLabel: graph.listBlackNodes()) {
			Node <T> pipeNode =graph.getNode((T)pipeLabel);
			((Simulatable<T>)pipeNode.getJob()).simulate(graph);
		}
		for (Object filterLabel: graph.listWhiteNodes()) {
			Node <T> filterNode = graph.getNode((T)filterLabel);
			((Simulatable<T>)filterNode.getJob()).simulate(graph);
		}
		round=+1;
	}
}