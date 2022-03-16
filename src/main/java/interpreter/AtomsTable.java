package interpreter;

import syntax_analysis.node.AtomNode;
import syntax_analysis.node.ElementInterface;

import java.util.HashMap;

public class AtomsTable {
    private static AtomsTable INSTANCE;
    private final HashMap<String, ElementInterface> atoms;

    private AtomsTable() {
        this.atoms = new HashMap<>();
    }

    public static AtomsTable getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AtomsTable();
        }
        return INSTANCE;
    }

    public void clearTable() {
        atoms.clear();
    }

    public void addAtom(AtomNode atom) {
        atoms.put(atom.name, atom.value);
    }

    public ElementInterface getAtomValue(String atomName) {
        return atoms.getOrDefault(atomName, null);
    }

    public boolean contains(String name) {
        return atoms.containsKey(name);
    }
}
