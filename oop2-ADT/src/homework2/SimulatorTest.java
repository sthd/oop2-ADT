package homework2;

import static org.junit.Assert.*;

import org.junit.Test;

public class SimulatorTest {

	@Test
	public void testExample() {
	SimulatorTestDriver driver = new SimulatorTestDriver();
	String plusSimulator = "PlusSimulator";
	//create simulator
	driver.createSimulator(plusSimulator);
	testPlus(driver,plusSimulator);
	
	
	}
	
	public void testPlus(SimulatorTestDriver d ,String s) {
		//add pipes
		d.addPipe(s, "input1");
		d.addPipe(s, "input2");
		d.addPipe(s, "input3");
		d.addPipe(s, "output");
		
		//add Filter
		d.addPlusFilter(s, "PlusFilter");
		//adding edges
		d.addEdge(s, "input1", "PlusFilter", "e1");
		d.addEdge(s, "input2", "PlusFilter", "e2");
		d.addEdge(s, "input3", "PlusFilter", "e3");
		d.addEdge(s, "PlusFilter", "output", "e4");
		
		d.injectInput(s, "input1", 2);
		d.injectInput(s, "input1", 3);
		d.injectInput(s, "input1", 12);
		d.injectInput(s, "input1", 8);
		d.injectInput(s, "input2", 9);
		d.injectInput(s, "input2", 4);
		
		//check
		assertEquals("wrong pipe contents", "2 3 12 8", d.listContents(s, "input1"));
		assertEquals("wrong pipe contents", "9 4", d.listContents(s, "input2"));
		assertEquals("wrong pipe contents", "", d.listContents(s, "input3"));
		assertEquals("wrong pipe contents", "", d.listContents(s, "output"));
		d.simulate(s);
		assertEquals("wrong pipe contents", "3 12 8", d.listContents(s, "input1"));
		assertEquals("wrong pipe contents", "4", d.listContents(s, "input2"));
		assertEquals("wrong pipe contents", "", d.listContents(s, "input3"));
		assertEquals("wrong pipe contents", "11", d.listContents(s, "output"));
		d.simulate(s);
		assertEquals("wrong pipe contents", "12 8", d.listContents(s, "input1"));
		assertEquals("wrong pipe contents", "", d.listContents(s, "input2"));
		assertEquals("wrong pipe contents", "", d.listContents(s, "input3"));
		assertEquals("wrong pipe contents", "11 7", d.listContents(s, "output"));
		d.simulate(s);
		assertEquals("wrong pipe contents", "8", d.listContents(s, "input1"));
		assertEquals("wrong pipe contents", "", d.listContents(s, "input2"));
		assertEquals("wrong pipe contents", "", d.listContents(s, "input3"));
		assertEquals("wrong pipe contents", "12 11 7", d.listContents(s, "output"));
		
		
	}
}
