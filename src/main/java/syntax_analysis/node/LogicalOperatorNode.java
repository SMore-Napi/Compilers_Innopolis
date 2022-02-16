package syntax_analysis.node;

public class LogicalOperatorNode implements NodeInterface {
    NodeInterface firstElement;
    NodeInterface secondElement;
    Operation operation;

    public LogicalOperatorNode(Operation operation, NodeInterface firstElement, NodeInterface secondElement) {
        this.firstElement = firstElement;
        this.secondElement = secondElement;
        this.operation = operation;
    }

    public LogicalOperatorNode(Operation operation, NodeInterface firstElement) {
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

    public enum Operation {
        AND, OR, XOR, NOT
    }
}
