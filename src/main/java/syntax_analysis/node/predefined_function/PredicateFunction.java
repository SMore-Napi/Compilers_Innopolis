package syntax_analysis.node.predefined_function;

import syntax_analysis.node.AtomNode;
import syntax_analysis.node.ElementInterface;
import syntax_analysis.node.ListNode;
import syntax_analysis.node.LiteralNode;

public class PredicateFunction implements ElementInterface {
    ElementInterface element;
    Operation operation;

    public PredicateFunction(Operation operation, ElementInterface element) {
        this.element = element;
        this.operation = operation;
    }

    @Override
    public ElementInterface evaluate() {
        ElementInterface evaluatedElement = element.evaluate();
        return this.performOperation(evaluatedElement);
    }

    private LiteralNode performOperation(ElementInterface evaluatedElement) {
        switch (operation) {
            case ISINT:
                try {
                    if (((LiteralNode) evaluatedElement).getValue() instanceof Integer) {
                        return new LiteralNode(true);
                    } else {
                        return new LiteralNode(false);
                    }
                } catch (ClassCastException e) {
                    return new LiteralNode(false);
                }
            case ISREAL:
                try {
                    if (((LiteralNode) evaluatedElement).getValue() instanceof Double) {
                        return new LiteralNode(true);
                    } else {
                        return new LiteralNode(false);
                    }
                } catch (ClassCastException e) {
                    return new LiteralNode(false);
                }
            case ISBOOL:
                try {
                    if (((LiteralNode) evaluatedElement).getValue() instanceof Boolean) {
                        return new LiteralNode(true);
                    } else {
                        return new LiteralNode(false);
                    }
                } catch (ClassCastException e) {
                    return new LiteralNode(false);
                }
            case ISNULL:
                try {
                    if (evaluatedElement == null || ((LiteralNode) evaluatedElement).getValue() == null) {
                        return new LiteralNode(true);
                    } else {
                        return new LiteralNode(false);
                    }
                } catch (ClassCastException e) {
                    return new LiteralNode(false);
                }
            case ISATOM:
                try {
                    if (element instanceof AtomNode) {
                        return new LiteralNode(true);
                    } else {
                        return new LiteralNode(false);
                    }
                } catch (ClassCastException e) {
                    return new LiteralNode(false);
                }
            case ISLIST:
                try {
                    if (evaluatedElement instanceof ListNode) {
                        return new LiteralNode(true);
                    } else {
                        return new LiteralNode(false);
                    }
                } catch (ClassCastException e) {
                    return new LiteralNode(false);
                }
        }
        throw new RuntimeException("Unknown predicate operator: " + operation);
    }

    @Override
    public String toString() {
        return "Predicate{" +
                "El={" + element + '}' +
                ", " + operation +
                '}';
    }

    public enum Operation {
        ISINT, ISREAL, ISBOOL, ISNULL, ISATOM, ISLIST
    }
}
