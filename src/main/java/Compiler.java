import interpreter.Interpreter;
import lexical_analysis.tokens.Token;
import syntax_analysis.LexerAdapter;
import syntax_analysis.Parser;
import syntax_analysis.node.AST;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Compiler {

    private final String sourceProgramPath;

    public Compiler(final String sourceProgramPath) {
        this.sourceProgramPath = sourceProgramPath;
    }

    public List<Token> lexicalAnalysis() throws IOException {
        FileReader fileReader = new FileReader(sourceProgramPath);
        LexerAdapter lexerAdapter = new LexerAdapter(fileReader);
        return lexerAdapter.getTokens();
    }

    public AST syntaxAnalysis() throws IOException {
        return Parser.makeAST(sourceProgramPath);
    }

    public String interpret() throws IOException {
        return this.interpret(null);
    }

    public String interpret(final Boolean logging) throws IOException {
        AST ast = this.syntaxAnalysis();
        if (ast != null) {
            Interpreter interpreter = logging != null ? new Interpreter(ast, logging) : new Interpreter(ast);
            return interpreter.interpret();
        }
        return "";
    }
}
