package syntax_analysis.node.special_form;

import syntax_analysis.node.AtomNode;
import syntax_analysis.node.NodeInterface;

public class SetqNode implements NodeInterface {
    AtomNode atom;
    NodeInterface element;

    public SetqNode(AtomNode atom, NodeInterface element) {
        this.atom = atom;
        this.element = element;
    }

    @Override
    public String toString() {
        return "SetqNode{" +
                "atom=" + atom +
                ", element=" + element +
                '}';
    }
}
