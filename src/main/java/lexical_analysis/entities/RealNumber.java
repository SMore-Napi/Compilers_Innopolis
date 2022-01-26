package lexical_analysis.entities;

public class RealNumber extends Literal {
    private IntegerNumber integerPart;
    private IntegerNumber fractionalPart;

    public RealNumber(int length, int row, int column, IntegerNumber integerNumber, IntegerNumber fractionalPart) {
        super(length, row, column);
        this.integerPart = integerNumber;
        this.fractionalPart = fractionalPart;
    }


    public IntegerNumber getIntegerPart() {
        return integerPart;
    }

    public void setIntegerPart(IntegerNumber integerPart) {
        this.integerPart = integerPart;
    }

    @Override
    public String toString() {
        return integerPart +
                "." + fractionalPart;
    }

    public IntegerNumber getFractionalPart() {
        return fractionalPart;
    }

    public void setFractionalPart(IntegerNumber fractionalPart) {
        this.fractionalPart = fractionalPart;
    }
}
