import java.util.HashMap;

public class Tree {

    HashMap<Integer, Integer> treeTable = new HashMap<>();

    public void init() {
        treeTable.put(1,2);
        treeTable.put(2,5);
        treeTable.put(3,7);
        treeTable.put(4,2);
        treeTable.put(5,6);
        treeTable.put(6,8);
        treeTable.put(7,2);
        treeTable.put(8,9);
        treeTable.put(9,null);
        treeTable.put(10,9);
        treeTable.put(11,5);
    }

    private int traverseAndComputeDistance(int i, int searched) {
        // treeTable is really the n in O(n) or T(n); in functional programming it would be but in OOP
        // we can use it from class member

        if(searched == i) { // BASE CASE (ensure it halts)
           return 1;
        } else {
            return 1 // Try to change to 0 or comment and see what happens
                    +
                    traverseAndComputeDistance( // RECURSIVE CASE
                    treeTable.get(i), // gets the parent item
                    searched
            );
        }
    }

    public void runTreeTraversal(int searchStart, int searchedItem) {
        init();
        System.out.println(traverseAndComputeDistance(searchStart, searchedItem)
                - 1 // because I want the path, not the node
        );
    }

}
