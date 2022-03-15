package syntax_analysis;

import syntax_analysis.node.AtomNode;
import syntax_analysis.node.NodeInterface;

import java.util.HashMap;

public class AtomsTable {
    private final HashMap<String, NodeInterface> atoms;

    private static AtomsTable INSTANCE;

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

    public NodeInterface getAtomValue(String atomName) {
        return atoms.getOrDefault(atomName, null);
    }
}
