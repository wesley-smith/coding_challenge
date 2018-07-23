import java.util.ArrayList;

public class GNodeFunctions {

    public ArrayList walkGraph(GNode gNode) {
        ArrayList allNodes = new ArrayList();
        allNodes.add(gNode);
        GNode[] children = gNode.getChildren();
        if (children.length == 0) {
            // Reached a leaf, no more childNodes
            return allNodes;
        }

        // TODO - this will break if two nodes share a child, there will be duplicates
        for (GNode childNode : children) {
            try {
                allNodes.addAll(walkGraph(childNode));
            } catch (NullPointerException e) {
                System.err.println("NullPointerException caught adding new nodes: " + e.getMessage());
            }
        }

        return allNodes;
    }

    public ArrayList paths(GNode gNode) {
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
