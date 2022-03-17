package interpreter;

import syntax_analysis.node.AtomNode;
import syntax_analysis.node.ElementInterface;
import syntax_analysis.node.predefined_function.*;

import java.util.Arrays;
import java.util.List;

public class PredefinedFunction {

    static final List<String> predefinedFunctionNames = Arrays.asList("plus", "minus", "times", "divide", "head", "tail",
            "cons", "equal", "nonequal", "less", "lesseq", "greater", "greatereq", "isint", "isreal", "isbool",
            "isnull", "isatom", "islist", "and", "or", "xor", "not", "eval");
    List<ElementInterface> elements;

    public PredefinedFunction(List<ElementInterface> elements) {
        this.elements = elements;
    }

    public static boolean isPredefinedFunction(ElementInterface element) {
        try {
            AtomNode atom = (AtomNode) element;
            return predefinedFunctionNames.contains(atom.name);
        } catch (ClassCastException | IndexOutOfBoundsException e) {
            return false;
        }
    }

    public static boolean isKeyword(String keyword) {
        return predefinedFunctionNames.contains(keyword);
    }

    public boolean isPredefinedFunction() {
        if (elements.isEmpty()) {
            return false;
        }
        return isPredefinedFunction(elements.get(0));
    }

    public ElementInterface performFunctionAction() {
        AtomNode atom = (AtomNode) elements.get(0);
        switch (atom.name) {
            case "plus":
                return performArithmeticFunction(ArithmeticFunction.Operation.ADDITION);
            case "minus":
                return performArithmeticFunction(ArithmeticFunction.Operation.SUBTRACTION);
            case "times":
                return performArithmeticFunction(ArithmeticFunction.Operation.MULTIPLICATION);
            case "divide":
                return performArithmeticFunction(ArithmeticFunction.Operation.DIVISION);
            case "head":
                return performOperationOnList(OperationOnListFunction.Operation.HEAD);
            case "tail":
                return performOperationOnList(OperationOnListFunction.Operation.TAIL);
            case "cons":
                return performOperationOnList(OperationOnListFunction.Operation.CONS);
            case "equal":
                return performComparison(ComparisonFunction.Operation.EQUAL);
            case "nonequal":
                return performComparison(ComparisonFunction.Operation.NONEQUAL);
            case "less":
                return performComparison(ComparisonFunction.Operation.LESS);
            case "lesseq":
                return performComparison(ComparisonFunction.Operation.LESSEQUAL);
            case "greater":
                return performComparison(ComparisonFunction.Operation.GREATER);
            case "greatereq":
                return performComparison(ComparisonFunction.Operation.GREATEREQUAL);
            case "isint":
                return performPredicateAction(PredicateFunction.Operation.ISINT);
            case "isreal":
                return performPredicateAction(PredicateFunction.Operation.ISREAL);
            case "isbool":
                return performPredicateAction(PredicateFunction.Operation.ISBOOL);
            case "isnull":
                return performPredicateAction(PredicateFunction.Operation.ISNULL);
            case "isatom":
                return performPredicateAction(PredicateFunction.Operation.ISATOM);
            case "islist":
                return performPredicateAction(PredicateFunction.Operation.ISLIST);
            case "and":
                return performLogicalOperator(LogicalOperatorFunction.Operation.AND);
            case "or":
                return performLogicalOperator(LogicalOperatorFunction.Operation.OR);
            case "xor":
                return performLogicalOperator(LogicalOperatorFunction.Operation.XOR);
            case "not":
                return performLogicalOperator(LogicalOperatorFunction.Operation.NOT);
            case "eval":
                return performEvaluationAction();
        }
        return null;
    }

    private ElementInterface performArithmeticFunction(ArithmeticFunction.Operation operation) {
        if (elements.size() != 3) {
            throw new RuntimeException("Arithmetic function must have two parameters!");
        }
        ArithmeticFunction node = new ArithmeticFunction(operation, elements.get(1), elements.get(2));
        return node.evaluate();
    }

    private ElementInterface performOperationOnList(OperationOnListFunction.Operation operation) {
        if (elements.size() == 2) {
            OperationOnListFunction node = new OperationOnListFunction(operation, elements.get(1));
            return node.evaluate();
        }
        if (elements.size() == 3) {
            OperationOnListFunction node = new OperationOnListFunction(operation, elements.get(1), elements.get(2));
            return node.evaluate();
        }
        throw new RuntimeException("Operation on list must have one or two parameters!");
    }

    private ElementInterface performComparison(ComparisonFunction.Operation operation) {
        if (elements.size() != 3) {
            throw new RuntimeException("Comparison function must have two parameters!");
        }
        ComparisonFunction node = new ComparisonFunction(operation, elements.get(1), elements.get(2));
        return node.evaluate();
    }

    private ElementInterface performPredicateAction(PredicateFunction.Operation operation) {
        if (elements.size() != 2) {
            throw new RuntimeException("Predicate function must have one parameter!");
        }
        PredicateFunction node = new PredicateFunction(operation, elements.get(1));
        return node.evaluate();
    }

    private ElementInterface performLogicalOperator(LogicalOperatorFunction.Operation operation) {
        if (elements.size() == 2) {
            LogicalOperatorFunction node = new LogicalOperatorFunction(operation, elements.get(1));
            return node.evaluate();
        }
        if (elements.size() == 3) {
            LogicalOperatorFunction node = new LogicalOperatorFunction(operation, elements.get(1), elements.get(2));
            return node.evaluate();
        }
        throw new RuntimeException("Logical Operator must have one or two parameters!");
    }

    private ElementInterface performEvaluationAction() {
        if (elements.size() != 2) {
            throw new RuntimeException("Eval must have one parameter!");
        }
        EvaluatorFunction node = new EvaluatorFunction(elements.get(1));
        return node.evaluate();
    }
}
