package syntax_analysis.node.predefined_function;

import syntax_analysis.node.ElementInterface;
import syntax_analysis.node.ListNode;
import interpreter.PredefinedFunction;

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
                PredefinedFunction predefinedFunction = new PredefinedFunction(((ListNode) evaluatedArgument).elements);
                if (predefinedFunction.isPredefinedFunction()) {
                    return predefinedFunction.performFunctionAction();
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
