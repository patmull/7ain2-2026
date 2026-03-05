package double_linked_list;

public class SingleLinkedNode {

    SingleLinkedNode nextItem;
    private String value;

    public SingleLinkedNode(String value) {
        this.value = value;
        this.nextItem = null;
    }

    public String getValue() {
        return this.value;
    }

    public boolean addNext(SingleLinkedNode singleLinkedNode) {
        nextItem = singleLinkedNode;
        return true;
    }

    public SingleLinkedNode getNext() {
        return nextItem;
    }



    // NOTICE: removal needs to be handled above (the chain), not inside the individual pieces...


}
