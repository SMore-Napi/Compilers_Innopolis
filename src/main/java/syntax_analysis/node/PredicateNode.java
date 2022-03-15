package syntax_analysis.node;

public class PredicateNode implements NodeInterface {
    NodeInterface element;
    Operation operation;

    public PredicateNode(Operation operation, NodeInterface element) {
        this.element = element;
        this.operation = operation;
    }

    @Override
    public NodeInterface evaluate() {
        System.out.println("=====");
        System.out.println("Initial node: " + this);
        NodeInterface evaluatedElement = element.evaluate();
        System.out.println("Evaluated node (1): " + evaluatedElement);
        LiteralNode result = this.performOperation(evaluatedElement);
        System.out.println("Evaluated node (2): " + result);
        System.out.println("=====");
        return result;
    }

    private LiteralNode performOperation(NodeInterface evaluatedElement) {
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
