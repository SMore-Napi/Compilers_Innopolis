package syntax_analysis.node.special_form;

import syntax_analysis.node.AtomNode;
import syntax_analysis.node.NodeInterface;

public class FuncNode implements NodeInterface {
    AtomNode atom;
    NodeInterface list;
    NodeInterface element;

    public FuncNode(AtomNode atom, NodeInterface list, NodeInterface element) {
        this.atom = atom;
        this.list = list;
        this.element = element;
    }

    @Override
    public String toString() {
        return "FuncNode{" +
                "atom=" + atom +
                ", list=" + list +
                ", element=" + element +
                '}';
    }
}
