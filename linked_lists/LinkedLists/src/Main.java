import double_linked_list.SingleLinkedNode;

import java.util.LinkedList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Not required to code by hand, just look at this to see how it can be implemented:
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.appendLastNode(new SingleLinkedNode("Auckland"));
        // NOTICE: Test on edge cases. Comment this section...

        singleLinkedList.appendLastNode(new SingleLinkedNode("Boston"));
        singleLinkedList.appendLastNode(new SingleLinkedNode("C"));
        singleLinkedList.appendLastNode(new SingleLinkedNode("Detroit"));
        singleLinkedList.appendLastNode(new SingleLinkedNode("E"));
        /*
         */

        singleLinkedList.listAllItems();

        System.out.println("Adding...");
        singleLinkedList.addOnKthPosition(1, new SingleLinkedNode("C2"));
        singleLinkedList.listAllItems();

        System.out.println("Removing...");
        singleLinkedList.removeKthItem(1);

        // NOTICE: Test also adding to 1st and last item

        singleLinkedList.listAllItems();

        // Using Java pre-implemented linked list:
        LinkedList<String> trainRoute
                = new LinkedList<>();

        trainRoute.add("Ostrava - Střed");
        trainRoute.add("Ostrava - Stodolní");
        trainRoute.add("Ostrava - hl.n.");
        trainRoute.add("Ostrava - Svinov");
        trainRoute.add("Jistebník");
        trainRoute.add("Studénka");
        trainRoute.add("Sedlnice");
        trainRoute.add("Skotnice");
        trainRoute.add("...");

        // adding new item
        trainRoute.add(7, "Mošnov - Ostrava Airport");

        for (int i = 0; i < trainRoute.size(); i++) {
            System.out.print(trainRoute.get(i) + ", ");
        }
        // NOTE: Java's implementation does not have "getNext()" method...
        // ...mainky because we can use foreach over the general Iterator type (common for other data structred like array lists)
        for (String str : trainRoute)
            System.out.print(str + ", ");
    }
}