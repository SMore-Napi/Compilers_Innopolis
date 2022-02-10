import lexical_analysis.tokens.Token;
import syntax_analysis.LexerAdapter;
import syntax_analysis.Parser;
import syntax_analysis.node.AST;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Compiler {

    private final String sourceProgramPath;

    public Compiler(String sourceProgramPath) {
        this.sourceProgramPath = sourceProgramPath;
    }

    public List<Token> lexicalAnalysis() throws IOException {
        FileReader fileReader = new FileReader(sourceProgramPath);
        LexerAdapter lexerAdapter = new LexerAdapter(fileReader);
        return lexerAdapter.getTokens();
    }

    public void syntaxAnalysis() throws IOException {
        AST ast = Parser.makeAST(sourceProgramPath);
        System.out.println("======");
        ast.printAST();
    }
}
