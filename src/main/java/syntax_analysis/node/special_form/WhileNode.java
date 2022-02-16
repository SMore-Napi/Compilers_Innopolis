package syntax_analysis.node.special_form;

import syntax_analysis.node.NodeInterface;

public class WhileNode implements NodeInterface {
    NodeInterface condition;
    NodeInterface action;

    public WhileNode(NodeInterface condition, NodeInterface action) {
        this.condition = condition;
        this.action = action;
    }

    @Override
    public String toString() {
        return "WhileNode{" +
                "condition=" + condition +
                ", action=" + action +
                '}';
    }
}
