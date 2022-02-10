package syntax_analysis.node;

public class LogicalOperatorNode extends Node{
    public enum Operation {
        AND, OR, XOR, NOT
    }

    ElementNode firstElement;
    ElementNode secondElement;
    Operation operation;

    public LogicalOperatorNode(Operation operation, ElementNode firstElement, ElementNode secondElement) {
        this.firstElement = firstElement;
        this.secondElement = secondElement;
        this.operation = operation;
    }

    public LogicalOperatorNode(Operation operation, ElementNode firstElement) {
        this.firstElement = firstElement;
        this.operation = operation;
    }

    @Override
    public String toString() {
        if (secondElement != null) {
            return "LogicalOperatorNode{" +
                    "firstElement=" + firstElement +
                    ", secondElement=" + secondElement +
                    ", operation=" + operation +
                    '}';
        }
        return "LogicalOperatorNode{" +
                "element=" + firstElement +
                ", operation=" + operation +
                '}';
    }
}
