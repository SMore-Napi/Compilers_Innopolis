package syntax_analysis.node;

public class ComparisonNode extends Node{
    public enum Operation {
        EQUAL, NONEQUAL, LESS, LESSEQUAL, GREATER, GREATEREQUAL
    }

    ElementNode firstElement;
    ElementNode secondElement;
    Operation operation;

    public ComparisonNode(Operation operation, ElementNode firstElement, ElementNode secondElement) {
        this.firstElement = firstElement;
        this.secondElement = secondElement;
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "Comparison{" +
                "firstElement=" + firstElement +
                ", secondElement=" + secondElement +
                ", operation=" + operation +
                '}';
    }
}
