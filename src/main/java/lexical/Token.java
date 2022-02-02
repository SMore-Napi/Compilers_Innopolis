package lexical;

public class Token {
    private int row;
    private int column;
    private String content;

    public Token(int row, int column, String content) {
        this.row = row;
        this.column = column;
        this.content = content;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public String toString() {
        return  getClass().getSimpleName() +
                " row=" + row +
                ", column=" + column +
                ", content='" + content + '\'';
    }
}
