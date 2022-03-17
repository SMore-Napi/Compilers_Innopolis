package syntax_analysis.node.special_form;

import interpreter.AtomsTable;
import interpreter.DefinedFunction;
import interpreter.PredefinedFunction;
import syntax_analysis.node.AtomNode;
import syntax_analysis.node.ElementInterface;

public class SetQNode implements ElementInterface {
    AtomNode atom;
    ElementInterface element;

    public SetQNode(AtomNode atom, ElementInterface element) {
        this.atom = atom;
        this.element = element;
    }

    @Override
    public ElementInterface evaluate() {
        if (PredefinedFunction.isKeyword(atom.name)) {
            throw new RuntimeException("Can't reassign keyword: " + atom.name);
        }
        if (DefinedFunction.isDefinedFunction(atom.name)) {
            throw new RuntimeException("There is a defined function: " + atom.name);
        }
        atom.value = element.evaluate();
        /*
        if (atom.value instanceof FunctionAtom) {
            FunctionsTable.getInstance().addFunction(atom.name, (FunctionAtom) atom.value);
        } else {
            AtomsTable.getInstance().addAtom(atom);
        }
         */
        AtomsTable.getInstance().addAtom(atom);
        return null;
    }

    @Override
    public String toString() {
        return "SetQ{" +
                "atom=" + atom +
                ", element=" + element +
                '}';
    }
}
