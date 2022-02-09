package lexical_analysis.tokens;

public class Token {
    final private Span span;
    final private String content;

    public Token(int row, int column, String content) {
        this.content = content;
        this.span = new Span(row, column, column + content.length());
    }

    public int getRow() {
        return span.getLineNumber();
    }

    public int getColumn() {
        return span.getPositionBegin();
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                " row=" + span.getLineNumber() +
                ", columns=" + span.getPositionBegin() + ":" + span.getPositionEnd() +
                ", content=\"" + content + '\"';
    }

    public int getTokenId() { // вроде правильно
        String tokenName = this.getClass().getSimpleName();
        return 258;
        //return TokenEnum.valueOf(tokenName).ordinal();
    }
}


