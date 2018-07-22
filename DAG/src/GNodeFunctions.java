import java.util.ArrayList;

public class GNodeFunctions {

    public ArrayList walkGraph(GNode gNode) {
        ArrayList allNodes = new ArrayList();
        allNodes.add(gNode);
        GNode[] children = gNode.getChildren();
        if (children.length == 0) {
            // Reached a leaf, no more children
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
}
