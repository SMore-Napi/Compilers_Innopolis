import org.junit.jupiter.api.Test;
import syntax_analysis.node.AST;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSyntaxAnalysis {
    String programsDirectory = "Tests/SyntaxAnalysis/";

    void runCompilerEquals(String programName, String expected) throws IOException {
        Compiler compiler = new Compiler(programName);
        AST ast = compiler.syntaxAnalysis();
        String actual = ast.toString();
        assertEquals(expected, actual);
    }

    @Test
    void testListLiterals() throws IOException {
        String programName = programsDirectory + "list_literals.txt";
        String expected = "'('(1 2 3 true null false 1.3 0 -3.2 -8 0.0 0 -0.0))";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testListAtoms() throws IOException {
        String programName = programsDirectory + "list_atoms.txt";
        String expected = "'('(A b C d haha))";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testListFunctions() throws IOException {
        String programName = programsDirectory + "list_functions.txt";
        String expected = "'('(plus minus times divide))";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testAllGrammar() throws IOException {
        String programName = programsDirectory + "allGrammar.txt";
        String expected = "'(Quote={SetQ{atom=dsfdhsa, element=FuncNode{atom=tyui, list=LambdaNode{list=ProgNode{list=CondNode{condition=true, trueAction=WhileNode{condition=true, action=fds}, falseAction=false}, element=null}, element=uiouio1223}, element=456.3}}} ReturnNode{element=42} BreakNode '(cons f '(12 432)) '(tail '(A B C)) '(equal 43 '(plus 2 3)) '(nonequal 32 '(times 123 2.5)) '(less '(minus 4 5) 432) '(lesseq 42 '(divide 22 3.3)) '(greater '(head '(a b c)) 1) '(isint 1) '(isreal 2) '(isbool true) '(isnull abcc) '(isatom x) '(islist '(a a a)) '(and true false) '(or true '(false true)) '(xor false true) '(not true) '(eval '(greatereq 22 1)))";
        runCompilerEquals(programName, expected);
    }
}
