package syntax_analysis.node.special_form;

import syntax_analysis.node.NodeInterface;

public class LambdaNode implements NodeInterface {
    NodeInterface list;
    NodeInterface element;

    public LambdaNode(NodeInterface list, NodeInterface element) {
        this.list = list;
        this.element = element;
    }

    @Override
    public String toString() {
        return "LambdaNode{" +
                "list=" + list +
                ", element=" + element +
                '}';
    }
}
