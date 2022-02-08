import lexical.tokens.Token;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        // String programName = "FPrograms/testProgram.txt";
        String programName = "FPrograms/allTokens.txt";
        Compiler compiler = new Compiler(programName);
        List<Token> tokens = compiler.lexicalAnalysis();
        System.out.println("Tokens found after lexical analysis:");
        System.out.println();
        tokens.forEach(System.out::println);
    }
}