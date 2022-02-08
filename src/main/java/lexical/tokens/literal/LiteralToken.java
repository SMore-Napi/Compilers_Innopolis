package lexical.tokens.literal;

import lexical.tokens.Token;

public class LiteralToken extends Token {
    public LiteralToken(int row, int column, String content) {
        super(row, column, content);
    }
}
