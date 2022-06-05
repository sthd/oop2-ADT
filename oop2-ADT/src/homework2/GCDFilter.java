package homework2;
//TODO overview
public class GCDFilter implements Simulatable<String> {
	//TODO add rep invariant
	//TODO add Abstraction function
	
	//TODO add specs
	public void simulate(BipartiteGraph<String> graph) {
		String label = graph.getNodeLabelByJob(this);
		IntPipe aPipe = (IntPipe)graph.getJob(graph.getParentByEdgeLabel(label, "a"));
		IntPipe bPipe = (IntPipe)graph.getJob(graph.getParentByEdgeLabel(label, "b"));
		IntPipe output = (IntPipe)graph.getJob(graph.getChildByEdgeLabel(label, "gcd")); 

		Integer a = aPipe.getNext();
		Integer b = bPipe.getNext();
		
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
