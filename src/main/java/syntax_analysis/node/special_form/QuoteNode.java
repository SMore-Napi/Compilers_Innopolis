package syntax_analysis.node.special_form;

import syntax_analysis.node.NodeInterface;

public class QuoteNode implements NodeInterface {
    NodeInterface element;

    public QuoteNode(NodeInterface element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return "QuoteNode{" +
                "element=" + element +
                '}';
    }
}
