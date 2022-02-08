import lexical_analysis.Lexer;
import lexical_analysis.tokens.Token;

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
        Lexer lexer = new Lexer(fileReader);
        lexer.tokenize();
        return lexer.getTokens();
    }
}
