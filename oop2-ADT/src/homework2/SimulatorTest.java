package homework2;

import static org.junit.Assert.*;

import org.junit.Test;

public class SimulatorTest {

	@Test
	public void testExample() {
	SimulatorTestDriver driver = new SimulatorTestDriver();
	String plusSim = "PlusSimulator";
	String GCDsim= "GCDSimulator";
	//create simulator
	driver.createSimulator(plusSim);
	testPlus(driver,plusSim);
	
	driver.createSimulator(GCDsim);
	testGCD(driver,GCDsim);
	
	
	}
	
	public void testGCD(SimulatorTestDriver d ,String sim) {
		//add pipes
		d.addPipe(sim, "input1");
		d.addPipe(sim, "input2");
		d.addPipe(sim, "output");
		
		d.addGCDFilter(sim, "GCDFilter");
		
		d.addEdge(sim, "input1", "GCDFilter", "a");
		d.addEdge(sim, "input2", "GCDFilter", "b");
		d.addEdge(sim, "GCDFilter", "input1" , "a");
		d.addEdge(sim, "GCDFilter", "input2" , "b");
		d.addEdge(sim, "GCDFilter", "output" , "gcd");
		
		
		d.injectInput(sim, "input1", 18);
		d.injectInput(sim, "input2", 12);
		
		assertEquals("wrong pipe contents", "18", d.listContents(sim, "input1"));
		assertEquals("wrong pipe contents", "12", d.listContents(sim, "input2"));
		assertEquals("wrong pipe contents", "", d.listContents(sim, "output"));
		d.simulate(sim);
		assertEquals("wrong pipe contents", "12", d.listContents(sim, "input1"));
		assertEquals("wrong pipe contents", "6", d.listContents(sim, "input2"));
		assertEquals("wrong pipe contents", "", d.listContents(sim, "output"));
		d.simulate(sim);
		assertEquals("wrong pipe contents", "6", d.listContents(sim, "input1"));
		assertEquals("wrong pipe contents", "0", d.listContents(sim, "input2"));
		assertEquals("wrong pipe contents", "", d.listContents(sim, "output"));
		d.simulate(sim);
		assertEquals("wrong pipe contents", "", d.listContents(sim, "input1"));
		assertEquals("wrong pipe contents", "", d.listContents(sim, "input2"));
		assertEquals("wrong pipe contents", "6", d.listContents(sim, "output"));
		
	}
	
	
	public void testPlus(SimulatorTestDriver d ,String sim) {

		//add pipes
		d.addPipe(sim, "input1");
		d.addPipe(sim, "input2");
		d.addPipe(sim, "input3");
		d.addPipe(sim, "output");
		
		//add Filter
		d.addPlusFilter(sim, "PlusFilter");
		//adding edges
		d.addEdge(sim, "input1", "PlusFilter", "e1");
		d.addEdge(sim, "input2", "PlusFilter", "e2");
		d.addEdge(sim, "input3", "PlusFilter", "e3");
		d.addEdge(sim, "PlusFilter", "output", "e4");
		
		d.injectInput(sim, "input1", 2);
		d.injectInput(sim, "input1", 3);
		d.injectInput(sim, "input1", 12);
		d.injectInput(sim, "input1", 8);
		d.injectInput(sim, "input2", 9);
		d.injectInput(sim, "input2", 4);
		
		//check
		assertEquals("wrong pipe contents", "2 3 12 8", d.listContents(sim, "input1"));
		assertEquals("wrong pipe contents", "9 4", d.listContents(sim, "input2"));
		assertEquals("wrong pipe contents", "", d.listContents(sim, "input3"));
		assertEquals("wrong pipe contents", "", d.listContents(sim, "output"));
		d.simulate(sim);
		assertEquals("wrong pipe contents", "3 12 8", d.listContents(sim, "input1"));
		assertEquals("wrong pipe contents", "4", d.listContents(sim, "input2"));
		assertEquals("wrong pipe contents", "", d.listContents(sim, "input3"));
		assertEquals("wrong pipe contents", "11", d.listContents(sim, "output"));
		d.simulate(sim);
		assertEquals("wrong pipe contents", "12 8", d.listContents(sim, "input1"));
		assertEquals("wrong pipe contents", "", d.listContents(sim, "input2"));
		assertEquals("wrong pipe contents", "", d.listContents(sim, "input3"));
		assertEquals("wrong pipe contents", "11 7", d.listContents(sim, "output"));
		d.simulate(sim);
		assertEquals("wrong pipe contents", "8", d.listContents(sim, "input1"));
		assertEquals("wrong pipe contents", "", d.listContents(sim, "input2"));
		assertEquals("wrong pipe contents", "", d.listContents(sim, "input3"));
		assertEquals("wrong pipe contents", "11 7 12", d.listContents(sim, "output"));
		d.simulate(sim);
		assertEquals("wrong pipe contents", "", d.listContents(sim, "input1"));
		assertEquals("wrong pipe contents", "", d.listContents(sim, "input2"));
		assertEquals("wrong pipe contents", "", d.listContents(sim, "input3"));
		assertEquals("wrong pipe contents", "11 7 12 8", d.listContents(sim, "output"));
		
		
		
	}
}
