package lexical_analysis.tokens.keyword;

import lexical_analysis.tokens.Token;

public class KeywordToken extends Token {
    public KeywordToken(int row, int column, String content) {
        super(row, column, content);
    }
}
