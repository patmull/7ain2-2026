public class NodeIndexed {

    private int index;
    private String value;

    NodeIndexed(int id, String value) {
        this.index = id;
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public String getValue() {
        return value;
    }
}
