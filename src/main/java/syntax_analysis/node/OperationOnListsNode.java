package syntax_analysis.node;

public class OperationOnListsNode implements NodeInterface {

    NodeInterface element;
    NodeInterface list;
    Operation operation;

    public OperationOnListsNode(Operation operation, NodeInterface list) {
        this.list = list;
        this.operation = operation;
    }

    public OperationOnListsNode(Operation operation, NodeInterface element, NodeInterface list) {
        this.list = list;
        this.element = element;
        this.operation = operation;
    }

    @Override
    public String toString() {
        if (element != null) {
            return "OperationOnLists{" +
                    "element=" + element +
                    ", list=" + list +
                    ", operation=" + operation +
                    '}';
        }
        return "OperationOnLists{" +
                "list=" + list +
                ", operation=" + operation +
                '}';
    }

    public enum Operation {
        HEAD, TAIL, CONS
    }
}
