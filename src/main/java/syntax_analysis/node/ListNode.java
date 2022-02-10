package syntax_analysis.node;

import java.util.ArrayList;
import java.util.List;

public class ListNode extends Node {
    List<ElementNode> elements;
    ArithmeticFunctionNode arithmeticFunction;

    public ListNode() {
        elements = new ArrayList<>();
    }

    public ListNode(ArithmeticFunctionNode arithmeticFunction) {
        this.arithmeticFunction = arithmeticFunction;
    }

    public ListNode(ElementNode element) {
        elements = new ArrayList<>();
        elements.add(element);
    }

    public ListNode(ElementNode element, ListNode list) {
        elements = new ArrayList<>();
        elements.add(element);
        elements.addAll(list.elements);
    }

    @Override
    public String toString() {
        if (arithmeticFunction != null) {
            return "ListNode{" +
                    "arithmeticFunction=" + arithmeticFunction +
                    '}';
        }
        return "ListNode{" +
                "elements=" + elements +
                '}';
    }
}
