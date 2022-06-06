package homework2;

import homework2.BipartiteGraph;

/**
 * The homework2.Simulatable interface is implemented by each of the pipes and filters in
 * a pipe-and-filter simulation.
 */
public interface Simulatable<T> {

	/**
	 * @modifies this, graph
	 * @effects Simulates this pipe or filter in a system modeled by graph
	 */
	public void simulate(BipartiteGraph<T> graph);
}
