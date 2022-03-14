import lexical_analysis.tokens.Token;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLexicalAnalysis {

    String programsDirectory = "Tests/LexicalAnalysis/";

    @Test
    void testAllTokens() throws IOException {
        String programName = programsDirectory + "allTokens.txt";
        String expected = "[QuoteToken row=0, columns=0:5, content=\"quote\", QuoteShortToken row=0, columns=6:7, content=\"'\", SetQToken row=0, columns=8:12, content=\"setq\", FuncToken row=0, columns=13:17, content=\"func\", LambdaToken row=0, columns=18:24, content=\"lambda\", ProgToken row=0, columns=25:29, content=\"prog\", CondToken row=0, columns=30:34, content=\"cond\", WhileToken row=0, columns=35:40, content=\"while\", ReturnToken row=0, columns=41:47, content=\"return\", BreakToken row=0, columns=48:53, content=\"break\", PlusToken row=1, columns=0:4, content=\"plus\", MinusToken row=1, columns=5:10, content=\"minus\", TimesToken row=1, columns=11:16, content=\"times\", DivideToken row=1, columns=17:23, content=\"divide\", HeadToken row=2, columns=0:4, content=\"head\", TailToken row=2, columns=5:9, content=\"tail\", ConsToken row=2, columns=10:14, content=\"cons\", EqualToken row=3, columns=0:5, content=\"equal\", NonEqualToken row=3, columns=6:14, content=\"nonequal\", LessToken row=3, columns=15:19, content=\"less\", LessEqToken row=3, columns=20:26, content=\"lesseq\", GreaterToken row=3, columns=27:34, content=\"greater\", GreaterEqToken row=3, columns=35:44, content=\"greatereq\", IsIntToken row=4, columns=0:5, content=\"isint\", IsRealToken row=4, columns=6:12, content=\"isreal\", IsBoolToken row=4, columns=13:19, content=\"isbool\", IsNullToken row=4, columns=20:26, content=\"isnull\", IsAtomToken row=4, columns=27:33, content=\"isatom\", IsListToken row=4, columns=34:40, content=\"islist\", AndToken row=5, columns=0:3, content=\"and\", OrToken row=5, columns=4:6, content=\"or\", XorToken row=5, columns=7:10, content=\"xor\", NotToken row=5, columns=11:14, content=\"not\", EvalToken row=6, columns=0:4, content=\"eval\", IntegerNumberLiteralToken row=7, columns=0:3, content=\"123\", IntegerNumberLiteralToken row=7, columns=4:8, content=\"-543\", RealNumberLiteralToken row=7, columns=9:12, content=\"2.3\", RealNumberLiteralToken row=7, columns=13:18, content=\"-42.2\", BooleanLiteralToken row=7, columns=19:23, content=\"true\", BooleanLiteralToken row=7, columns=24:29, content=\"false\", NullLiteralToken row=7, columns=30:34, content=\"null\", OpenParenthesisToken row=8, columns=0:1, content=\"(\", CloseParenthesisToken row=8, columns=2:3, content=\")\"]";
        Compiler compiler = new Compiler(programName);
        List<Token> tokens = compiler.lexicalAnalysis();
        String actual = tokens.toString();
        assertEquals(expected, actual);
    }
}
