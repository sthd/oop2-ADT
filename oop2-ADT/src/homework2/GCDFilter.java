package homework2;
/*
 * 	Overview: This class implents filter for Simulator class that operate a 
	GCD finder for two intergers by using euclidean algorithm . For two Integers after enough simulate() rounds
	it will output the GCD into child Intpipe with edge labeled "gcd"
*/
public class GCDFilter implements Simulatable<String> {
	//TODO add rep invariant
	//TODO add Abstraction function
	
	/*
	 * Abstraction Function:
	 * AF(c) = a filter gcd finder so that
	 * parent Intpipe of c with edge "a" is Integer a in the algorithm
	 * parent IntPipe of c with edge "b" is Integer b in the algorithm
	 * child Intpipt of c with edge "gcd" is the final result of the algorithm
	 * 
	*/
	
	
    /**
     * @requires 2 Intpipes that are both parents and children of this with edges labeled "a" and "b" respectively
     * 			(edge "a" from first Intpipe to this and another edge "a" from this to first Intpipe,
     * 			 edge "b" from second Intpipe to this and another edge "b" from this to second Intpipe)
     * 			Output child Intpipe of this with edge labeled "gcd".
     * @modifies graph
     * @effects simulate 1 iteration of euclidean algorithm . this gets 2 integers from 2 parents Intpipes with edges labeled
     * 			"a" and "b" respectively and perform euclidean algorithm for finding gcd of a and b.
     * 			The final result after the algorithm ends is saved into the child IntPipe with edge "gcd".
     * 			mid-results of the algorithm saved into parents Intpipes.
     * 			if the parents Intpipes contains more then one Integer then do nothing

     */
	public void simulate(BipartiteGraph<String> graph) {
		String label = graph.getNodeLabelByJob(this);
		IntPipe aPipe = (IntPipe)graph.getJob(graph.getParentByEdgeLabel(label, "a"));
		IntPipe bPipe = (IntPipe)graph.getJob(graph.getParentByEdgeLabel(label, "b"));				
		IntPipe output = (IntPipe)graph.getJob(graph.getChildByEdgeLabel(label, "gcd")); 

		if(aPipe.listContents().size()!=1 || bPipe.listContents().size()!=1 ) return;
		
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
