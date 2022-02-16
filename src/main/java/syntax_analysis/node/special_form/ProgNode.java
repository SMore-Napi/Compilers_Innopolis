package syntax_analysis.node.special_form;

import syntax_analysis.node.NodeInterface;

public class ProgNode implements NodeInterface {
    NodeInterface list;
    NodeInterface element;

    public ProgNode(NodeInterface list, NodeInterface element) {
        this.list = list;
        this.element = element;
    }

    @Override
    public String toString() {
        return "ProgNode{" +
                "list=" + list +
                ", element=" + element +
                '}';
    }
}
