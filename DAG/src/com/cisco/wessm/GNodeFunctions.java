package com.cisco.wessm;

import java.util.ArrayList;

public class GNodeFunctions {

    public static ArrayList walkGraph(GNode gNode) {
        ArrayList<GNode> allNodes = new ArrayList<>();
        allNodes.add(gNode);
        GNode[] children = gNode.getChildren();
        if (children.length == 0) {
            // Reached a leaf, no more childNodes
            return allNodes;
        }

        for (GNode childNode : children) {
            ArrayList<GNode> childNodeGraph = walkGraph(childNode);
            for (GNode node : childNodeGraph) {
                if (! allNodes.contains(node)) {
                    // Only add nodes that aren't present already
                    allNodes.add(node);
                }
            }
        }

        return allNodes;
    }

    public static ArrayList paths(GNode gNode) {
        ArrayList<ArrayList<GNode>> allPaths = new ArrayList<>();
        ArrayList<GNode> path = new ArrayList<>();
        path.add(gNode);
        GNode[] children = gNode.getChildren();

        if (children.length == 0) {
            // Reached a leaf, no more childNodes
            allPaths.add(path);
            return allPaths;
        }

        for (GNode childNode : children) {
            ArrayList<ArrayList<GNode>> childPaths = paths(childNode);
            for (ArrayList<GNode> childPath : childPaths) {
                childPath.add(0, gNode);
                allPaths.add(childPath);
            }
        }

        return allPaths;
    }
}
