package lexical_analysis.entities;

public class Boolean extends Literal {
    private boolean value;

    public Boolean(int length, int row, int column, boolean value) {
        super(length, row, column);
        this.value = value;
    }


    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Boolean{" +
                "value=" + value +
                '}';
    }
}
