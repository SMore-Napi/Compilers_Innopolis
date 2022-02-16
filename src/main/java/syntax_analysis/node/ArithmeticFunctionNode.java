package syntax_analysis.node;

public class ArithmeticFunctionNode implements NodeInterface {
    NodeInterface leftOperand;
    NodeInterface rightOperand;
    Operation operation;

    public ArithmeticFunctionNode(Operation operation, NodeInterface leftOperand, NodeInterface rightOperand) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "ArithmeticFunctionNode{" +
                "leftOperand=" + leftOperand +
                ", rightOperand=" + rightOperand +
                ", operation=" + operation +
                '}';
    }

    public enum Operation {
        ADDITION, SUBTRACTION, MULTIPLICATION, DIVISION
    }
}
