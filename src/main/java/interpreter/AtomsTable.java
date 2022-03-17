package interpreter;

import syntax_analysis.node.AtomNode;
import syntax_analysis.node.ElementInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AtomsTable {
    private static AtomsTable INSTANCE;
    private final List<HashMap<String, ElementInterface>> localContext;

    private AtomsTable() {
        this.localContext = new ArrayList<>();
        this.localContext.add(new HashMap<>());
    }

    public static AtomsTable getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AtomsTable();
        }
        return INSTANCE;
    }

    public void resetContext() {
        INSTANCE = new AtomsTable();
    }

    public void introduceLocalContext() {
        this.localContext.add(new HashMap<>());
    }

    public void leaveLocalContext() {
        this.localContext.remove(this.localContext.size() - 1);
    }

    public void printAtomsInNestedContext() {
        final HashMap<String, ElementInterface> atoms = localContext.get(localContext.size() - 1);
        for (Map.Entry<String, ElementInterface> entry : atoms.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    public void addAtom(AtomNode atom) {
        final HashMap<String, ElementInterface> atoms = localContext.get(localContext.size() - 1);
        atoms.put(atom.name, atom.value);
    }

    public ElementInterface getAtomValue(String atomName) {
        if (PredefinedFunction.predefinedFunctionNames.contains(atomName)) {
            return new AtomNode(atomName, null);
        }
        for (int i = localContext.size() - 1; i >= 0; i--) {
            final HashMap<String, ElementInterface> atoms = localContext.get(i);
            if (atoms.containsKey(atomName)) {
                return atoms.get(atomName);
            }
        }
        throw new RuntimeException("Undefined atom: " + atomName);
    }

    public boolean contains(String atomName) {
        if (PredefinedFunction.predefinedFunctionNames.contains(atomName)) {
            return true;
        }
        for (int i = localContext.size() - 1; i >= 0; i--) {
            final HashMap<String, ElementInterface> atoms = localContext.get(i);
            if (atoms.containsKey(atomName)) {
                return true;
            }
        }
        return false;
    }
}
