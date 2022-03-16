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
//        value = AtomsTable.getInstance().getAtomValue(name);
//        return this;
    }

    @Override
    public String toString() {
        //todo return just value
        return "AtomNode{" +
                "name='" + name + '\'' +
                ", value={" + value + '}' +
                '}';
        /*
        if (AtomsTable.getInstance().contains(name)) {
            value = AtomsTable.getInstance().getAtomValue(name);
            return "AtomNode{" +
                    "name='" + name + '\'' +
                    ", value={" + value + '}' +
                    '}';
        } else {
            return "AtomNode{" +
                    "name='" + name + '\'' +
                    // todo fix
                  //  ", value={" + name + '}' +
                    ", value={" + value + '}' +
                    '}';
        }

         */
    }
}