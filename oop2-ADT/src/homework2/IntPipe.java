package homework2;

import java.util.*;
//TODO overview
public class IntPipe implements Simulatable<String> {
	//TODO add rep invariant
	//TODO add Abstraction function
	
	private List<Integer> start;
	private List<Integer> end;
	
	//TODO add specs
	public IntPipe() {
		start = new ArrayList<>();
		end = new ArrayList<>();
	}
	//TODO add specs
	public void add(Integer n) {
		start.add(n);
	}
	//TODO add specs
	public Integer getNext() {
		return end.remove(0);
	}
	
	//TODO add specs
	@Override
	public void simulate(BipartiteGraph<String> graph) {
		end.addAll(start);
		start.clear();
	}
	
}
