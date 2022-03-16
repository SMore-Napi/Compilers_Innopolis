package syntax_analysis.node.special_form;

import interpreter.AtomsTable;
import syntax_analysis.node.AtomNode;
import syntax_analysis.node.ElementInterface;
import interpreter.PredefinedFunction;

public class SetQNode implements ElementInterface {
    AtomNode atom;
    ElementInterface element;

    public SetQNode(AtomNode atom, ElementInterface element) {
        this.atom = atom;
        this.element = element;
    }

    @Override
    public ElementInterface evaluate() {
        //todo not only this keywords, but also special forms and user defined functions
        if (PredefinedFunction.isKeyword(atom.name)) {
            throw new RuntimeException("Can't reassign keyword: " + atom.name);
        }
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
