import exceptions.ComparisonException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class TestInterpreter {
    private final String programsDirectory = "Tests/Interpreter/";
    private final String quoteDirectory = "Quote/";
    private final String setQDirectory = "SetQ/";

    private final String arithmeticFunctionsDirectory = "ArithmeticFunctions/";
    private final String operationsOnListDirectory = "OperationsOnList/";
    private final String comparisonsDirectory = "Comparisons/";
    private final String predicatesDirectory = "Predicates/";

    void runCompilerEquals(String programName, String expected) throws IOException {
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    void runCompilerException(String programName, String expectedMessage) throws IOException {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            Compiler compiler = new Compiler(programName);
            compiler.interpret();
        });
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testQuote() throws IOException {
        String programName = programsDirectory + quoteDirectory + "quote.txt";
        String expected = "List[int=1, int=2, int=3, List[AtomNode{name='plus', value={null}}, int=4, int=5], int=6]\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testShortQuote() throws IOException {
        String programName = programsDirectory + quoteDirectory + "short_quote.txt";
        String expected = "List[int=1, int=2, int=3, List[AtomNode{name='plus', value={null}}, int=4, int=5], int=6]";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testSetQ() throws IOException {
        String programName = programsDirectory + setQDirectory + "setq.txt";
        String expected = "AtomNode{name='x', value={int=5}}";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testSetQSeveralAtoms() throws IOException {
        String programName = programsDirectory + setQDirectory + "setq_several_atoms.txt";
        String expected = "List[AtomNode{name='x', value={int=5}}, AtomNode{name='y', value={int=6}}]";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testSetQReassignment() throws IOException {
        String programName = programsDirectory + setQDirectory + "setq_reassignment.txt";
        String expected = "List[AtomNode{name='x', value={int=5}}, AtomNode{name='x', value={int=7}}]";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testSetQAtomValue() throws IOException {
        String programName = programsDirectory + setQDirectory + "setq_atom_value.txt";
        String expected = "List[AtomNode{name='x', value={int=5}}, AtomNode{name='z', value={int=5}}, List[int=5, int=5]]";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testSetQReassignmentAtomValue() throws IOException {
        String programName = programsDirectory + setQDirectory + "setq_reassignment_atom_value.txt";
        String expected = "List[AtomNode{name='x', value={int=5}}, AtomNode{name='y', value={int=6}}, AtomNode{name='z', value={int=5}}, AtomNode{name='z', value={int=6}}, List[int=5, int=6, int=6]]";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testSetQOperation() throws IOException {
        String programName = programsDirectory + setQDirectory + "setq_operation.txt";
        String expected = "AtomNode{name='y', value={int=3}}";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testSetQNull() throws IOException {
        String programName = programsDirectory + setQDirectory + "setq_null.txt";
        String expected = "AtomNode{name='z', value={null}}";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testSetQList1() throws IOException {
        String programName = programsDirectory + setQDirectory + "setq_list1.txt";
        String expected = "AtomNode{name='t', value={List[int=1, int=2, int=3]}}";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testSetQList2() throws IOException {
        String programName = programsDirectory + setQDirectory + "setq_list2.txt";
        String expected = "AtomNode{name='t', value={List[AtomNode{name='plus', value={null}}, int=4, int=5]}}";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testSetQAtomsList() throws IOException {
        String programName = programsDirectory + setQDirectory + "setq_atoms_list.txt";
        String expected = "AtomNode{name='t', value={List[AtomNode{name='plus', value={null}}, AtomNode{name='minus', value={null}}, AtomNode{name='times', value={null}}, AtomNode{name='divide', value={null}}]}}";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testPlusIntegers() throws IOException {
        String programName = programsDirectory + arithmeticFunctionsDirectory + "plus_integers.txt";
        String expected = "int=3";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testPlusReals() throws IOException {
        String programName = programsDirectory + arithmeticFunctionsDirectory + "plus_reals.txt";
        String expected = "real=4.199999999999999";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testPlusIntegerReals() throws IOException {
        String programName = programsDirectory + arithmeticFunctionsDirectory + "plus_integer_real.txt";
        String expected = "real=7.4";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testMinusIntegers() throws IOException {
        String programName = programsDirectory + arithmeticFunctionsDirectory + "minus_integers.txt";
        String expected = "int=4";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testMinusReals() throws IOException {
        String programName = programsDirectory + arithmeticFunctionsDirectory + "minus_reals.txt";
        String expected = "real=4.5";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testMinusIntegerReals() throws IOException {
        String programName = programsDirectory + arithmeticFunctionsDirectory + "minus_integer_real.txt";
        String expected = "real=3.9";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testTimesIntegers() throws IOException {
        String programName = programsDirectory + arithmeticFunctionsDirectory + "times_integers.txt";
        String expected = "int=18";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testTimesReals() throws IOException {
        String programName = programsDirectory + arithmeticFunctionsDirectory + "times_reals.txt";
        String expected = "real=22.11";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testTimesIntegerReals() throws IOException {
        String programName = programsDirectory + arithmeticFunctionsDirectory + "times_integer_real.txt";
        String expected = "real=20.4";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testDivideIntegers() throws IOException {
        String programName = programsDirectory + arithmeticFunctionsDirectory + "divide_integers.txt";
        String expected = "real=2.3333333333333335";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testDivideReals() throws IOException {
        String programName = programsDirectory + arithmeticFunctionsDirectory + "divide_reals.txt";
        String expected = "real=2.1176470588235294";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testDivideIntegerReal() throws IOException {
        String programName = programsDirectory + arithmeticFunctionsDirectory + "divide_integer_real.txt";
        String expected = "real=2.1875";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testHeadLiterals() throws IOException {
        String programName = programsDirectory + operationsOnListDirectory + "head_literals.txt";
        String expected = "int=1";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testHeadAtoms() throws IOException {
        String programName = programsDirectory + operationsOnListDirectory + "head_atoms.txt";
        String expected = "List[AtomNode{name='a', value={int=55}}, int=55]";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testHeadEmptyList() throws IOException {
        String programName = programsDirectory + operationsOnListDirectory + "head_empty_list.txt";
        Exception exception = assertThrows(RuntimeException.class, () -> {
            Compiler compiler = new Compiler(programName);
            compiler.interpret();
        });
        String expectedMessage = "Can't call 'head' from empty list";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testTailLiterals() throws IOException {
        String programName = programsDirectory + operationsOnListDirectory + "tail_literals.txt";
        String expected = "List[real=2.4, bool=true, bool=false, null]";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testTailAtoms() throws IOException {
        String programName = programsDirectory + operationsOnListDirectory + "tail_atoms.txt";
        String expected = "List[AtomNode{name='b', value={int=55}}, AtomNode{name='de', value={int=66}}, List[int=55, null, int=66]]";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testTailEmptyList() {
        String programName = programsDirectory + operationsOnListDirectory + "tail_empty_list.txt";
        Exception exception = assertThrows(RuntimeException.class, () -> {
            Compiler compiler = new Compiler(programName);
            compiler.interpret();
        });
        String expectedMessage = "Can't call 'tail' from empty list";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testConsLiterals() throws IOException {
        String programName = programsDirectory + operationsOnListDirectory + "cons_literals.txt";
        String expected = "List[int=1, int=2, int=3]";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testConsAtoms() throws IOException {
        String programName = programsDirectory + operationsOnListDirectory + "cons_atoms.txt";
        String expected = "List[AtomNode{name='a', value={bool=true}}, AtomNode{name='b', value={int=2}}, AtomNode{name='c', value={null}}, List[bool=true, int=2, null, bool=false, real=-7.0]]";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testConsEmptyListLiteral() throws IOException {
        String programName = programsDirectory + operationsOnListDirectory + "cons_empty_list_literal.txt";
        String expected = "List[bool=true]";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testConsEmptyListAtom() throws IOException {
        String programName = programsDirectory + operationsOnListDirectory + "cons_empty_list_atom.txt";
        String expected = "List[AtomNode{name='a', value={bool=false}}, List[bool=false]]";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testConsNotListLiterals() throws IOException {
        String programName = programsDirectory + operationsOnListDirectory + "cons_not_list_literals.txt";
        Exception exception = assertThrows(RuntimeException.class, () -> {
            Compiler compiler = new Compiler(programName);
            compiler.interpret();
        });
        String expectedMessage = "The second evaluated argument should be a list";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testConsNotListAtoms() throws IOException {
        String programName = programsDirectory + operationsOnListDirectory + "cons_not_list_atoms.txt";
        Exception exception = assertThrows(RuntimeException.class, () -> {
            Compiler compiler = new Compiler(programName);
            compiler.interpret();
        });
        String expectedMessage = "The second evaluated argument should be a list";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testConsHeadNotList() throws IOException {
        String programName = programsDirectory + operationsOnListDirectory + "cons_head_not_list.txt";
        Exception exception = assertThrows(RuntimeException.class, () -> {
            Compiler compiler = new Compiler(programName);
            compiler.interpret();
        });
        String expectedMessage = "The second evaluated argument should be a list";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testConsTail() throws IOException {
        String programName = programsDirectory + operationsOnListDirectory + "cons_tail.txt";
        String expected = "List[int=1, int=3, int=4]";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testOperationsOnList() throws IOException {
        String programName = programsDirectory + operationsOnListDirectory + "operations_on_list.txt";
        String expected = "List[List[int=2, int=1, int=5], List[int=2], List[null, null, null]]";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testComparisons() throws IOException {
        String programName = programsDirectory + comparisonsDirectory + "comparisons.txt";
        String expected = "List[bool=false, bool=false, bool=false, bool=true, bool=true, bool=false, bool=true]";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testComparisonException() {
        String programName = programsDirectory + comparisonsDirectory + "comparison_exception.txt";
        Exception exception = assertThrows(ComparisonException.class, () -> {
            Compiler compiler = new Compiler(programName);
            compiler.interpret();
        });
        String expectedMessage = "Wrong operands in EQUAL operation";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testIsInt1() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isint1.txt";
        String expected = "bool=true";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testIsInt2() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isint2.txt";
        String expected = "bool=false";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testIsInt3() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isint3.txt";
        String expected = "bool=true";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testIsInt4() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isint4.txt";
        String expected = "List[AtomNode{name='a', value={int=6}}, bool=true]";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testIsInt5() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isint5.txt";
        String expected = "bool=false";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testIsInt6() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isint6.txt";
        String expected = "bool=false";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testIsInt7() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isint7.txt";
        String expected = "bool=true";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testIsInt8() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isint8.txt";
        String expected = "bool=false\n";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testIsInt9() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isint9.txt";
        String expected = "bool=false\n";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testIsIntException() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isint_exception.txt";
        Exception exception = assertThrows(RuntimeException.class, () -> {
            Compiler compiler = new Compiler(programName);
            compiler.interpret();
        });
        String expectedMessage = "Predicate function must have one parameter!";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testIsReal1() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isreal1.txt";
        String expected = "bool=true";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testIsReal2() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isreal2.txt";
        String expected = "bool=true";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testIsReal3() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isreal3.txt";
        String expected = "bool=true";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testIsReal4() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isreal4.txt";
        String expected = "bool=false";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testIsReal5() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isreal5.txt";
        String expected = "bool=true";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testIsReal6() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isreal6.txt";
        String expected = "bool=false";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testIsReal7() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isreal7.txt";
        String expected = "bool=false";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testIsReal8() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isreal8.txt";
        String expected = "List[AtomNode{name='a', value={real=4.3}}, bool=true]";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testIsReal9() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isreal9.txt";
        String expected = "bool=false\n";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testIsReal10() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isreal10.txt";
        String expected = "bool=false\n";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testIsRealException() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isreal_exception.txt";
        Exception exception = assertThrows(RuntimeException.class, () -> {
            Compiler compiler = new Compiler(programName);
            compiler.interpret();
        });
        String expectedMessage = "Predicate function must have one parameter!";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testIsBool1() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isbool1.txt";
        String expected = "bool=true\n";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testIsBool2() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isbool2.txt";
        String expected = "bool=true\n";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testIsBool3() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isbool3.txt";
        String expected = "bool=false\n";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testIsBool4() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isbool4.txt";
        String expected = "bool=false\n";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testIsBool5() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isbool5.txt";
        String expected = "bool=false\n";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testIsBool6() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isbool6.txt";
        String expected = "bool=true\n";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testIsBool7() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isbool7.txt";
        String expected = "AtomNode{name='a', value={bool=false}}\n" +
                "bool=true\n";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testIsBool8() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isbool8.txt";
        String expected = "bool=false\n";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testIsBool9() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isbool9.txt";
        String expected = "bool=false\n";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testIsBoolException() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isbool_exception.txt";
        String expectedMessage = "Predicate function must have one parameter!";
        runCompilerException(programName, expectedMessage);
    }

    @Test
    void testIsNull1() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isnull1.txt";
        String expected = "bool=true\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsNull2() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isnull2.txt";
        String expected = "bool=false\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsNull3() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isnull3.txt";
        String expected = "bool=false\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsNull4() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isnull4.txt";
        String expected = "bool=false\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsNull5() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isnull5.txt";
        String expected = "bool=false\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsNull6() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isnull6.txt";
        String expected = "bool=false\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsNull7() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isnull7.txt";
        String expected = "AtomNode{name='a', value={null}}\n" +
                "bool=true\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsNull8() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isnull8.txt";
        String expected = "List[null, null, null]\n" +
                "bool=true\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsNullException() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isnull_exception.txt";
        String expectedMessage = "Predicate function must have one parameter!";
        runCompilerException(programName, expectedMessage);
    }

    @Test
    void testIsAtom1() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isatom1.txt";
        String expected = "bool=true\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsAtom2() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isatom2.txt";
        String expected = "AtomNode{name='a', value={int=3}}\n" +
                "bool=true\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsAtom3() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isatom3.txt";
        String expected = "List[null, null, null]\n" +
                "bool=true\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsAtom4() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isatom4.txt";
        String expected = "bool=true\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsAtom5() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isatom5.txt";
        String expected = "bool=false\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsAtom6() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isatom6.txt";
        String expected = "bool=false\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsAtom7() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isatom7.txt";
        String expected = "bool=false\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsAtom8() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isatom8.txt";
        String expected = "bool=false\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsAtom9() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isatom9.txt";
        String expected = "bool=false\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsAtom10() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isatom10.txt";
        String expected = "bool=false\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsAtom11() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isatom11.txt";
        String expected = "AtomNode{name='a', value={null}}\n" +
                "bool=true\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsAtomException() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isatom_exception.txt";
        String expectedMessage = "Predicate function must have one parameter!";
        runCompilerException(programName, expectedMessage);
    }

    @Test
    void testIsList1() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "islist1.txt";
        String expected = "bool=true\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsList2() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "islist2.txt";
        String expected = "bool=true\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsList3() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "islist3.txt";
        String expected = "bool=true\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsList4() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "islist4.txt";
        String expected = "AtomNode{name='a', value={List[null, null, null]}}\n" +
                "bool=true\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsList5() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "islist5.txt";
        String expected = "bool=true\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsList6() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "islist6.txt";
        String expected = "bool=false\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsList7() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "islist7.txt";
        String expected = "bool=false\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsList8() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "islist8.txt";
        String expected = "bool=false\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsList9() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "islist9.txt";
        String expected = "bool=false\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsList10() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "islist10.txt";
        String expected = "bool=false\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsList11() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "islist11.txt";
        String expected = "bool=true\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsList12() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "islist12.txt";
        String expected = "bool=true\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsList13() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "islist13.txt";
        String expected = "bool=false\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsListException() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "islist_exception.txt";
        String expectedMessage = "Predicate function must have one parameter!";
        runCompilerException(programName, expectedMessage);
    }
}
