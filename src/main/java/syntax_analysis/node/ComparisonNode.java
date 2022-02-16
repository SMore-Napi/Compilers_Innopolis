package syntax_analysis.node;

public class ComparisonNode implements NodeInterface {
    NodeInterface firstElement;
    NodeInterface secondElement;
    Operation operation;

    public ComparisonNode(Operation operation, NodeInterface firstElement, NodeInterface secondElement) {
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

    public enum Operation {
        EQUAL, NONEQUAL, LESS, LESSEQUAL, GREATER, GREATEREQUAL
    }
}
