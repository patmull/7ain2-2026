import double_linked_list.SingleLinkedNode;

public class SingleLinkedList {

    private SingleLinkedNode firstNode;

    public SingleLinkedList() {
        this.firstNode = null;
    }

    public boolean appendLastNode(SingleLinkedNode lastNode) {
        // append to the end
        if(this.firstNode == null) {
            this.firstNode = lastNode;
            return true;
        } else {
            SingleLinkedNode nextNode = this.firstNode.getNext();
            if (nextNode == null) {
                if(this.firstNode.addNext(lastNode)) {
                    return true;
                }
            } else {
                while(true) {
                    if(nextNode.getNext() == null) { // just test the next, necause we cannot move to null and then call addNext() on null!
                        nextNode.addNext(lastNode);
                        nextNode = nextNode.getNext(); // actually move
                        nextNode.addNext(null); // set the last item to null (otherwise we could not stop)
                        return true;
                    } else {
                        nextNode = nextNode.getNext(); // actually move and store the actual item...
                    }
                }
            }
        }
        return false;
    }

    public boolean addOnKthPosition(int k, SingleLinkedNode newItem) {
        SingleLinkedNode actualNode = this.firstNode;
        int i = 1;
        while (actualNode.getNext() != null) {
            if (i == k) {
                SingleLinkedNode oldNextNode = actualNode.getNext();
                System.out.println("oldNextNode: " + oldNextNode.getValue());
                actualNode.addNext(newItem); // new item inserted
                System.out.println("actualNode: " + actualNode.getValue() + " == add newItem ==> " + newItem.getValue());
                actualNode.getNext().addNext(oldNextNode); // insert (new item will have the old one as the next item)
                System.out.println("actualNode.getNext() (after insert): " + actualNode.getNext().getValue()
                        + " == add the oldNextNode ==> : " + oldNextNode.getValue());
                return true;
            } else {
                // traverseW
                actualNode = actualNode.getNext();
            }
            i++;
        }
        return false;
    }

    public boolean removeKthItem(int k) {
        SingleLinkedNode nextNode = this.firstNode;
        int i = 1;
        while (nextNode.getNext() != null) {
            if (i == k) {
                SingleLinkedNode skipToNode = nextNode.getNext().getNext(); // skip the k-th item
                nextNode.addNext(null); // actually removing
                nextNode.addNext(skipToNode); // skip the k-th item
                return true;
            } else if (nextNode == null) {
                System.out.println("WARNING: The position is out of range, not item was removed.");
                break;
            }
            nextNode = nextNode.getNext(); // continue traversing... and store the state of actual item
            i++;
        }

        return false;
    }

    public void listAllItems() {
        SingleLinkedNode nextNode = this.firstNode;
        while(nextNode != null) {
            System.out.println(nextNode.getValue());
            nextNode = nextNode.getNext();
        }
    }
}
