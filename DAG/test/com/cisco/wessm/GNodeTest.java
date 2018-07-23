package com.cisco.wessm;

import com.cisco.wessm.GNode;
import com.cisco.wessm.MyGNode;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

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
        GNode[] expected = {gNodeB, gNodeC, gNodeD};
        assertEquals(expected, gNodeA.getChildren());
    }

    @Test
    public void testWalkGraph1() {
        ArrayList<GNode> actual = GNodeFunctions.walkGraph(gNodeA);
        ArrayList<GNode> expected = new ArrayList<>();
        expected.add(gNodeA);
        expected.add(gNodeB);
        expected.add(gNodeE);
        expected.add(gNodeF);
        expected.add(gNodeC);
        expected.add(gNodeG);
        expected.add(gNodeH);
        expected.add(gNodeI);
        expected.add(gNodeD);
        expected.add(gNodeJ);
        assertEquals(expected, actual);
    }

    @Test
    public void testPaths1() {
        ArrayList<ArrayList<GNode>> actual = GNodeFunctions.paths(gNodeA);
        ArrayList<ArrayList<GNode>> expected = new ArrayList<>();

        ArrayList<GNode> path1 = new ArrayList<>();
        path1.add(gNodeA);

        ArrayList<GNode> path2 = new ArrayList<>(path1);
        ArrayList<GNode> path3 = new ArrayList<>(path1);
        ArrayList<GNode> path4 = new ArrayList<>(path1);
        ArrayList<GNode> path5 = new ArrayList<>(path1);
        ArrayList<GNode> path6 = new ArrayList<>(path1);

        path1.add(gNodeB);
        path1.add(gNodeE);

        path2.add(gNodeB);
        path2.add(gNodeF);

        path3.add(gNodeC);
        path3.add(gNodeG);

        path4.add(gNodeC);
        path4.add(gNodeH);

        path5.add(gNodeC);
        path5.add(gNodeI);

        path6.add(gNodeD);
        path6.add(gNodeJ);

        expected.add(path1);
        expected.add(path2);
        expected.add(path3);
        expected.add(path4);
        expected.add(path5);
        expected.add(path6);

        assertEquals(expected, actual);
    }
}
