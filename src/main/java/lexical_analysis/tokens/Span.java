package lexical_analysis.tokens;

public class Span {
    private final int lineNumber;
    private final int positionBegin;
    private final int positionEnd;

    public Span(int lineNumber, int positionBegin, int positionEnd) {
        this.lineNumber = lineNumber;
        this.positionBegin = positionBegin;
        this.positionEnd = positionEnd;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public int getPositionBegin() {
        return positionBegin;
    }

    public int getPositionEnd() {
        return positionEnd;
    }
}
