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
        this.element = element;
        this.list = list;
        this.operation = operation;
    }

    @Override
    public NodeInterface evaluate() {
        switch (operation) {
            case HEAD:
                try {
                    ListNode listNode = (ListNode) list.evaluate();
                    if (listNode.elements.isEmpty()) {
                        //todo custom exception
                        throw new RuntimeException("Can't call 'head' from empty list");
                    }
                    return listNode.elements.get(0);
                } catch (ClassCastException classCastException) {
                    //todo custom exception
                    throw new RuntimeException("The evaluated argument should be a list");
                }
            case TAIL:
                try {
                    ListNode listNode = (ListNode) list.evaluate();
                    if (listNode.elements.isEmpty()) {
                        //todo custom exception
                        throw new RuntimeException("Can't call 'tail' from empty list");
                    }
                    return new ListNode(listNode.elements.subList(1, listNode.elements.size()));
                } catch (ClassCastException classCastException) {
                    //todo custom exception
                    throw new RuntimeException("The evaluated argument should be a list");
                }
            case CONS:
                try {
                    NodeInterface firstElement = element.evaluate();
                    ListNode listNode = (ListNode) list.evaluate();
                    return new ListNode(firstElement, listNode);
                } catch (ClassCastException classCastException) {
                    //todo custom exception
                    throw new RuntimeException("The second evaluated argument should be a list");
                }
            default:
                //todo custom exception
                throw new RuntimeException("Unknown list operation: " + operation);
        }
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