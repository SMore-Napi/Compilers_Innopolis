package lexical_analysis.tokens.literal;

import lexical_analysis.tokens.Token;

public class LiteralToken extends Token {
    public LiteralToken(int row, int column, String content) {
        super(row, column, content);
    }
}
