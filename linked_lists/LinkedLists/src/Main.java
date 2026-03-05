import double_linked_list.SingleLinkedNode;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
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

    }
}