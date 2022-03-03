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
    public NodeInterface evaluate() {
        System.out.println("=====");
        System.out.println("Initial node: " + this);

        this.checkType(leftOperand);
        this.checkType(rightOperand);

        Object leftOperandLiteral = ((LiteralNode) leftOperand.evaluate()).getValue();
        Object rightOperandLiteral = ((LiteralNode) rightOperand.evaluate()).getValue();
        Integer lOInt = leftOperandLiteral instanceof Integer ? (int) leftOperandLiteral : null;
        Double lOReal = leftOperandLiteral instanceof Double ? (double) leftOperandLiteral : null;
        Integer rOInt = rightOperandLiteral instanceof Integer ? (int) rightOperandLiteral : null;
        Double rOReal = rightOperandLiteral instanceof Double ? (double) rightOperandLiteral : null;

        LiteralNode result = this.performOperation(lOInt, lOReal, rOInt, rOReal);

        System.out.println("Evaluated node: " + result);
        System.out.println("=====");
        return result;
    }

    private LiteralNode performOperation(Integer lOInt, Double lOReal, Integer rOInt, Double rOReal) {
        switch (operation) {
            case ADDITION:
                if (lOInt != null && rOInt != null) {
                    return new LiteralNode(lOInt + rOInt);
                } else if (lOInt != null && rOReal != null) {
                    return new LiteralNode(lOInt + rOReal);
                } else if (lOReal != null && rOInt != null) {
                    return new LiteralNode(lOReal + rOInt);
                } else if (lOReal != null && rOReal != null) {
                    return new LiteralNode(lOReal + rOReal);
                }
                break;
            case SUBTRACTION:
                if (lOInt != null && rOInt != null) {
                    return new LiteralNode(lOInt - rOInt);
                } else if (lOInt != null && rOReal != null) {
                    return new LiteralNode(lOInt - rOReal);
                } else if (lOReal != null && rOInt != null) {
                    return new LiteralNode(lOReal - rOInt);
                } else if (lOReal != null && rOReal != null) {
                    return new LiteralNode(lOReal - rOReal);
                }
                break;
            case MULTIPLICATION:
                if (lOInt != null && rOInt != null) {
                    return new LiteralNode(lOInt * rOInt);
                } else if (lOInt != null && rOReal != null) {
                    return new LiteralNode(lOInt * rOReal);
                } else if (lOReal != null && rOInt != null) {
                    return new LiteralNode(lOReal * rOInt);
                } else if (lOReal != null && rOReal != null) {
                    return new LiteralNode(lOReal * rOReal);
                }
                break;
            case DIVISION:
                if (lOInt != null && rOInt != null) {
                    return new LiteralNode((double) lOInt / rOInt);
                } else if (lOInt != null && rOReal != null) {
                    return new LiteralNode((double) lOInt / rOReal);
                } else if (lOReal != null && rOInt != null) {
                    return new LiteralNode((double) lOReal / rOInt);
                } else if (lOReal != null && rOReal != null) {
                    return new LiteralNode((double) lOReal / rOReal);
                }
                break;
        }
        return null;
    }

    private void checkType(NodeInterface nodeInterface) {
        final String exceptionMessage = "Literal value must be integer or real. Provided: " + nodeInterface;
        try {
            Object object = ((LiteralNode) nodeInterface.evaluate()).getValue();
            if (!((object instanceof Integer) || (object instanceof Double))) {
                throw new RuntimeException(exceptionMessage);
            }
        } catch (ClassCastException e) {
            throw new RuntimeException(exceptionMessage);
        }
    }

    @Override
    public String toString() {
        return "Arithmetic{" +
                "lOp={" + leftOperand + "}" +
                ", rOp={" + rightOperand + "}" +
                ", " + operation +
                '}';
    }

    public enum Operation {
        ADDITION, SUBTRACTION, MULTIPLICATION, DIVISION
    }
}
