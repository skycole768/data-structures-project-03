Skyler Coleman spc69655@uga.edu

    getSingleParent function:

        void getSingleParent() {
        printSingleParent(root); // 2(T(n/2) + 1
    } // end of function

        void printSingleParent( NodeType theRoot){

        if(theRoot == null) return; //constant 1 (Base case)

        printSingleParent(theRoot.left); // T(n/2)

       if ((theRoot.left == null and theRoot.right != null) or (theRoot.right == null and
       theRoot.left != null)) {
        print(theRoot.info); // (constant 1)
        print(" "); // (constant 1)
       }

        printSingleParent(theRoot.right); //  T(n/2)
    }

    recurrence relation for getSingleParent = 2(T(n/2) + 1

    Master method:a = 2, b = 2, d = 0

    since a > b^d O(n) = n^(logb(a))

    So time complexity for getSingleParent = O(n^(log2(2)) = O(n)

    getLeafNodes function:

     int getNumLeafNodes() {
        leafCount = 0; //constant 1
         findNumLeafNodes(root); //  2T(n/2) + 1
         return leafCount; //constant 1
    } // end of function

    void findNumLeafNodes(NodeType theRoot) {

        if(theRoot == null) return; //constant 1 (Base case)

        findNumLeafNodes(theRoot.left); //  T(n/2)

       if (theRoot.left == null && theRoot.right == null) {
           leafCount++; //constant 1
       }
       findNumLeafNodes(theRoot.right); //  T(n/2)

    }

    recurrence relation for getNumLeafNodes = 2(T(n/2) + 1

    Master method: a = 2, b = 2, d = 0

    since a > b^d O(n) = n^(logb(a))

    So time complexity for getLeafNodes = O(n^(log2(2)) = O(n)

    getCousins function:

        void getCousins(T key) {
        int level = 0; //constant
        int count = 0; //constant

        level = getLevel(root, key, level); // T(n/2) + 1
        printLevel(key, level, root, count); //  2T(n/2) + n/2 + 1

    } // end of function

    int getLevel(NodeType theRoot, T key, int level) {
        if (theRoot == null)
            return 0; //constant (Base case)

        if (theRoot.info.compareTo(key) == 0)
            return level; // constant (Base case)


        if (theRoot.left != null and theRoot.info.compareTo(key) >= 1)
            return getLevel(theRoot.left, key, level + 1); //  T(n/2)

        if( theRoot.right == null) {
            return 0;  //constant
        }

        return getLevel(theRoot.right, key, level + 1); //  T(n/2)
    }

    void printLevel( T key, int level, NodeType<T> theRoot, int count) {

        if (theRoot == null)
            return;  // constant (Base case)
        printLevel(key, level, theRoot.left, count + 1); // T(n/2)


        NodeType<T> parent = getParent(key, root); //n/2 + 1

        if (count == level && theRoot.info != key && theRoot != parent.left &&
        theRoot != parent.right){

            System.out.print(theRoot.info); // constant
            System.out.print(" "); // constant
        }
        printLevel(key, level, theRoot.right, count + 1); // T(n/2)
    }

        NodeType getParent(T key, NodeType theRoot) {

        NodeType temp = null; //constant

        while(theRoot != null and theRoot.info.compareTo(key) != 0) { //n/2
            temp = theRoot; // constant
            if(theRoot.info.compareTo(key) >= 1) {
                theRoot = theRoot.left; //constant
            } else {
                theRoot  = theRoot.right;//constant
            }
        }

        return temp; //constant
    }


    recurrence relation for getCousins = 3(T(n/2) + 1/2n + 1

    Master method: a = 3, b = 2, d = 1

    since a > b^d O(n) = n^(logb(a))

    So time complexity for getCousins = O(n^(log2(3))
