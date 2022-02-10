package syntax_analysis.node;

import java.util.ArrayList;
import java.util.List;

public class ListNode extends Node {
    List<ElementNode> elements;
    ArithmeticFunctionNode arithmeticFunction;
    OperationOnListsNode operationOnLists;
    ComparisonNode comparison;
    PredicateNode predicate;
    LogicalOperatorNode logicalOperator;
    EvaluatorNode evaluatorNode;
    SpecialFormNode specialForm;

    public ListNode() {
        elements = new ArrayList<>();
    }

    public ListNode(ArithmeticFunctionNode arithmeticFunction) {
        this.arithmeticFunction = arithmeticFunction;
    }

    public ListNode(OperationOnListsNode operationOnLists) {
        this.operationOnLists = operationOnLists;
    }

    public ListNode(ComparisonNode comparison) {
        this.comparison = comparison;
    }

    public ListNode(PredicateNode predicate) {
        this.predicate = predicate;
    }

    public ListNode(LogicalOperatorNode logicalOperator) {
        this.logicalOperator = logicalOperator;
    }

    public ListNode(EvaluatorNode evaluatorNode) {
        this.evaluatorNode = evaluatorNode;
    }

    public ListNode(SpecialFormNode specialForm) {
        this.specialForm = specialForm;
    }

    public ListNode(ElementNode element) {
        elements = new ArrayList<>();
        elements.add(element);
    }

    public ListNode(ElementNode element, ListNode list) {
        elements = new ArrayList<>();
        elements.add(element);
        elements.addAll(list.elements);
    }

    @Override
    public String toString() {
        if (arithmeticFunction != null) {
            return "ListNode{" +
                    "arithmeticFunction=" + arithmeticFunction +
                    '}';
        }
        if (operationOnLists != null) {
            return "ListNode{" +
                    "operationOnLists=" + operationOnLists +
                    '}';
        }
        if (comparison != null) {
            return "ListNode{" +
                    "comparison=" + comparison +
                    '}';
        }
        if (predicate != null) {
            return "ListNode{" +
                    "predicate=" + predicate +
                    '}';
        }
        if (logicalOperator != null) {
            return "ListNode{" +
                    "logicalOperator=" + logicalOperator +
                    '}';
        }
        if (evaluatorNode != null) {
            return "ListNode{" +
                    "evaluatorNode=" + evaluatorNode +
                    '}';
        }
        if (specialForm != null) {
            return "ListNode{" +
                    "specialForm=" + specialForm +
                    '}';
        }
        return "ListNode{" +
                "elements=" + elements +
                '}';
    }
}
