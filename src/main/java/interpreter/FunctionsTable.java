package interpreter;

import syntax_analysis.node.ElementInterface;
import syntax_analysis.node.FunctionAtom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FunctionsTable {
    private static FunctionsTable INSTANCE;
    //private final HashMap<String, FunctionAtom> functions;
    private final List<HashMap<String, ElementInterface>> localContext;

    private FunctionsTable() {
        this.localContext = new ArrayList<>();
        //this.functions = new HashMap<>();
        this.localContext.add(new HashMap<>());
    }

    public static FunctionsTable getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new FunctionsTable();
        }
        return INSTANCE;
    }

    public void resetTable() {
        INSTANCE = new FunctionsTable();
    }

    public void introduceLocalContext() {
        this.localContext.add(new HashMap<>());
    }

    public void leaveLocalContext() {
        this.localContext.remove(this.localContext.size() - 1);
    }


    public void addFunction(String atomName, FunctionAtom function) {
        final HashMap<String, ElementInterface> functions = localContext.get(localContext.size() - 1);
        functions.put(atomName, function);
    }

    public FunctionAtom getFunctionValue(String atomName) {
        for (int i = localContext.size() - 1; i >= 0; i--) {
            final HashMap<String, ElementInterface> functions = localContext.get(i);
            if (functions.containsKey(atomName)) {
                return (FunctionAtom) functions.get(atomName);
            }
        }
        throw new RuntimeException("Undefined function: " + atomName);
    }

    public boolean contains(String atomName) {
        for (int i = localContext.size() - 1; i >= 0; i--) {
            final HashMap<String, ElementInterface> atoms = localContext.get(i);
            if (atoms.containsKey(atomName)) {
                return true;
            }
        }
        return false;
    }
}