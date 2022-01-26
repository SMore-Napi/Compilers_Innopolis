package lexical_analysis;

import lexical_analysis.entities.Token;

import java.util.ArrayList;
import java.util.List;

public class Lexer {
    private ArrayList<Token> tokens = new ArrayList<Token>();
    private List<String> source;
    private int row = 0;
    private int column = 0;

    public Lexer(List<String> source) {
        this.source = source;
    }

    public void getTokens() {

    }
}
