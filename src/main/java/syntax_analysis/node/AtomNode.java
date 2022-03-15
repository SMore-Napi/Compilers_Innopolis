package syntax_analysis.node;

import lexical_analysis.tokens.Token;
import syntax_analysis.AtomsTable;

public class AtomNode implements NodeInterface {
    public String name;
    public NodeInterface value;

    public AtomNode(Token token) {
        name = token.getContent();
        value = null;
    }

    @Override
    public NodeInterface evaluate() {
        return AtomsTable.getInstance().getAtomValue(name);
//        value = AtomsTable.getInstance().getAtomValue(name);
//        return this;
    }

    @Override
    public String toString() {
        return "AtomNode{" +
                "name='" + name + '\'' +
                ", value={" + value + '}' +
                '}';
    }
}