package homework2;

import java.util.Arrays;

//TODO overview
public class PlusFilter implements Simulatable<String> {
	//TODO add rep invariant
	//TODO add Abstraction function
	
	@Override
	//TODO add specs
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
