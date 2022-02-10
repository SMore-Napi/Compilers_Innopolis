package syntax_analysis.node;

public class PredicateNode extends Node{
    public enum Operation {
        ISINT, ISREAL, ISBOOL, ISNULL, ISATOM, ISLIST
    }

    ElementNode element;
    Operation operation;

    public PredicateNode(Operation operation, ElementNode element) {
        element = element;
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "PredicateNode{" +
                "Element=" + element +
                ", operation=" + operation +
                '}';
    }
}
