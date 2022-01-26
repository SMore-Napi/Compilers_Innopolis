package lexical_analysis.entities;

public class Literal extends Token {
    public Literal(int length, int row, int column) {
        super(TokenType.LITERAL, length, row, column);
    }
}
