package syntax_analysis.node.special_form;

import syntax_analysis.node.ElementInterface;

public class WhileNode implements ElementInterface {
    ElementInterface condition;
    ElementInterface action;

    public WhileNode(ElementInterface condition, ElementInterface action) {
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
