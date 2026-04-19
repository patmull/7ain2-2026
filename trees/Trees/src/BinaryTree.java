public class BinaryTree {

    NodeIndexed root;

    BinaryTree leftSubtree;
    BinaryTree rightSubtree;

    public BinaryTree(NodeIndexed root) {
        if (root == null) {
            this.root = null; // NOTICE root needs to be ever null, otherwise we would not be able to mark down the empty nodes (thus the above leafs) ==> and stop the recursion!
            this.leftSubtree = null;
            this.rightSubtree = null;
        } else {
            this.root = root;
            this.leftSubtree = new BinaryTree(null);
            this.rightSubtree = new BinaryTree(null);
        }
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public String searchSongByIndex(int searchedIndex) {
        if (this.isEmpty()) {
            return null;
        } else if (searchedIndex == this.root.getIndex()) { // BEST CASE: we can stop immidiatelly
            return this.root.getValue(); // NOTICE: (+) with binary tree + OOP, // you can easily append another info, // e.g. the artists, length, here...// and we can get all of this by just 1 index optimally stored in the binary tree!
        } else if (searchedIndex < this.root.getIndex()) { // NOTICE: We compare now the indexes. The strings would be harder to compare...
            return this.leftSubtree.searchSongByIndex(searchedIndex);
        } else {
            return this.rightSubtree.searchSongByIndex(searchedIndex);
        }
    }

    public boolean insert(NodeIndexed newNode) {
        if (this.isEmpty()) {
            this.root = newNode;
            this.leftSubtree = new BinaryTree(null);
            this.rightSubtree = new BinaryTree(null);
        } else if (newNode.getIndex() < this.root.getIndex()) {
            // recursive finding of appropriate spot
            this.leftSubtree.insert(newNode);
        } else {
            // recursive finding of appropriate spot
            this.rightSubtree.insert(newNode);
        }

        return true;
    }

    public boolean delete(int index) {
        if (this.root == null)
            return false;
        deleteNode(this, index);
        return true;
    }

    private BinaryTree deleteNode(BinaryTree subtree, int searchedIndex) {
        // BASE CASE
        if (subtree.isEmpty()) {
            return subtree;
        }

        if (searchedIndex < subtree.root.getIndex()) {
            subtree.leftSubtree = deleteNode(subtree.leftSubtree, searchedIndex);
        } else if (searchedIndex > subtree.root.getIndex()) {
            subtree.rightSubtree = deleteNode(subtree.rightSubtree, searchedIndex);
        } else { // (searchedIndex == subtree.root.getIndex())
            // Leaf or 1 Child case:
            if (subtree.leftSubtree.isEmpty()) {
                return subtree.rightSubtree;
            } else if (subtree.rightSubtree.isEmpty()) {
                return subtree.leftSubtree;
            }
            // 2 Children case:
            BinaryTree replacingTree = getSubtreeWithMinRoot(subtree.rightSubtree);

            // Swap the nodes
            subtree.root = replacingTree.root;

            subtree.rightSubtree = deleteNode(subtree.rightSubtree, replacingTree.root.getIndex());
        }

        return subtree;
    }

    public BinaryTree getSubtreeWithMinRoot(BinaryTree childSubtree) {
        BinaryTree _childSubTree = childSubtree;
        while(_childSubTree.leftSubtree != null) {
            if(_childSubTree.leftSubtree.leftSubtree == null) {
                break;
            } else {
                _childSubTree = _childSubTree.leftSubtree;
            }
        }

        return _childSubTree;
    }

    public String binaryTreeTraversal(int depth) {
        // NOTE: In practise, we would do some additional things
        // here like some computation or better display of the graph...
        if (this.isEmpty()) {
            return "";
        } else {
            String subtreeStr = this.root.getValue();
                    //+ " id: " + this.root.getIndex() + " depth: " + depth + "\n";
            subtreeStr += this.leftSubtree.binaryTreeTraversal(depth - 1)
                    // + "\n"
            ;
            subtreeStr += this.rightSubtree.binaryTreeTraversal(depth - 1)
                    // + "\n"
            ;
            return subtreeStr
                    //+ "\n"
            ;
        }

        // Exercise: try to implement now for the "general" tree (not binary)
    }

    public String binaryTreePostTraversal() {
        // NOTE: In practise, we would do some additional things
        // here like some computation or better display of the graph...
        if (this.isEmpty()) {
            return "";
        }

        // If it's a leaf node (just a number), don't add parentheses
        if (this.leftSubtree.isEmpty() && this.rightSubtree.isEmpty()) {
            return this.root.getValue();
        }

        String subtreeStr = "(" + this.leftSubtree.binaryTreePostTraversal();
        subtreeStr += this.root.getValue();
        subtreeStr += this.rightSubtree.binaryTreePostTraversal();
        subtreeStr += ")";
                //+ "\n"
        return subtreeStr;

    }
}
