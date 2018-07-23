import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GNodeTest {
    private GNode gNodeA;
    private GNode gNodeB;
    private GNode gNodeC;
    private GNode gNodeD;
    private GNode gNodeE;
    private GNode gNodeF;
    private GNode gNodeG;
    private GNode gNodeH;
    private GNode gNodeI;
    private GNode gNodeJ;

    @Before
    public void setUp() {
        // Create all the nodes
        gNodeE = new MyGNode("E");
        gNodeF = new MyGNode("F");
        gNodeG = new MyGNode("G");
        gNodeH = new MyGNode("H");
        gNodeI = new MyGNode("I");
        gNodeJ = new MyGNode("J");
        gNodeB = new MyGNode("B", new GNode[] {gNodeE, gNodeF});
        gNodeC = new MyGNode("C", new GNode[] {gNodeG, gNodeH, gNodeI});
        gNodeD = new MyGNode("D", new GNode[] {gNodeJ});
        gNodeA = new MyGNode("A", new GNode[] {gNodeB, gNodeC, gNodeD});
    }

    @Test
    public void testGetChildren1() {
        assertEquals(null, gNodeA.getChildren());
    }

    @Test
    public void testWalkGraph1() {
        walkGraph(gNodeA);
    }

}
