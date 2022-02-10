package syntax_analysis.node;

public class ArithmeticFunctionNode extends Node {
    public enum Operation {
        ADDITION, SUBTRACTION, MULTIPLICATION, DIVISION
    }

    ElementNode leftOperand;
    ElementNode rightOperand;
    Operation operation;


    public ArithmeticFunctionNode(Operation operation, ElementNode leftOperand, ElementNode rightOperand) {
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
}
