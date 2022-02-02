package lexical.identifier;

import lexical.Token;

public class IdentifierToken extends Token {
    public IdentifierToken(int row, int column, String content) {
        super(row, column, content);
    }
}
