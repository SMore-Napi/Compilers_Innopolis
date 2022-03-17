package syntax_analysis.node.special_form;

import interpreter.NestedFormBreak;
import syntax_analysis.node.ElementInterface;
import syntax_analysis.node.LiteralNode;

public class WhileNode implements ElementInterface {
    ElementInterface condition;
    ElementInterface action;

    public WhileNode(ElementInterface condition, ElementInterface action) {
        this.condition = condition;
        this.action = action;
    }

    @Override
    public ElementInterface evaluate() {
        NestedFormBreak.getInstance().introduceLocalScope();
        while (true) {
            ElementInterface conditionEvaluation = condition.evaluate();
            if ((conditionEvaluation instanceof LiteralNode) && ((LiteralNode) conditionEvaluation).booleanValue != null) {
                if (((LiteralNode) conditionEvaluation).booleanValue) {
                    ElementInterface evaluateResult = this.action.evaluate();
                    if (evaluateResult instanceof BreakNode) {
                        return new LiteralNode();
                    }
                } else {
                    NestedFormBreak.getInstance().leaveLocalScope();
                    return new LiteralNode();
                }
            } else {
                throw new RuntimeException("The condition argument should be boolean, but given " + condition);
            }
        }
    }

    @Override
    public String toString() {
        return "WhileNode{" +
                "condition=" + condition +
                ", action=" + action +
                '}';
    }
}
