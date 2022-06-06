package homework2;

import java.util.Arrays;

//TODO overview
public class PlusFilter implements Simulatable<String> {
	//TODO add rep invariant
	//TODO add Abstraction function
	
	@Override
	/**
     * @modifies graph
     * @effects simulate 1 round of this. this gets one integer from each parents pipe 
     * 			of this, summing them together and push the result to child pipe.
     * 			If there is more then one child then push it to the first pipe be label order.
     * 			Empty pipe will considered as 0 to the sum.
     */
	public void simulate(BipartiteGraph<String> graph) {
		Integer sum = 0;
		String label = graph.getNodeLabelByJob(this);
		Object[] inputs = graph.listParents(label);
		IntPipe output = (IntPipe)graph.getJob((String)graph.listChildren(label)[0]);
		for(Object input :inputs) {
			try {
				sum+=((IntPipe)graph.getJob((String)input)).getNextandRemove();
			}catch( IndexOutOfBoundsException e ) {}
		}
		output.add(sum);
	}
	
}
