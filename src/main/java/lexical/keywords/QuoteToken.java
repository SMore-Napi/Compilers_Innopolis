package lexical.keywords;

import lexical.Token;

public class QuoteToken extends Token {
    public QuoteToken(int row, int column, String content) {
        super(row, column, content);
    }
}
