package syntax_analysis.node;

import java.util.ArrayList;
import java.util.List;

public class ListNode implements NodeInterface {
    List<NodeInterface> elements;

    public ListNode() {
        elements = new ArrayList<>();
    }

    public ListNode(NodeInterface element) {
        elements = new ArrayList<>();
        elements.add(element);
    }

    public ListNode(NodeInterface element, ListNode list) {
        elements = new ArrayList<>();
        elements.add(element);
        elements.addAll(list.elements);
    }

    @Override
    public String toString() {
        return "ListNode{elements=" + elements + '}';
    }
}
