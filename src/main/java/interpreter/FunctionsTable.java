package interpreter;

import syntax_analysis.node.FunctionAtom;

import java.util.HashMap;

public class FunctionsTable {
    private static FunctionsTable INSTANCE;
    private final HashMap<String, FunctionAtom> functions;

    private FunctionsTable() {
        this.functions = new HashMap<>();
    }

    public static FunctionsTable getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new FunctionsTable();
        }
        return INSTANCE;
    }

    public void clearTable() {
        functions.clear();
    }

    public void addFunction(String atomName, FunctionAtom function) {
        functions.put(atomName, function);
    }

    public FunctionAtom getFunctionValue(String atomName) {
        return functions.getOrDefault(atomName, null);
    }

    public boolean contains(String name) {
        return functions.containsKey(name);
    }
}