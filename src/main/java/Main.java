import lexical.Lexer;
import lexical.Token;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\dell\\Desktop\\Compilers_Innopolis\\src\\main\\java\\test.f");
        FileReader fileReader = new FileReader(file);
        Lexer lexer = new Lexer(fileReader);
        lexer.tokenize();
        ArrayList<Token> list = (ArrayList<Token>) lexer.getList();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}