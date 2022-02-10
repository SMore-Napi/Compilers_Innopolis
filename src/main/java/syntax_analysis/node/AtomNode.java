package syntax_analysis.node;

import lexical_analysis.tokens.IdentifierToken;

public class AtomNode extends Node {
    public String name;
    public String value;

    public AtomNode(IdentifierToken token) {
        name = token.getContent();
    }

    @Override
    public String toString() {
        return "AtomNode{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}