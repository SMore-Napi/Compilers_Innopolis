package syntax_analysis.node.predefined_function;

import syntax_analysis.node.ElementInterface;
import syntax_analysis.node.LiteralNode;

public class ArithmeticFunction implements ElementInterface {
    ElementInterface leftOperand;
    ElementInterface rightOperand;
    Operation operation;

    public ArithmeticFunction(Operation operation, ElementInterface leftOperand, ElementInterface rightOperand) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        this.operation = operation;
    }

    @Override
    public ElementInterface evaluate() {
        this.checkType(leftOperand);
        this.checkType(rightOperand);

        Object leftOperandLiteral = ((LiteralNode) leftOperand.evaluate()).getValue();
        Object rightOperandLiteral = ((LiteralNode) rightOperand.evaluate()).getValue();
        Integer lOInt = leftOperandLiteral instanceof Integer ? (int) leftOperandLiteral : null;
        Double lOReal = leftOperandLiteral instanceof Double ? (double) leftOperandLiteral : null;
        Integer rOInt = rightOperandLiteral instanceof Integer ? (int) rightOperandLiteral : null;
        Double rOReal = rightOperandLiteral instanceof Double ? (double) rightOperandLiteral : null;

        return this.performOperation(lOInt, lOReal, rOInt, rOReal);
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

    private void checkType(ElementInterface elementInterface) {
        final String exceptionMessage = "Literal value must be integer or real. Provided: " + elementInterface;
        try {
            Object object = ((LiteralNode) elementInterface.evaluate()).getValue();
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
