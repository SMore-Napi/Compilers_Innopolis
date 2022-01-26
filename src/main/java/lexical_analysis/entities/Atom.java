package lexical_analysis.entities;

public class Atom extends Token {

    private Identifier identifier;
    private Literal literal;

    public Atom(int length, int row, int column, Identifier identifier, Literal literal) {
        super(TokenType.ATOM, length, row, column);
        this.identifier = identifier;
        this.literal = literal;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }

    public Literal getLiteral() {
        return literal;
    }

    public void setLiteral(Literal literal) {
        this.literal = literal;
    }

    @Override
    public String toString() {
        return "Atom{" +
                "identifier=" + identifier +
                ", literal=" + literal +
                '}';
    }
}
