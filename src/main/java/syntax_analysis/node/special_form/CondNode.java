package syntax_analysis.node.special_form;

import syntax_analysis.node.NodeInterface;

public
class CondNode implements NodeInterface {
    NodeInterface condition;
    NodeInterface trueAction;
    NodeInterface falseAction;

    public CondNode(NodeInterface condition, NodeInterface trueAction) {
        this.condition = condition;
        this.trueAction = trueAction;
        this.falseAction = null;
    }

    public CondNode(NodeInterface condition, NodeInterface trueAction, NodeInterface falseAction) {
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