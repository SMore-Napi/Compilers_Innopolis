package syntax_analysis.node.predefined_function;

import interpreter.DefinedFunction;
import interpreter.PredefinedFunction;
import syntax_analysis.node.ElementInterface;
import syntax_analysis.node.FunctionAtom;
import syntax_analysis.node.ListNode;

import java.util.ArrayList;
import java.util.List;

public class EvaluatorFunction implements ElementInterface {
    ElementInterface argument;

    public EvaluatorFunction(ElementInterface argument) {
        this.argument = argument;
    }

    @Override
    public ElementInterface evaluate() {
        System.out.println("=====");
        System.out.println("Initial node: " + this);
        ElementInterface evaluatedArgument = argument.evaluate();
        System.out.println("Evaluated argument: " + evaluatedArgument);
        System.out.println("=====");
        try {
            if (evaluatedArgument instanceof ListNode) {
                System.out.println("The argument is a list, so perform evaluation");
                System.out.println("=====");
                List<ElementInterface> elementsList = ((ListNode) evaluatedArgument).elements;
                PredefinedFunction predefinedFunction = new PredefinedFunction(elementsList);
                if (predefinedFunction.isPredefinedFunction()) {
                    return predefinedFunction.performFunctionAction();
                }
                DefinedFunction definedFunction = new DefinedFunction(elementsList);
                if (definedFunction.isDefinedFunction()) {
                    return definedFunction.performFunctionAction();
                }
                if (!(elementsList.isEmpty())) {
                    if (elementsList.get(0) instanceof FunctionAtom) {
                        FunctionAtom functionAtom = (FunctionAtom) elementsList.get(0);
                        System.out.println("Provide arguments: " + Math.min(functionAtom.getArgumentsNumber(),
                                elementsList.size()));
                        functionAtom.setParameters(elementsList.subList(1, 1 + Math.min(functionAtom.getArgumentsNumber(),
                                elementsList.size())));
                        ElementInterface functionResult = functionAtom.evaluate();
                        if (functionAtom.getArgumentsNumber() == elementsList.size()) {
                            return functionResult;
                        } else if (functionAtom.getArgumentsNumber() < elementsList.size()) {
                            List<ElementInterface> evaluatedListNode = new ArrayList<>();
                            evaluatedListNode.add(functionResult);
                            evaluatedListNode.addAll(elementsList.subList(1 + functionAtom.getArgumentsNumber(), elementsList.size()));
                            return new ListNode(evaluatedListNode);
                        }
                    }
                }
                throw new RuntimeException("The list can't be treated as a function: " + evaluatedArgument);
            } else {
                return evaluatedArgument;
            }
        } catch (ClassCastException e) {
            return evaluatedArgument;
        }
    }

    @Override
    public String toString() {
        return "eval{" + argument + '}';
    }
}
