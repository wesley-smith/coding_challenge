public class MyGNode implements GNode {
    private String nodeName;
    private GNode[] childNodes;

    public MyGNode(String name) {
        nodeName = name;
        childNodes = new GNode[0];
    }

    public MyGNode(String name, GNode[] children) {
        nodeName = name;
        childNodes = children;
    }

    public String getName() {
        return nodeName;
    };

    public GNode[] getChildren() {
        return childNodes;
    };
}
