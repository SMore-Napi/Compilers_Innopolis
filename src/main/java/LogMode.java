import lexical_analysis.tokens.Token;
import syntax_analysis.node.AST;

import java.io.IOException;
import java.util.List;

public class LogMode {
    private final Compiler compiler;

    public LogMode(final String sourceProgramPath) {
        compiler = new Compiler(sourceProgramPath);
    }

    public void logging() {
        boolean successfullyFinished;
        successfullyFinished = printTokens();
        if (successfullyFinished)
            successfullyFinished = printAST();
        if (successfullyFinished)
            printInterpretation();
    }

    private boolean printTokens() {
        try {
            List<Token> tokens = compiler.lexicalAnalysis();
            System.out.println("Tokens found after lexical analysis:");
            System.out.println();
            tokens.forEach(System.out::println);
            System.out.println();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean printAST() {
        try {
            AST ast = compiler.syntaxAnalysis();
            if (ast == null) {
                return false;
            }
            System.out.println("AST nodes:");
            ast.printAST();
            System.out.println();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean printInterpretation() {
        try {
            System.out.println("Interpretation:");
            String result = compiler.interpret(true);
            System.out.println("Output:");
            System.out.println(result);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
