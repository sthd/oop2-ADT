package homework2;

import java.util.Arrays;

//TODO overview
public class PlusFilter implements Simulatable<String> {
	//TODO add rep invariant
	//TODO add Abstraction function
	
	
	
	//TODO to think how to accesses to edges of the graph by job
	@Override
	//TODO add specs
	public void simulate(BipartiteGraph<String> graph) {
		Integer sum = 0;
		String label = graph.getNodeLabelByJob(this);
		Object[] inputs = graph.listParents(label);
		IntPipe output = (IntPipe)Arrays.asList(graph.listChildren(label)).get(0);
		
		for(Object input :inputs) {
			try {
				sum=+((IntPipe)input).getNext();
			}catch( IndexOutOfBoundsException e ) {}
		}
		output.add(sum);
	}
	
}
