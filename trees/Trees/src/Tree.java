public class Tree {

    Node rootNode;
    Tree[] subtrees; // e.g. Tree("Hi", [Tree(4,[]), Tree(1,[])])

    Tree(Node rootNode, Tree[] subtrees) {
        this.rootNode = rootNode;
        this.subtrees = subtrees;
    }

    public boolean isEmpty() {
        if (this.rootNode == null) {
            return true;
        }
        return false;
    }

    public int sizeEdges() {
        int size = 1;
        if (isEmpty()) { //  BASE CASE
            return 0;
        } else {
            return determineNumberOfEdgesRecursively(this.subtrees, size); //  NOTICE: another method because if we would call size(), the size would be always 0 since it would be zeroed out...
        }
    }

    public int size(int treeLevel) {
        if (isEmpty()) {
            return 0; // NOTE: This is usually never executed. Just for handling edge case...
        } else {
            treeLevel += 1;
            int size = 1; // count root automatically
            for (Tree subtree : this.subtrees) { // NOTICE: If we have children {}, this gets skipped automatically thanks to foreach
                if (!subtree.isEmpty()) {
                    System.out.println("rootNode: " + subtree.rootNode.getValue());
                } else {
                    System.out.println("rootNode DELETED");
                }
                System.out.print("subtree: ");
                for (Tree node : subtree.subtrees) {
                    System.out.print(node.rootNode.getValue() + ", ");
                }
                System.out.print("\n");
                size += subtree.size(treeLevel);
                System.out.println("counted size = " + size + " on tree level: " + treeLevel);
            } // if 0 subtress <=> child: {}, skip to 1
            return size;
        }
    }

    public int determineNumberOfEdgesRecursively(Tree[] subtrees, int size) {
        // NOTE: This might be actually easier to implement than the nodes...
        if (subtrees.length == 0) { // BASE
            return 1; // HALT
        } else { // RECURSIVE CASE
            for (Tree subtree : subtrees) { // HALT
                // size += determineTreeSizeRecursively(subtree.subtrees, subtrees.length);
                // size += 1;
                if (!subtree.isEmpty()) {
                    // continue down
                    size += determineNumberOfEdgesRecursively(subtree.subtrees, size); // RECUSRSIVE CALL (POTENTIALLY INFINITE)
                }
            }
            return size;
        }
    }


    public boolean deleteValue(String value) {
        // TODO:
        // NOTICE: This is simplified delete that deletes also all the children
        if (this.isEmpty()) {
            return false;
        } else {
            if(this.rootNode.getValue().equals(value)) {
                this.rootNode = null;
                return true;
            } else {
                boolean isDeleted;
                for (Tree tree : subtrees) {
                    isDeleted = tree.deleteValue(value); // we are still searching for the item we want to delete...
                    if (isDeleted) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public String treeTraversal(int depth) {
        // NOTE: In practise, we would do some additional things
        // here like some computation or better display of the graph...
        if (this.isEmpty()) {
            return "DELETED\n";
        } else {
            String subtreeStr = this.rootNode.getValue() + " depth: " + depth + "\n";

            for (Tree subtree : this.subtrees) {
                subtreeStr += subtree.treeTraversal(depth - 1);
            }

            return subtreeStr;
        }
    }

    public String treeTraversalPostOrder(int depth) {
        // NOTE: In practise, we would do some additional things
        // here like some computation or better display of the graph...
        if (this.isEmpty()) {
            return "\n";
        } else {
            String subtreeStr = "";

            for (Tree subtree : this.subtrees) {
                subtreeStr += subtree.treeTraversal(depth + 1);
            }
            subtreeStr += this.rootNode.getValue() + " depth: " + depth
                    + "\n";

            return subtreeStr;
        }

        // Exercise: try to implement now for the "general" tree (not binary)
    }
}
