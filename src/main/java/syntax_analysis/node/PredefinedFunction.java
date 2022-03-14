package syntax_analysis.node;

import java.util.Arrays;
import java.util.List;

public class PredefinedFunction {

    List<NodeInterface> elements;

    public PredefinedFunction(List<NodeInterface> elements) {
        this.elements = elements;
    }

    public boolean isPredefinedFunction() {
        try {
            AtomNode atom = (AtomNode) elements.get(0);
            List<String> predefinedFunctionNames = Arrays.asList("plus", "minus", "times", "divide", "head", "tail",
                    "cons", "equal", "nonequal", "less", "lesseq", "greater", "greatereq", "isint", "isreal", "isbool",
                    "isnull", "isatom", "islist", "and", "or", "xor", "not", "eval");
            return predefinedFunctionNames.contains(atom.name);
        } catch (ClassCastException | IndexOutOfBoundsException e) {
            return false;
        }
    }

    public NodeInterface performFunctionAction() {
        System.out.println("Predefined Function Call");
        AtomNode atom = (AtomNode) elements.get(0);
        switch (atom.name) {
            case "plus":
                return performArithmeticFunction(ArithmeticFunctionNode.Operation.ADDITION);
            case "minus":
                return performArithmeticFunction(ArithmeticFunctionNode.Operation.SUBTRACTION);
            case "times":
                return performArithmeticFunction(ArithmeticFunctionNode.Operation.MULTIPLICATION);
            case "divide":
                return performArithmeticFunction(ArithmeticFunctionNode.Operation.DIVISION);
            case "head":
                return performOperationOnList(OperationOnListsNode.Operation.HEAD);
            case "tail":
                return performOperationOnList(OperationOnListsNode.Operation.TAIL);
            case "cons":
                return performOperationOnList(OperationOnListsNode.Operation.CONS);
            case "equal":
                return performComparison(ComparisonNode.Operation.EQUAL);
            case "nonequal":
                return performComparison(ComparisonNode.Operation.NONEQUAL);
            case "less":
                return performComparison(ComparisonNode.Operation.LESS);
            case "lesseq":
                return performComparison(ComparisonNode.Operation.LESSEQUAL);
            case "greater":
                return performComparison(ComparisonNode.Operation.GREATER);
            case "greatereq":
                return performComparison(ComparisonNode.Operation.GREATEREQUAL);
            case "isint":
                return performPredicateAction(PredicateNode.Operation.ISINT);
            case "isreal":
                return performPredicateAction(PredicateNode.Operation.ISREAL);
            case "isbool":
                return performPredicateAction(PredicateNode.Operation.ISBOOL);
            case "isnull":
                return performPredicateAction(PredicateNode.Operation.ISNULL);
            case "isatom":
                return performPredicateAction(PredicateNode.Operation.ISATOM);
            case "islist":
                return performPredicateAction(PredicateNode.Operation.ISLIST);
            case "and":
                return performLogicalOperator(LogicalOperatorNode.Operation.AND);
            case "or":
                return performLogicalOperator(LogicalOperatorNode.Operation.OR);
            case "xor":
                return performLogicalOperator(LogicalOperatorNode.Operation.XOR);
            case "not":
                return performLogicalOperator(LogicalOperatorNode.Operation.NOT);
            case "eval":
                return performEvaluationAction();
        }
        return null;
    }

    private NodeInterface performArithmeticFunction(ArithmeticFunctionNode.Operation operation) {
        if (elements.size() != 3) {
            // todo throw a custom exception
            throw new RuntimeException("Arithmetic function must have two parameters!");
        }
        ArithmeticFunctionNode node = new ArithmeticFunctionNode(operation, elements.get(1), elements.get(2));
        return node.evaluate();
    }

    private NodeInterface performOperationOnList(OperationOnListsNode.Operation operation) {
        if (elements.size() == 2) {
            OperationOnListsNode node = new OperationOnListsNode(operation, elements.get(1));
            return node.evaluate();
        }
        if (elements.size() == 3) {
            OperationOnListsNode node = new OperationOnListsNode(operation, elements.get(1), elements.get(2));
            return node.evaluate();
        }
        // todo throw a custom exception
        throw new RuntimeException("Operation on list must have one or two parameters!");
    }

    private NodeInterface performComparison(ComparisonNode.Operation operation) {
        if (elements.size() != 3) {
            // todo throw a custom exception
            throw new RuntimeException("Comparison function must have two parameters!");
        }
        ComparisonNode node = new ComparisonNode(operation, elements.get(1), elements.get(2));
        return node.evaluate();
    }

    private NodeInterface performPredicateAction(PredicateNode.Operation operation) {
        if (elements.size() != 2) {
            // todo throw a custom exception
            throw new RuntimeException("Predicate function must have one parameter!");
        }
        PredicateNode node = new PredicateNode(operation, elements.get(1));
        return node.evaluate();
    }

    private NodeInterface performLogicalOperator(LogicalOperatorNode.Operation operation) {
        if (elements.size() == 2) {
            LogicalOperatorNode node = new LogicalOperatorNode(operation, elements.get(1));
            return node.evaluate();
        }
        if (elements.size() == 3) {
            LogicalOperatorNode node = new LogicalOperatorNode(operation, elements.get(1), elements.get(2));
            return node.evaluate();
        }
        // todo throw a custom exception
        throw new RuntimeException("Logical Operator must have one or two parameters!");
    }

    private NodeInterface performEvaluationAction() {
        if (elements.size() != 2) {
            // todo throw a custom exception
            throw new RuntimeException("Eval must have one parameter!");
        }
        EvaluatorNode node = new EvaluatorNode(elements.get(1));
        return node.evaluate();
    }
}
