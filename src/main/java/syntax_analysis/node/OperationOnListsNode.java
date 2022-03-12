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

    //  Примеры в testOperationsOnList.txt
    //  TODO: выглядит все очень костыльно, возможно можно придумать более красивое решение
    //  TODO: (cons 2 (head (1 2 3))) такое выводит какой-то аутпут, но по идее должен выводить ошибку
    @Override
    public NodeInterface evaluate() {
        if (operation == Operation.CONS){
            try {
                return new ListNode(element, (ListNode) list.evaluate());
            } catch (ClassCastException classCastException){
                return new ListNode(element, (ListNode) list);
            }

        } else if (operation == Operation.HEAD){
            try {
                return ((ListNode) list.evaluate()).headElement();
            } catch (ClassCastException classCastException){
                return ((ListNode) list).headElement();
            }

        } else if (operation == Operation.TAIL){
            try {
                // если у нас такой пример (tail (2)), то тут будет ClassCastException
                return ((ListNode) list.evaluate()).tailOfList();
            } catch (ClassCastException classCastException){
                return ((ListNode) list).tailOfList();
            }

        } else {
            return null;
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
