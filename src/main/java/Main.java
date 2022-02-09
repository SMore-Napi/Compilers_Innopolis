import lexical_analysis.tokens.Token;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // String defaultPath = "FPrograms/testProgram.txt";
        String defaultPath = "FPrograms/allTokens.txt";

        String programSourcePath = args.length >= 1
                ? programSourcePath = args[0]
                : defaultPath;
        String programOutputPath = args.length >= 2
                ? programOutputPath = args[1]
                : programSourcePath;
        programOutputPath = programOutputPath + ".out";
        run(programSourcePath, programOutputPath);
    }

    public static void run(String programSourcePath, String programOutputPath) {
        try {
            Compiler compiler = new Compiler(programSourcePath);
            List<Token> tokens = compiler.lexicalAnalysis();
            System.out.println("Tokens found after lexical analysis:");
            System.out.println();
            tokens.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("No such source file: " + programSourcePath);
        }
    }
}
