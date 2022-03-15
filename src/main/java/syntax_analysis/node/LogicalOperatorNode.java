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
    public NodeInterface evaluate() {
        System.out.println("=====");
        System.out.println("Initial node: " + this);
        LiteralNode result;
        this.checkType(firstElement);
        boolean fElValue = (boolean) (((LiteralNode) firstElement.evaluate()).getValue());
        switch (operation) {
            case AND:
            case OR:
            case XOR:
                if (secondElement == null){
                    throw new RuntimeException("Logical binary operator must accept two boolean arguments");
                }
                this.checkType(secondElement);
                boolean sElValue = (boolean) (((LiteralNode) secondElement.evaluate()).getValue());
                result = this.performBinaryOperation(fElValue, sElValue);
                break;
            case NOT:
                if (secondElement != null){
                    throw new RuntimeException("Logical unary operator must accept single boolean argument");
                }
                result = this.performUnaryOperation(fElValue);
                break;
            default:
                throw new RuntimeException("Undefined logical unary operator: " + operation);
        }
        System.out.println("Evaluated node: " + result);
        System.out.println("=====");
        return result;
    }

    private LiteralNode performBinaryOperation(boolean fElValue, boolean sElValue) {
        switch (operation) {
            case AND:
                System.out.println("here");
                System.out.println(fElValue);
                System.out.println(sElValue);
                return new LiteralNode(fElValue && sElValue);
            case OR:
                return new LiteralNode(fElValue || sElValue);
            case XOR:
                return new LiteralNode(fElValue ^ sElValue);
        }
        throw new RuntimeException("Undefined logical binary operator: " + operation);
    }

    private LiteralNode performUnaryOperation(boolean value) {
        if (operation == Operation.NOT) {
            return new LiteralNode(!value);
        }
        throw new RuntimeException("Undefined logical unary operator: " + operation);
    }

    private void checkType(NodeInterface nodeInterface) {
        final String exceptionMessage = "Literal value must be boolean. Provided: " + nodeInterface;
        try {
            Object object = ((LiteralNode) nodeInterface.evaluate()).getValue();
            if (!(object instanceof Boolean)) {
                throw new RuntimeException(exceptionMessage);
            }
        } catch (ClassCastException | NullPointerException e) {
            throw new RuntimeException(exceptionMessage);
        }
    }

    @Override
    public String toString() {
        if (secondElement != null) {
            return "Logic{" +
                    "first={" + firstElement + '}' +
                    ", second={" + secondElement + '}' +
                    ", " + operation +
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
