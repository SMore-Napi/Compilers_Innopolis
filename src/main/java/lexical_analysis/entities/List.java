package lexical_analysis.entities;

import java.util.ArrayList;

public class List extends Token {
    private ArrayList<Token> list;
    private Token head;
    private ArrayList<Token> tail;


    public List(int length, int row, int column, ArrayList<Token> list) {
        super(TokenType.LIST, length, row, column);
        this.list = list;
        head = list.get(0);
        tail = (ArrayList<Token>) list.subList(1, list.size());
    }

    public ArrayList<Token> getList() {
        return list;
    }

    public void setList(ArrayList<Token> list) {
        this.list = list;
    }

    public Token getHead() {
        return head;
    }

    public void setHead(Token head) {
        this.head = head;
    }

    public ArrayList<Token> getTail() {
        return tail;
    }

    public void setTail(ArrayList<Token> tail) {
        this.tail = tail;
    }


}
