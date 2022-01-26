import lexical_analysis.Lexer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String file = "C:\\Users\\dell\\Desktop\\Compilers_Innopolis\\src\\main\\java\\test.f";
        Path path = Paths.get(file);
        List<String> lines = Files.readAllLines(path);

        Lexer lexer = new Lexer(lines);


        //TODO: check if I correctly created all the entities

        //TODO: implement getTokens function
        lexer.getTokens();
    }
}
