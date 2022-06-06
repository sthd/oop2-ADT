package homework2;

import java.util.*;

/*
 * overview:
 * This represent abstraction of pipe that transfer Integers from the start of the pipe to the end of it
 * by calling this.simulate(). 
 * 
 * */
public class IntPipe implements Simulatable<String> {
	/*
	 * Representation Invariant:
	 * for each in 0<i<start.size and 0<j<end.size
	 * start[i] != null && end[j] != null
	*/
	
	/*Abstraction Function:
	 * AF(c) = representation of Int pipe so that
	 * c.start =  all the integers in the start of  pipe
	 * c.end = all the integers in the end of pips
	*/
	
	private List<Integer> start;
	private List<Integer> end;
	
	/**
     * @modifies this
     * @effects initialize this to be empty
     */
	public IntPipe() {
		start = new ArrayList<>();
		end = new ArrayList<>();
	}
	/**
     * @modifies this
     * @effects add n to the start of this
     */
	public void add(Integer n) {
		start.add(n);
	}
	/**
     * @modifies this
     * @effects will get the oldest number from the end of pipe and remove it from this
     */
	public Integer getNextandRemove() {
		return end.remove(0);
	}
	/**
     * @effects return list of all the Integers from (start and end of the pipe) in desceneding order
     * 			from old to new (the first Integer came least recently and the last Integer came most recently)
     */
	public List<Integer> listContents() {
		List<Integer> contents = new ArrayList<>(end);
		contents.addAll(start);
		return contents;
	}
	
	/**
     * @modifies this
     * @effects simulate 1 round of this. it will append all the numbers from start of the pipe
     * 			to the end of the pipe. 
     */
	@Override
	public void simulate(BipartiteGraph<String> graph) {
		end.addAll(start);
		start.clear();
	}
	
}
