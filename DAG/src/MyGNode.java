import java.util.ArrayList;

public class MyGNode implements GNode {
    public String nodeName;
    public ArrayList<GNode> children;

    public MyGNode(String name) {
        nodeName = name;
        children = new ArrayList<>();
    }

    public void addChild(GNode childNode) {
        children.add(childNode);
    }

    public String getName() {
        return nodeName;
    };

    public GNode[] getChildren() {
        GNode[] childrenArray = new GNode[children.size()];
        return children.toArray(childrenArray);
    };
}
