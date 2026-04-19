//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        Tree[] subtree3 = {new Tree(new Node("flying at the tree level"), new Tree[0]),
                new Tree(new Node("gasoline"), new Tree[0])};
        // Tree[] subtree2 = {new Tree(new Node("entombed"), new Tree[0])};
        Tree[] subtree2 = {new Tree(new Node("entombed"), subtree3)};
        Tree[] subtrees1 = {
                new Tree(new Node("boy who blocked his own shot"), new Tree[0]),
                new Tree(new Node("could never be heaven"), new Tree[0]),
                new Tree(new Node("degausser"), subtree2),
                new Tree(new Node("how to save your life"), new Tree[0])
        };
        Tree tree1 = new Tree(new Node("aloc acoc"), subtrees1);
        System.out.println("Determining the size:");
        System.out.println(tree1.size(0));
        System.out.println("-----------");
        System.out.println("Tree traversal:");
        System.out.println(tree1.treeTraversal(0));
        tree1.deleteValue("degausser");

        System.out.println(tree1.size(0));
        System.out.println("Tree traversal after delete:");
        System.out.println(tree1.treeTraversal(0));

        System.out.println("Tree traversal post-order:");
        System.out.println(tree1.treeTraversalPostOrder(0));
        System.out.println(tree1.size(0));

        // NOTICE: We order by the index not by the value now...
        BinaryTree binaryTree = new BinaryTree(new NodeIndexed(5,"Aloc Acoc"));
        binaryTree.insert(new NodeIndexed(3,"Best of you"));
        binaryTree.insert(new NodeIndexed(7,"Hot N Cold"));
        binaryTree.insert(new NodeIndexed(2,"good day sunshine"));
        binaryTree.insert(new NodeIndexed(4,"entombed"));
        binaryTree.insert(new NodeIndexed(6,"Far far away"));
        binaryTree.insert(new NodeIndexed(8,"Degausser"));
        binaryTree.insert(new NodeIndexed(1,"Call on Me"));
        binaryTree.insert(new NodeIndexed(9,"Let it Be")); // NOTICE: alphabet does not matter now, indexes do

        System.out.println(binaryTree.searchSongByIndex(8));
        binaryTree.delete(8);
        System.out.println(binaryTree.searchSongByIndex(8));
        System.out.println(binaryTree.searchSongByIndex(6));
        System.out.println(binaryTree.searchSongByIndex(9));
        System.out.println(binaryTree.searchSongByIndex(4));
        System.out.println(binaryTree.searchSongByIndex(2));
        System.out.println(binaryTree.searchSongByIndex(3));
        System.out.println(binaryTree.searchSongByIndex(1));
        System.out.println(binaryTree.searchSongByIndex(7));
        binaryTree.delete(5);

        // binaryTree.binaryTreeTraversal();
        System.out.println("Binary tree traversal:");
        System.out.println(binaryTree.binaryTreeTraversal(0));

        BinaryTree arithmeticTree = new BinaryTree(new NodeIndexed(4, "*"));

        arithmeticTree.insert(new NodeIndexed(2, "-"));
        arithmeticTree.insert(new NodeIndexed(6, "/"));

        arithmeticTree.insert(new NodeIndexed(1, "7"));
        arithmeticTree.insert(new NodeIndexed(3, "5"));
        arithmeticTree.insert(new NodeIndexed(5, "20"));
        arithmeticTree.insert(new NodeIndexed(8, "+"));

        arithmeticTree.insert(new NodeIndexed(7, "8"));
        arithmeticTree.insert(new NodeIndexed(9, "2"));
        System.out.println(arithmeticTree.binaryTreeTraversal(0));
        System.out.println(arithmeticTree.binaryTreePostTraversal());

    }
}