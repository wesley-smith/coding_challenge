package com.cisco.wessm;

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

    private GNode gNodeM;
    private GNode gNodeN;
    private GNode gNodeO;
    private GNode gNodeP;
    private GNode gNodeQ;

    private GNode gNodeW;
    private GNode gNodeX;
    private GNode gNodeY;
    private GNode gNodeZ;

    @Before
    public void setUp() {
        // Create all the nodes
        // GRAPH 1 - Designated in assignment prompt
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

        // GRAPH 2
        //    M   N
        //   / \ / \
        //  O   P   Q
        gNodeO = new MyGNode("O");
        gNodeP = new MyGNode("P");
        gNodeQ = new MyGNode("Q");
        gNodeM = new MyGNode("M", new GNode[] {gNodeO, gNodeP});
        gNodeN = new MyGNode("N", new GNode[] {gNodeP, gNodeQ});

        // GRAPH 3
        //     W
        //    / \
        //   X   Y
        //    \ /
        //     Z
        gNodeZ = new MyGNode("Z");
        gNodeX = new MyGNode("X", new GNode[] {gNodeZ});
        gNodeY = new MyGNode("Y", new GNode[] {gNodeZ});
        gNodeW = new MyGNode("W", new GNode[] {gNodeX, gNodeY});
    }

    // TESTING ON GRAPH 1
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

    // TESTING ON GRAPH 2
    @Test
    public void testWalkGraph2() {
        // Since each node cannot access its parent node(s), walking this graph will depend on the starting node
        ArrayList<GNode> actual = GNodeFunctions.walkGraph(gNodeM);
        ArrayList<GNode> expected = new ArrayList<>();
        expected.add(gNodeM);
        expected.add(gNodeO);
        expected.add(gNodeP);

        assertEquals(expected, actual);
    }

    @Test
    public void testWalkGraph3() {
        // Since each node cannot access its parent node(s), walking this graph will depend on the starting node
        ArrayList<GNode> actual = GNodeFunctions.walkGraph(gNodeN);
        ArrayList<GNode> expected = new ArrayList<>();
        expected.add(gNodeN);
        expected.add(gNodeP);
        expected.add(gNodeQ);

        assertEquals(expected, actual);
    }

    @Test
    public void testPaths2() {
        ArrayList<ArrayList<GNode>> actual = GNodeFunctions.paths(gNodeM);
        ArrayList<ArrayList<GNode>> expected = new ArrayList<>();

        ArrayList<GNode> path1 = new ArrayList<>();
        path1.add(gNodeM);

        ArrayList<GNode> path2 = new ArrayList<>(path1);

        path1.add(gNodeO);

        path2.add(gNodeP);

        expected.add(path1);
        expected.add(path2);

        assertEquals(expected, actual);
    }

    // TESTING ON GRAPH 3
    @Test
    public void testWalkGraph4() {
        ArrayList<GNode> actual = GNodeFunctions.walkGraph(gNodeW);
        ArrayList<GNode> expected = new ArrayList<>();
        expected.add(gNodeW);
        expected.add(gNodeX);
        expected.add(gNodeZ);
        expected.add(gNodeY);

        assertEquals(expected, actual);
    }

    @Test
    public void testPaths3() {
        ArrayList<ArrayList<GNode>> actual = GNodeFunctions.paths(gNodeW);
        ArrayList<ArrayList<GNode>> expected = new ArrayList<>();

        ArrayList<GNode> path1 = new ArrayList<>();
        path1.add(gNodeW);

        ArrayList<GNode> path2 = new ArrayList<>(path1);

        path1.add(gNodeX);
        path1.add(gNodeZ);

        path2.add(gNodeY);
        path2.add(gNodeZ);

        expected.add(path1);
        expected.add(path2);

        assertEquals(expected, actual);
    }
}
