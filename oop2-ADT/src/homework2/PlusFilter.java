package homework2;
//TODO overview
public class PlusFilter implements Simulatable<String> {
	IntPipe[] inputs;
	IntPipe output;
	//TODO add rep invariant
	//TODO add Abstraction function
	
	
	
	//TODO to think how to accesses to edges of the graph by job
	@Override
	//TODO add specs
	public void simulate(BipartiteGraph<String> graph) {
		Integer sum = 0;
		for(IntPipe input :inputs) {
			try {
				sum=+input.getNext();
			}catch( IndexOutOfBoundsException e ) {
				//nothing
			}
		}
		output.add(sum);
	}
	
}
