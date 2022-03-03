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

    private LiteralNode performOperation(NodeInterface element) {
        switch (operation) {
            case ISINT:
                try {
                    if (((LiteralNode) element).getValue() instanceof Integer) {
                        return new LiteralNode(true);
                    } else {
                        return new LiteralNode(false);
                    }
                } catch (ClassCastException e) {
                    return new LiteralNode(false);
                }
            case ISREAL:
                try {
                    if (((LiteralNode) element).getValue() instanceof Double) {
                        return new LiteralNode(true);
                    } else {
                        return new LiteralNode(false);
                    }
                } catch (ClassCastException e) {
                    return new LiteralNode(false);
                }
            case ISBOOL:
                try {
                    if (((LiteralNode) element).getValue() instanceof Boolean) {
                        return new LiteralNode(true);
                    } else {
                        return new LiteralNode(false);
                    }
                } catch (ClassCastException e) {
                    return new LiteralNode(false);
                }
        }
        return null;
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
