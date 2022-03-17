package syntax_analysis.node.predefined_function;

import exceptions.ComparisonException;
import syntax_analysis.node.ElementInterface;
import syntax_analysis.node.LiteralNode;

public class ComparisonFunction implements ElementInterface {
    ElementInterface firstElement;
    ElementInterface secondElement;
    Operation operation;

    public ComparisonFunction(Operation operation, ElementInterface firstElement, ElementInterface secondElement) {
        this.firstElement = firstElement;
        this.secondElement = secondElement;
        this.operation = operation;
    }

    @Override
    public ElementInterface evaluate() {
        this.checkType(firstElement);
        this.checkType(secondElement);

        Object leftOperandLiteral = ((LiteralNode) firstElement.evaluate()).getValue();
        Object rightOperandLiteral = ((LiteralNode) secondElement.evaluate()).getValue();

        Integer lOInt = leftOperandLiteral instanceof Integer ? (int) leftOperandLiteral : null;
        Double lOReal = leftOperandLiteral instanceof Double ? (double) leftOperandLiteral : null;
        Integer rOInt = rightOperandLiteral instanceof Integer ? (int) rightOperandLiteral : null;
        Double rOReal = rightOperandLiteral instanceof Double ? (double) rightOperandLiteral : null;
        Boolean lOBool = leftOperandLiteral instanceof Boolean ? (boolean) leftOperandLiteral : null;
        Boolean rOBool = rightOperandLiteral instanceof Boolean ? (boolean) rightOperandLiteral : null;

        return new LiteralNode(Boolean.TRUE.equals(this.performOperation(lOInt, lOReal, rOInt, rOReal, lOBool, rOBool)));
    }


    private Boolean performOperation(Integer lOInt, Double lOReal, Integer rOInt, Double rOReal, Boolean lOBool, Boolean rOBool) {
        switch (operation) {
            case EQUAL:
                if (lOInt != null && rOInt != null) {
                    return (int) lOInt == (int) rOInt;
                } else if (lOInt != null && rOReal != null) {
                    return (double) lOInt == (double) rOReal;
                } else if (lOReal != null && rOInt != null) {
                    return (double) lOReal == (double) rOInt;
                } else if (lOReal != null && rOReal != null) {
                    return (double) lOReal == (double) rOReal;
                } else if (lOBool != null && rOBool != null) {
                    return lOBool == (boolean) rOBool;
                } else {
                    throw new ComparisonException(": Wrong operands in EQUAL operation", true);
                }
            case NONEQUAL:
                if (lOInt != null && rOInt != null) {
                    return (int) lOInt != (int) rOInt;
                } else if (lOInt != null && rOReal != null) {
                    return (double) lOInt != (double) rOReal;
                } else if (lOReal != null && rOInt != null) {
                    return (double) lOReal != (double) rOInt;
                } else if (lOReal != null && rOReal != null) {
                    return (double) lOReal != (double) rOReal;
                } else if (lOBool != null && rOBool != null) {
                    return lOBool != (boolean) rOBool;
                } else {
                    throw new ComparisonException(": Wrong operands in NONEQUAL operation", true);
                }
            case LESS:
                if (lOInt != null && rOInt != null) {
                    return (int) lOInt < (int) rOInt;
                } else if (lOInt != null && rOReal != null) {
                    return (double) lOInt < (double) rOReal;
                } else if (lOReal != null && rOInt != null) {
                    return (double) lOReal < (double) rOInt;
                } else if (lOReal != null && rOReal != null) {
                    return (double) lOReal < (double) rOReal;
                } else {
                    throw new ComparisonException(": Wrong operands in LESS operation", true);
                }
            case LESSEQUAL:
                if (lOInt != null && rOInt != null) {
                    return (int) lOInt <= (int) rOInt;
                } else if (lOInt != null && rOReal != null) {
                    return (double) lOInt <= (double) rOReal;
                } else if (lOReal != null && rOInt != null) {
                    return (double) lOReal <= (double) rOInt;
                } else if (lOReal != null && rOReal != null) {
                    return (double) lOReal <= (double) rOReal;
                } else {
                    throw new ComparisonException(": Wrong operands in LESSEQUAL operation", true);
                }
            case GREATER:
                if (lOInt != null && rOInt != null) {
                    return (int) lOInt > (int) rOInt;
                } else if (lOInt != null && rOReal != null) {
                    return (double) lOInt > (double) rOReal;
                } else if (lOReal != null && rOInt != null) {
                    return (double) lOReal > (double) rOInt;
                } else if (lOReal != null && rOReal != null) {
                    return (double) lOReal > (double) rOReal;
                } else {
                    throw new ComparisonException(": Wrong operands in GREATER operation", true);
                }
            case GREATEREQUAL:
                if (lOInt != null && rOInt != null) {
                    return (int) lOInt >= (int) rOInt;
                } else if (lOInt != null && rOReal != null) {
                    return (double) lOInt >= (double) rOReal;
                } else if (lOReal != null && rOInt != null) {
                    return (double) lOReal >= (double) rOInt;
                } else if (lOReal != null && rOReal != null) {
                    return (double) lOReal >= (double) rOReal;
                } else {
                    throw new ComparisonException(": Wrong operands in LESS operation", true);
                }
        }
        return null;
    }

    private void checkType(ElementInterface elementInterface) {
        final String exceptionMessage = "Literal value must be integer or real or boolean. Provided: " + elementInterface;
        try {
            Object object = ((LiteralNode) elementInterface.evaluate()).getValue();
            if (!((object instanceof Integer) || (object instanceof Double) || (object instanceof Boolean))) {
                throw new RuntimeException(exceptionMessage);
            }
        } catch (ClassCastException e) {
            throw new ComparisonException(": Literal value must be integer or real or boolean. Provided: " + elementInterface.evaluate(), true);
        }
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
