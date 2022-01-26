package lexical_analysis.entities;

public class IntegerNumber extends Literal {
    private int value;

    public IntegerNumber(int length, int row, int column, int value) {
        super(length, row, column);
        this.value = value;
    }


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Integer{" +
                "value=" + value +
                '}';
    }
}
