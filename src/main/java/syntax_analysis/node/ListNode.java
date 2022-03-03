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
    public ListNode(List<NodeInterface> elements) {
        this.elements = new ArrayList<>();
        this.elements.addAll(elements);
    }

    public ListNode(NodeInterface element, ListNode list) {
        elements = new ArrayList<>();
        elements.add(element);
        elements.addAll(list.elements);
    }

    @Override
    public String toString() {
        return "List" + elements;
    }

    @Override
    public NodeInterface evaluate() {
        System.out.println("=====");
        System.out.println("Initial node: " + elements);
        List<NodeInterface> evaluatedElements = new ArrayList<>();
        for (NodeInterface element : elements){
            evaluatedElements.add(element.evaluate());
        }
        System.out.println("Evaluated node: " + evaluatedElements);
        System.out.println("=====");
        if (evaluatedElements.size() == 1) {
            return evaluatedElements.get(0);
        } else {
            return new ListNode(evaluatedElements);
        }
    }
}
