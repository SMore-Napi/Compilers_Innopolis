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
        PredefinedFunction predefinedFunction = new PredefinedFunction(elements);
        if (predefinedFunction.isPredefinedFunction()) {
            return predefinedFunction.performFunctionAction();
        }
        DefinedFunction definedFunction = new DefinedFunction(elements);
        if (definedFunction.isDefinedFunction()) {
            return definedFunction.performFunctionAction();
        }
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
        return new ListNode(evaluatedElements);
    }
}
