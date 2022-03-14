package syntax_analysis.node.special_form;

import syntax_analysis.AtomsTable;
import syntax_analysis.node.AtomNode;
import syntax_analysis.node.NodeInterface;

public class SetQNode implements NodeInterface {
    AtomNode atom;
    NodeInterface element;

    public SetQNode(AtomNode atom, NodeInterface element) {
        this.atom = atom;
        this.element = element;
    }

    @Override
    public NodeInterface evaluate() {
        atom.value = element.evaluate();
        AtomsTable.getInstance().addAtom(atom);
        return atom;
    }

    @Override
    public String toString() {
        return "SetQ{" +
                "atom=" + atom +
                ", element=" + element +
                '}';
    }
}
