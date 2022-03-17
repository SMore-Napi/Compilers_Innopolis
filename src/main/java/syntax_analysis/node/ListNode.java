package syntax_analysis.node;

import interpreter.DefinedFunction;
import interpreter.NestedFormBreak;
import interpreter.PredefinedFunction;
import syntax_analysis.node.special_form.ReturnNode;

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
        return "'(" + elements.stream().map(Object::toString).collect(Collectors.joining(" ")) + ")";
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
        if (definedFunction.isDefinedFunction()) {
            return definedFunction.performFunctionAction();
        }

//        if (!elements.isEmpty()) {
//            System.out.println("Check if the first evaluated element is function call");
//            System.out.println("elements: " + elements);
//            ElementInterface firstEvaluatedElement = elements.get(0).evaluate();
//            System.out.println("firstEvaluatedElement: " + firstEvaluatedElement);
//            if (PredefinedFunction.isPredefinedFunction(firstEvaluatedElement)) {
//                elements.set(0, firstEvaluatedElement);
//                predefinedFunction = new PredefinedFunction(elements);
//                return predefinedFunction.performFunctionAction();
//            }
//            if (DefinedFunction.isDefinedFunction(firstEvaluatedElement)) {
//                elements.set(0, firstEvaluatedElement);
//                definedFunction = new DefinedFunction(elements);
//                return definedFunction.performFunctionAction();
//            }
//        }


        List<ElementInterface> evaluatedElements = new ArrayList<>();
        for (ElementInterface element : elements) {
            if (NestedFormBreak.getInstance().scopeValue() < 0) {
                break;
            }
            ElementInterface evaluatedElement = element.evaluate();
            if (evaluatedElement instanceof ReturnNode) {
                ElementInterface returnResult = ((ReturnNode) evaluatedElement).element.evaluate();
                evaluatedElements.add(returnResult);
                break;
            }
            evaluatedElements.add(evaluatedElement);
        }

//        List<ElementInterface> evaluatedElements = elements.stream()
//                .map(ElementInterface::evaluate)
//                .collect(Collectors.toList());

        System.out.println("Evaluated node: " + evaluatedElements);
        System.out.println("=====");

        return new ListNode(evaluatedElements);
    }
}
