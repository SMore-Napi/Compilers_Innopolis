package lexical.number_literals;

import lexical.Token;

public class IntegerNumberLiteralToken extends Token {
    public IntegerNumberLiteralToken(int row, int column, String content) {
        super(row, column, content);
    }
}
