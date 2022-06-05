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
		for (Object pipe: graph.listBlackNodes()) {
			((Simulatable<T>)pipe).simulate(graph);
		}
		for (Object filter: graph.listWhiteNodes()) {
			((Simulatable<T>)filter).simulate(graph);
		}
		round=+1;
	}
}