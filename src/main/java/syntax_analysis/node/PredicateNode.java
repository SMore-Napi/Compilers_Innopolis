package syntax_analysis.node;

public class PredicateNode implements NodeInterface {
    NodeInterface element;
    Operation operation;

    public PredicateNode(Operation operation, NodeInterface element) {
        this.element = element;
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "PredicateNode{" +
                "Element=" + element +
                ", operation=" + operation +
                '}';
    }

    public enum Operation {
        ISINT, ISREAL, ISBOOL, ISNULL, ISATOM, ISLIST
    }
}
