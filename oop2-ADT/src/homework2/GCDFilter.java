package homework2;
//TODO overview
public class GCDFilter implements Simulatable<String> {
	IntPipe aPipe, bPipe, output;
	//TODO add rep invariant
	//TODO add Abstraction function
	
	//TODO add specs
	public void simulate(BipartiteGraph<String> graph) {
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
