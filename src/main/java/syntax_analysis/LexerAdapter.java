package syntax_analysis;

import lexical_analysis.Lexer;
import lexical_analysis.tokens.Token;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

public class LexerAdapter implements Parser.Lexer {

    private int currentTokenIndex;
    final private List<Token> tokens;

    public LexerAdapter(FileReader fileReader) throws IOException {
        Lexer lexer = new Lexer(fileReader);
        lexer.tokenize();
        tokens = lexer.getTokens();
        currentTokenIndex = 0;
    }

    public List<Token> getTokens() {
        return tokens;
    }

    @Override
    public Object getLVal() {
        return null;
    }

    @Override
    public int yylex() {
        if (currentTokenIndex == tokens.size()) {
            return YYEOF;
        }
        String tokenName = tokens.get(currentTokenIndex++).getClass().getSimpleName();
        int tokenCode = YYerror;
        try {
            Field field = Parser.Lexer.class.getDeclaredField(tokenName);
            tokenCode = (Integer) field.get(Parser.Lexer.class);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return tokenCode;
    }

    @Override
    public void yyerror(String msg) {
        System.out.println(msg);
    }
}