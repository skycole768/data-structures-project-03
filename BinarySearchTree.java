


/**
 * Class that creates BinarySearchTree objects, which are tree like structures made up of
 * nodes, with the initial node being the root. Each node possibly has a left and
 * right child, with nodes containing values less than the parent's(the node preceding the child)
 * going on the left, and nodes with value exceeding that of the parent's, going onto the left.
 */
public class BinarySearchTree<T extends Comparable<T>> {

    private NodeType<T> root; // begining node of binary search tree
    private NodeType<T> currentPos; // iterative placeholder node
    private int leafCount; // number of leaf nodes in the bst

    /**
     * Constructor that initializes binary search tree object
     */
    BinarySearchTree() {
        root = null;
        currentPos = root;
    }

    /**
     * Function that inserts a not already existing node, with the info value of key, into the
     * binary search tree object.
     */
    void insert(T key) {
        NodeType<T> newNode = new NodeType<T>(); // node holding key value
        newNode.info = key;

        if(root == null) {
            root = newNode;
            currentPos = root;
            return;
        }

        boolean found =  retrieve(key); // true if key value is already in the tree

        if(!found) {

            if(currentPos.info.compareTo(key) >= 1) {
                currentPos.left = newNode; // insert on left side of tree
            } else {
                currentPos.right = newNode; //insert om right side of tree
            }
        } else {
            System.out.println("The item already exists in the tree.");
        }
        currentPos = root;

    }

    /**
     ** Function that prints the info values in binary searcg tree object, in order(numerically/
     alphabetically/etc..)
    */
    void inOrder(){
        print(root);
    }

