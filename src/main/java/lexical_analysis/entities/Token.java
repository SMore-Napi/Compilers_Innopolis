package lexical_analysis.entities;

public class Token {
    public enum TokenType {
        ATOM, LIST, LITERAL
    }

    private TokenType tokenType;
    private int length;
    private int row;
    private int column;

    public Token(TokenType tokenType, int length, int row, int column) {
        this.tokenType = tokenType;
        this.length = length;
        this.row = row;
        this.column = column;
    }

    public TokenType getTokenType() {
        return tokenType;
    }

    public void setTokenType(TokenType tokenType) {
        this.tokenType = tokenType;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public String toString() {
        return "Token{" +
                "tokenType=" + tokenType +
                ", length=" + length +
                ", row=" + row +
                ", column=" + column +
                '}';
    }
}
