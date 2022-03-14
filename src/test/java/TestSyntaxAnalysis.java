import org.junit.jupiter.api.Test;
import syntax_analysis.node.AST;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSyntaxAnalysis {
    String programsDirectory = "Tests/SyntaxAnalysis/";

    @Test
    void testListLiterals() throws IOException {
        String programName = programsDirectory + "list_literals.txt";
        String expected = "List[List[int=1, int=2, int=3, bool=true, null, bool=false, real=1.3, int=0, real=-3.2, int=-8, real=0.0, int=0, real=-0.0]]";
        Compiler compiler = new Compiler(programName);
        AST ast = compiler.syntaxAnalysis();
        String actual = ast.toString();
        assertEquals(expected, actual);
    }

    @Test
    void testListAtoms() throws IOException {
        String programName = programsDirectory + "list_atoms.txt";
        String expected = "List[List[AtomNode{name='A', value={null}}, AtomNode{name='b', value={null}}, AtomNode{name='C', value={null}}, AtomNode{name='d', value={null}}, AtomNode{name='haha', value={null}}]]";
        Compiler compiler = new Compiler(programName);
        AST ast = compiler.syntaxAnalysis();
        String actual = ast.toString();
        assertEquals(expected, actual);
    }

    @Test
    void testListFunctions() throws IOException {
        String programName = programsDirectory + "list_functions.txt";
        String expected = "List[List[AtomNode{name='plus', value={null}}, AtomNode{name='minus', value={null}}, AtomNode{name='times', value={null}}, AtomNode{name='divide', value={null}}]]";
        Compiler compiler = new Compiler(programName);
        AST ast = compiler.syntaxAnalysis();
        String actual = ast.toString();
        assertEquals(expected, actual);
    }

    @Test
    void testAllGrammar() throws IOException {
        String programName = programsDirectory + "allGrammar.txt";
        String expected = "List[Quote={SetQ{atom=AtomNode{name='dsfdhsa', value={null}}, element=FuncNode{atom=AtomNode{name='tyui', value={null}}, list=LambdaNode{list=ProgNode{list=CondNode{condition=bool=true, trueAction=WhileNode{condition=bool=true, action=AtomNode{name='fds', value={null}}}, falseAction=bool=false}, element=null}, element=AtomNode{name='uiouio1223', value={null}}}, element=real=456.3}}}, ReturnNode{element=int=42}, BreakNode, List[AtomNode{name='cons', value={null}}, AtomNode{name='f', value={null}}, List[int=12, int=432]], List[AtomNode{name='tail', value={null}}, List[AtomNode{name='A', value={null}}, AtomNode{name='B', value={null}}, AtomNode{name='C', value={null}}]], List[AtomNode{name='equal', value={null}}, int=43, List[AtomNode{name='plus', value={null}}, int=2, int=3]], List[AtomNode{name='nonequal', value={null}}, int=32, List[AtomNode{name='times', value={null}}, int=123, real=2.5]], List[AtomNode{name='less', value={null}}, List[AtomNode{name='minus', value={null}}, int=4, int=5], int=432], List[AtomNode{name='lesseq', value={null}}, int=42, List[AtomNode{name='divide', value={null}}, int=22, real=3.3]], List[AtomNode{name='greater', value={null}}, List[AtomNode{name='head', value={null}}, List[AtomNode{name='a', value={null}}, AtomNode{name='b', value={null}}, AtomNode{name='c', value={null}}]], int=1], List[AtomNode{name='isint', value={null}}, int=1], List[AtomNode{name='isreal', value={null}}, int=2], List[AtomNode{name='isbool', value={null}}, bool=true], List[AtomNode{name='isnull', value={null}}, AtomNode{name='abcc', value={null}}], List[AtomNode{name='isatom', value={null}}, AtomNode{name='x', value={null}}], List[AtomNode{name='islist', value={null}}, List[AtomNode{name='a', value={null}}, AtomNode{name='a', value={null}}, AtomNode{name='a', value={null}}]], List[AtomNode{name='and', value={null}}, bool=true, bool=false], List[AtomNode{name='or', value={null}}, bool=true, List[bool=false, bool=true]], List[AtomNode{name='xor', value={null}}, bool=false, bool=true], List[AtomNode{name='not', value={null}}, bool=true], List[AtomNode{name='eval', value={null}}, List[AtomNode{name='greatereq', value={null}}, int=22, int=1]]]";
        Compiler compiler = new Compiler(programName);
        AST ast = compiler.syntaxAnalysis();
        String actual = ast.toString();
        assertEquals(expected, actual);
    }
}
