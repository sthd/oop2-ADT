package homework2;

import java.util.HashMap;
import java.util.Map;

public class TestBipart {

    public static void main(String args[]) {


        BipartiteGraph objectBipartiteGraph = new BipartiteGraph<>();
        String s1 = "1111111";
        String s2 = "2222222";
        String e12 = "121212";
        objectBipartiteGraph.addBlackNode(s1);
        objectBipartiteGraph.addWhiteNode(s2);
        objectBipartiteGraph.addEdge(s1, s2, e12);






    }
}



