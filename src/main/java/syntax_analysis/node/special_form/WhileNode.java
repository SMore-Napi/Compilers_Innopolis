package syntax_analysis.node.special_form;

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
        LiteralNode literalNode = (LiteralNode) condition.evaluate();
        while (literalNode.booleanValue){
            action.evaluate();
            literalNode = (LiteralNode) condition.evaluate();
        }
        return null;
    }
    @Override
    public String toString() {
        return "WhileNode{" +
                "condition=" + condition +
                ", action=" + action +
                '}';
    }
}
