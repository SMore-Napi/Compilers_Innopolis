package syntax_analysis.node.special_form;

import syntax_analysis.node.NodeInterface;

public class ReturnNode implements NodeInterface {
    NodeInterface element;

    public ReturnNode(NodeInterface element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return "ReturnNode{" +
                "element=" + element +
                '}';
    }
}
