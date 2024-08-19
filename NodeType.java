
/**
 * Class for a NodeType object which holds the variables info, of Type T, and NodeType,
 * also of type T, left and right.
 */

public class NodeType<T extends Comparable <T>> {

    public T info; // info of current node
    public NodeType<T> left; // node to left of current node
    public NodeType<T> right; // node to right of current node
};
