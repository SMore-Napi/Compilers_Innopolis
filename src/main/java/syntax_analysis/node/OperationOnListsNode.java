package syntax_analysis.node;

public class OperationOnListsNode extends Node{

    public enum Operation {
        HEAD, TAIL, CONS
    }

    ElementNode element;
    ElementNode list;
    Operation operation;

    public OperationOnListsNode(Operation operation, ElementNode list) {
        this.list = list;
        this.operation = operation;
    }

    public OperationOnListsNode(Operation operation, ElementNode element, ElementNode list) {
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
}
