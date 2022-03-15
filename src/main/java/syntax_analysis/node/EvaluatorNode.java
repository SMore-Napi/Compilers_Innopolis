package syntax_analysis.node;

public class EvaluatorNode implements NodeInterface {
    NodeInterface argument;

    public EvaluatorNode(NodeInterface argument) {
        this.argument = argument;
    }

    @Override
    public NodeInterface evaluate() {
        System.out.println("=====");
        System.out.println("Initial node: " + this);
        NodeInterface evaluatedArgument = argument.evaluate();
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
