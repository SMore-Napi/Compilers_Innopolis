package syntax_analysis.node;

import interpreter.AtomsTable;
import interpreter.FunctionsTable;
import lexical_analysis.tokens.Token;

public class AtomNode implements ElementInterface {
    public String name;
    public ElementInterface value;

    public AtomNode(Token token) {
        name = token.getContent();
        value = null;
    }

    public AtomNode(String name, ElementInterface value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public ElementInterface evaluate() {
        if (AtomsTable.getInstance().contains(name)) {
            return AtomsTable.getInstance().getAtomValue(name);
        }
        if (FunctionsTable.getInstance().contains(name)) {
            return FunctionsTable.getInstance().getFunctionValue(name);
        }
        throw new RuntimeException("Undefined atom: " + name);
    }

    @Override
    public String toString() {
        return name;
    }
}