    /**
     * Function that deletes an already existing node, with the info value of key, from the
     * binary search tree object.
     */
    void delete(T key){
        if (root == null) {
            System.out.println("You cannot delete from an empty list.");
        }

        boolean found =  retrieve(key); // will iterate currentPos
        NodeType<T> parent = getParent(key, root); // parent node of node to be deleted

        if (found) {
            if(currentPos.left == null && currentPos.right == null) {
                if(parent.left != null && parent.left.info.compareTo(key) == 0) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }

                currentPos = null;
            } else if(currentPos.left == null) {
                if(parent.left != null && parent.left.info.compareTo(key) == 0) {
                    parent.left = currentPos.right;
                } else {
                    parent.right = currentPos.right;
                }
                currentPos = currentPos.right;
            }  else if(currentPos.right == null) {
                if(parent.left != null && parent.left.info.compareTo(key) == 0) {
                    parent.left = currentPos.left;
                } else {
                    parent.right = currentPos.left;
                }
                currentPos = currentPos.left;
            } else { // if node has two children, it will replece deleted node with the immediate
                // predecessor
                NodeType<T> temp = currentPos; // node to be deleted
                T item = getPredecessor(currentPos.left); //predecessor

                delete(item);
                temp.info = item;
            }
            currentPos = root;
        }
    }

    /**
     * Function that returns the parent node, so the node that has the node with the info
     * value of key as either  it's left or right in the bst. theRoot is the the current
     * node that is being checked to see if it's the parent.
     */
    NodeType<T> getParent(T key, NodeType<T> theRoot) {

        NodeType<T> temp = null;

        while(theRoot != null && theRoot.info.compareTo(key) != 0) {
            temp = theRoot;
            if(theRoot.info.compareTo(key) >= 1) {
                theRoot = theRoot.left;
            } else {
                theRoot  = theRoot.right;
            }
        }

        return temp;
    }


    /**
     * Function that returns the node's info of the value that directly preceeds
     * the node theRoot's info value , in alpgabtical/numeric/etc.. order.
     */
    T getPredecessor(NodeType<T> theRoot) {

        while(theRoot.right != null)
            theRoot = theRoot.right;
        T key = theRoot.info;
        return key;
    }


    /**
     * Function that returns true if the info given by item, matches a node already in the
     * bst and false, if otherwise.
     */
    boolean retrieve(T item) {
        boolean found = false;


        NodeType<T> temp = root;
        while (temp != null && !found){
            currentPos = temp;
            if(temp.info.compareTo(item) >= 1) {
                temp = temp.left;
            } else if (temp.info.compareTo(item) <= -1) {
                temp  = temp.right;
            } else {
                found = true;
            }
        }

        return found;

    }

    /**
     * Helper function that prints theRoot's value if they only have a single child within
     * the bst.
     */
    void printSingleParent( NodeType<T> theRoot){

        if(theRoot == null) return;

        printSingleParent(theRoot.left);

        if ((theRoot.left == null && theRoot.right != null) || (theRoot.right == null &&
        theRoot.left != null)) {
            System.out.print(theRoot.info);
            System.out.print(" ");
        }

        printSingleParent(theRoot.right);
    }


    /**
     * Function that prints sll the Node's value in the bst if they only have a single child
     */
    void getSingleParent() {
        printSingleParent(root);
    }

    /**
     * Function that prints the Node's value in the bst that are at the same height as the
     * given by key and it's correpsonding node in the tree, as long as they are not siblings,
     * meaning that it has a different parent node.
     */
    void getCousins(T key) {
        boolean found =  retrieve(key);

        if(!found) {
            System.out.println("Item not found in tree");
            return;
        }

        int level = 0;
        int count = 0;

        level = getLevel(root, key, level);
        printLevel(key, level, root, count);

    }

    /**
     * Helper Function that returns the key's corresponding node in the bst height if theRoot's
     * value matches that of the key, with the level being a value the value that increases by one
     * as the function continues to check for the presence of the key's node on each level.
     */
    int getLevel(NodeType<T> theRoot, T key, int level) {

        if (theRoot == null)
            return 0;

        if (theRoot.info.compareTo(key) == 0)
            return level;


        if (theRoot.left != null && theRoot.info.compareTo(key) >= 1) {
            return getLevel(theRoot.left, key, level + 1);
        }

        if( theRoot.right == null) {
            return 0;
        }

        return getLevel(theRoot.right, key, level + 1);
    }

    /**
     * Helper function that prints the nodes at the height of the tree as given by level
     * if the count, that increases as the function goes through each level,
     * matches the specified level, with the theRoot moving down the levels with
     * each call.
     */
    void printLevel( T key, int level, NodeType<T> theRoot, int count) {

        if (theRoot == null)
            return;

        printLevel(key, level, theRoot.left, count + 1);

        NodeType<T> parent = getParent(key, root);

        if(parent == null) {
            return;
        }

        if (count == level && theRoot.info != key && theRoot != parent.left &&
        theRoot != parent.right){

            System.out.print(theRoot.info);
            System.out.print(" ");
        }

        printLevel(key, level, theRoot.right, count + 1);
    }

    /**
     * Function that returns the number of leaf nodes in the bst object, meaning
     * node with no children.
     */
    int getNumLeafNodes() {
        leafCount = 0;
        findNumLeafNodes(root);
        return leafCount;
    }

    /**
     * Helper function that iterates through the bst starting from theRoot node and increases
     * the variable leafCount as nodes with no children are found.
     */
    void findNumLeafNodes(NodeType<T> theRoot) {

        if(theRoot == null) return;

        findNumLeafNodes(theRoot.left);

        if (theRoot.left == null && theRoot.right == null) {
            leafCount++;
        }
        findNumLeafNodes(theRoot.right);

    }

    /** Helper function thhat prints the nodes from the bst object in numeric/alphabetic/etc ...
     * order, starting form the node specfied by theRoot.
     */
    void print(NodeType<T> theRoot){
        if(theRoot == null) return;

        print(theRoot.left);
        System.out.print(theRoot.info);
        System.out.print(" ");
        print(theRoot.right);
    }

};
