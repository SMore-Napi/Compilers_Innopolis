package syntax_analysis.node.special_form;

import syntax_analysis.node.ElementInterface;

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
    public String toString() {
        return "CondNode{" +
                "condition=" + condition +
                ", trueAction=" + trueAction +
                ", falseAction=" + falseAction +
                '}';
    }
}