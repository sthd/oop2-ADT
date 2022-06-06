package homework2;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;


/**
 * homework2.BipartiteGraphTest contains JUnit block-box unit tests for BipartiteGraph.
 */
public class BipartiteGraphTest {

	@Test
    public void testExample() {
        BipartiteGraphTestDriver driver = new BipartiteGraphTestDriver();
        
        //create a graph
        driver.createGraph("graph1");
        
        //add a pair of nodes
        driver.addBlackNode("graph1", "n1");
        driver.addWhiteNode("graph1", "n2");
        
        //add an edge
        driver.addEdge("graph1", "n1", "n2", "edge");
        //check neighbors
        Assert.assertEquals("wrong black nodes", "n1", driver.listBlackNodes("graph1"));
        Assert.assertEquals("wrong white nodes", "n2", driver.listWhiteNodes("graph1"));
        Assert.assertEquals("wrong children", "n2", driver.listChildren ("graph1", "n1"));
        Assert.assertEquals("wrong children", "", driver.listChildren ("graph1", "n2"));
        Assert.assertEquals("wrong parents", "", driver.listParents ("graph1", "n1"));
        Assert.assertEquals("wrong parents", "n1", driver.listParents ("graph1", "n2"));
        
        testExample2(driver);
    }
	
	
	//Run example like in HW2 introduction 
    public void testExample2(BipartiteGraphTestDriver driver) {
    	//create a graph
        driver.createGraph("graph2");
        
        //add a pair of nodes
        driver.addBlackNode("graph2", "A");
        driver.addBlackNode("graph2", "D");
        driver.addWhiteNode("graph2", "B");
        driver.addWhiteNode("graph2", "C");
        
        //add an edge
        driver.addEdge("graph2", "A", "B", "x");
        driver.addEdge("graph2", "B", "A", "y");
        driver.addEdge("graph2", "B", "D", "x");
        driver.addEdge("graph2", "C", "D", "z");
        
        //check neighbors
        Assert.assertEquals("wrong black nodes", "A D", driver.listBlackNodes("graph2"));
        Assert.assertEquals("wrong white nodes", "B C", driver.listWhiteNodes("graph2"));
        Assert.assertEquals("wrong children", "A D", driver.listChildren ("graph2", "B"));
        Assert.assertEquals("wrong children", "B", driver.listChildren ("graph2", "A"));
        Assert.assertEquals("wrong children", "D", driver.listChildren ("graph2", "C"));
        Assert.assertEquals("wrong children", "", driver.listChildren ("graph2", "D"));
        Assert.assertEquals("wrong parents", "B", driver.listParents ("graph2", "A"));
        Assert.assertEquals("wrong parents", "A", driver.listParents ("graph2", "B"));
        Assert.assertEquals("wrong parents", "B C",driver.listParents ("graph2", "D"));
        Assert.assertEquals("wrong Child By edge", "B",driver.getChildByEdgeLabel("graph2", "A", "x"));
        Assert.assertEquals("wrong Child By edge", "A",driver.getChildByEdgeLabel("graph2", "B", "y"));
        Assert.assertEquals("wrong Child By edge", "D",driver.getChildByEdgeLabel("graph2", "B", "x"));
        Assert.assertEquals("wrong Child By edge", "D",driver.getChildByEdgeLabel("graph2", "C", "z"));
        Assert.assertEquals("wrong Child By edge", "A",driver.getParentByEdgeLabel("graph2", "B", "x"));
        Assert.assertEquals("wrong Child By edge", "B",driver.getParentByEdgeLabel("graph2", "A", "y"));
        Assert.assertEquals("wrong Child By edge", "B",driver.getParentByEdgeLabel("graph2", "D", "x"));
        Assert.assertEquals("wrong Child By edge", "C",driver.getParentByEdgeLabel("graph2", "D", "z"));
        
    	
    }
  
}
