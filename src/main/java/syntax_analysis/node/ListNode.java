package syntax_analysis.node;

import interpreter.PredefinedFunction;
import interpreter.DefinedFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListNode implements ElementInterface {
    public List<ElementInterface> elements;

    public ListNode() {
        elements = new ArrayList<>();
    }

    public ListNode(ElementInterface element) {
        elements = new ArrayList<>();
        elements.add(element);
    }

    public ListNode(List<ElementInterface> elements) {
        this.elements = new ArrayList<>();
        this.elements.addAll(elements);
    }

    public ListNode(ElementInterface element, ListNode list) {
        elements = new ArrayList<>();
        elements.add(element);
        elements.addAll(list.elements);
    }

    @Override
    public String toString() {
        return "List" + elements;
    }

    @Override
    public ElementInterface evaluate() {
        System.out.println("=====");
        System.out.println("Initial node: " + elements);
        PredefinedFunction predefinedFunction = new PredefinedFunction(elements);
        if (predefinedFunction.isPredefinedFunction()) {
            return predefinedFunction.performFunctionAction();
        }
        DefinedFunction definedFunction = new DefinedFunction(elements);

        if (definedFunction.isDefinedFunction()){
            return definedFunction.performFunctionAction();
        }
        List<ElementInterface> evaluatedElements = elements.stream()
                .map(ElementInterface::evaluate)
                .collect(Collectors.toList());
        System.out.println("Evaluated node: " + evaluatedElements);
        System.out.println("=====");
        return new ListNode(evaluatedElements);
    }
}
