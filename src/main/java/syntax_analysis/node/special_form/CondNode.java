package syntax_analysis.node.special_form;

import syntax_analysis.node.ElementInterface;
import syntax_analysis.node.LiteralNode;

public
class CondNode implements ElementInterface {
    ElementInterface condition;
    ElementInterface trueAction;
    ElementInterface falseAction;

    public CondNode(ElementInterface condition, ElementInterface trueAction) {
        this.condition = condition;
        this.trueAction = trueAction;
        this.falseAction = null;
    }

    public CondNode(ElementInterface condition, ElementInterface trueAction, ElementInterface falseAction) {
        this.condition = condition;
        this.trueAction = trueAction;
        this.falseAction = falseAction;
    }

    @Override
    public ElementInterface evaluate() {
        LiteralNode literalNode = (LiteralNode) condition.evaluate();
        if (!literalNode.booleanValue && this.falseAction == null) {
            return new LiteralNode();
        }
        try {
            if (literalNode.booleanValue) {
                return trueAction.evaluate();
            } else {
                return falseAction.evaluate();
            }
        } catch (NullPointerException nullPointerException) {
            throw new RuntimeException("First element in 'cond' should be boolean, but given " + literalNode);
        }
    }

    @Override
    public String toString() {
        return "CondNode{" +
                "condition=" + condition +
                ", trueAction=" + trueAction +
                ", falseAction=" + falseAction +
                '}';
    }
}