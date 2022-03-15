package syntax_analysis.node;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        PredefinedFunction predefinedFunction = new PredefinedFunction(elements);
        if (predefinedFunction.isPredefinedFunction()) {
            return predefinedFunction.performFunctionAction();
        }
        List<NodeInterface> evaluatedElements = elements.stream()
                .map(NodeInterface::evaluate)
                .collect(Collectors.toList());
        System.out.println("Evaluated node: " + evaluatedElements);
        System.out.println("=====");
        return new ListNode(evaluatedElements);
    }
}
