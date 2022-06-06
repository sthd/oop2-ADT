package homework2;
//TODO overview:
/*
 * 	Overview: This class implents filter for Simulator class that operate a 
	GCD calculator. For two Integers after enough simulate()
	it will output the GCD.
*/
public class GCDFilter implements Simulatable<String> {
	//TODO add rep invariant
	//TODO add Abstraction function
	
    /**
     * @modifies graph
     * @effects 
     */
	public void simulate(BipartiteGraph<String> graph) {
		String label = graph.getNodeLabelByJob(this);
		IntPipe aPipe = (IntPipe)graph.getJob(graph.getParentByEdgeLabel(label, "a"));
		IntPipe bPipe = (IntPipe)graph.getJob(graph.getParentByEdgeLabel(label, "b"));
		IntPipe output = (IntPipe)graph.getJob(graph.getChildByEdgeLabel(label, "gcd")); 

		Integer a = aPipe.getNextandRemove();
		Integer b = bPipe.getNextandRemove();
		
		if (b==0) {
			// computation is finished – a is the GCD
			output.add(a);
		}
		else if (a<b) {
			// swap a and b so a >= b
			aPipe.add(b);
			bPipe.add(a);
		}
		else {
			// let (a,b) = (b, remainder of a/b)
			aPipe.add(b);
			bPipe.add( a%b );
		}
		
	}
	

}
