import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class TestInterpreter {
    private final String programsDirectory = "Tests/Interpreter/";
    private final String quoteDirectory = "Quote/";
    private final String setQDirectory = "SetQ/";
    private final String funcDirectory = "Func/";
    private final String lambdaDirectory = "Lambda/";
    private final String progDirectory = "Prog/";
    private final String condDirectory = "Cond/";
    private final String whileDirectory = "While/";
    private final String breakReturnDirectory = "BreakReturn/";
    private final String arithmeticFunctionsDirectory = "ArithmeticFunctions/";
    private final String operationsOnListDirectory = "OperationsOnList/";
    private final String comparisonsDirectory = "Comparisons/";
    private final String predicatesDirectory = "Predicates/";
    private final String logicalOperatorsDirectory = "LogicalOperators/";
    private final String evalDirectory = "Eval/";

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
        String expected = "'(1 2 3 '(plus 4 5) 6)\n" +
                "3\n" +
                "x\n" +
                "'(plus 1 2)\n" +
                "y\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testShortQuote() throws IOException {
        String programName = programsDirectory + quoteDirectory + "short_quote.txt";
        String expected = "'(1 2 3 '(plus 4 5) 6)\n" +
                "3\n" +
                "x\n" +
                "'(plus 1 2)\n" +
                "y\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testSetQ() throws IOException {
        String programName = programsDirectory + setQDirectory + "setq.txt";
        String expected = "5\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testSetQSeveralAtoms() throws IOException {
        String programName = programsDirectory + setQDirectory + "setq_several_atoms.txt";
        String expected = "'(5 6)\n" +
                "5\n" +
                "6\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testSetQReassignment() throws IOException {
        String programName = programsDirectory + setQDirectory + "setq_reassignment.txt";
        String expected = "5\n" +
                "7\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testSetQAtomValue() throws IOException {
        String programName = programsDirectory + setQDirectory + "setq_atom_value.txt";
        String expected = "'(5 5)\n";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testSetQReassignmentAtomValue() throws IOException {
        String programName = programsDirectory + setQDirectory + "setq_reassignment_atom_value.txt";
        String expected = "'(5 6 6)\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testSetQOperation() throws IOException {
        String programName = programsDirectory + setQDirectory + "setq_operation.txt";
        String expected = "3\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testSetQNull() throws IOException {
        String programName = programsDirectory + setQDirectory + "setq_null.txt";
        String expected = "null\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testSetQList1() throws IOException {
        String programName = programsDirectory + setQDirectory + "setq_list1.txt";
        String expected = "'(1 2 3)\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testSetQList2() throws IOException {
        String programName = programsDirectory + setQDirectory + "setq_list2.txt";
        String expected = "'(plus 4 5)\n";
        Compiler compiler = new Compiler(programName);
        String actual = compiler.interpret();
        assertEquals(expected, actual);
    }

    @Test
    void testSetQAtomsList() throws IOException {
        String programName = programsDirectory + setQDirectory + "setq_atoms_list.txt";
        String expected = "'(plus minus times divide)\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testSetQPredefinedFunctionException() throws IOException {
        String programName = programsDirectory + setQDirectory + "setq_predefined_function.txt";
        String expectedMessage = "Can't reassign keyword: not";
        runCompilerException(programName, expectedMessage);
    }

    @Test
    void testFunc1() throws IOException {
        String programName = programsDirectory + funcDirectory + "func1.txt";
        String expected = "8\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testFunc2() throws IOException {
        String programName = programsDirectory + funcDirectory + "func2.txt";
        String expected = "8\n" +
                "x\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testFunc3() throws IOException {
        String programName = programsDirectory + funcDirectory + "func3.txt";
        String expected = "8\n" +
                "arg\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testFunc4() throws IOException {
        String programName = programsDirectory + funcDirectory + "func4.txt";
        String expected = "555\n" +
                "arg\n" +
                "555\n" +
                "arg\n" +
                "8\n" +
                "arg\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testFunc5() throws IOException {
        String programName = programsDirectory + funcDirectory + "func5.txt";
        String expected = "'(9 8 16 125)\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testFunc6() throws IOException {
        String programName = programsDirectory + funcDirectory + "func6.txt";
        String expected = "1\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testFunc7() throws IOException {
        String programName = programsDirectory + funcDirectory + "func7.txt";
        String expected = "";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testFunc8() throws IOException {
        String programName = programsDirectory + funcDirectory + "func8.txt";
        String expected = "1\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testFunc9() throws IOException {
        String programName = programsDirectory + funcDirectory + "func9.txt";
        String expected = "'(1)\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testFunc10() throws IOException {
        String programName = programsDirectory + funcDirectory + "func10.txt";
        String expected = "'('(1))\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testFunc11() throws IOException {
        String programName = programsDirectory + funcDirectory + "func11.txt";
        String expectedMessage = "There is a defined function: a";
        runCompilerException(programName, expectedMessage);
    }

    @Test
    void testFunc12() throws IOException {
        String programName = programsDirectory + funcDirectory + "func12.txt";
        String expectedMessage = "The function is already defined: a";
        runCompilerException(programName, expectedMessage);
    }

    @Test
    void testFunc13() throws IOException {
        String programName = programsDirectory + funcDirectory + "func13.txt";
        String expectedMessage = "Can't name a function with already defined identifier name: a";
        runCompilerException(programName, expectedMessage);
    }

    @Test
    void testLambda1() throws IOException {
        String programName = programsDirectory + lambdaDirectory + "lambda1.txt";
        String expected = "";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testLambda2() throws IOException {
        String programName = programsDirectory + lambdaDirectory + "lambda2.txt";
        String expected = "4\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testLambda3() throws IOException {
        String programName = programsDirectory + lambdaDirectory + "lambda3.txt";
        String expected = "4\n" +
                "6\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testLambda4() throws IOException {
        String programName = programsDirectory + lambdaDirectory + "lambda4.txt";
        String expected = "3\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testLambda5() throws IOException {
        String programName = programsDirectory + lambdaDirectory + "lambda5.txt";
        String expected = "'(_Function 1 1 2)\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testLambda6() throws IOException {
        String programName = programsDirectory + lambdaDirectory + "lambda6.txt";
        String expected = "3\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testLambda7() throws IOException {
        String programName = programsDirectory + lambdaDirectory + "lambda7.txt";
        String expected = "-1\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testLambda8() throws IOException {
        String programName = programsDirectory + lambdaDirectory + "lambda8.txt";
        String expected = "3\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testLambda9() throws IOException {
        String programName = programsDirectory + lambdaDirectory + "lambda9.txt";
        String expected = "-1\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testProg1() throws IOException {
        String programName = programsDirectory + progDirectory + "prog1.txt";
        String expected = "";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testProg2() throws IOException {
        String programName = programsDirectory + progDirectory + "prog2.txt";
        String expected = "'(55 55)\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testProg3() throws IOException {
        String programName = programsDirectory + progDirectory + "prog3.txt";
        String expected = "'(5 6)\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testCond1() throws IOException {
        String programName = programsDirectory + condDirectory + "cond1.txt";
        String expected = "24\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testCond2() throws IOException {
        String programName = programsDirectory + condDirectory + "cond2.txt";
        String expected = "5\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testCond3() throws IOException {
        String programName = programsDirectory + condDirectory + "cond3.txt";
        String expected = "8\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testCond4() throws IOException {
        String programName = programsDirectory + condDirectory + "cond4.txt";
        String expected = "5\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testCond5() throws IOException {
        String programName = programsDirectory + condDirectory + "cond5.txt";
        String expected = "null\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testWhile1() throws IOException {
        String programName = programsDirectory + whileDirectory + "while1.txt";
        String expected = "512\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testWhile2() throws IOException {
        String programName = programsDirectory + whileDirectory + "while2.txt";
        String expected = "'('(0 1) '(0 0))\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testBreak1() throws IOException {
        String programName = programsDirectory + breakReturnDirectory + "break1.txt";
        String expected = "8\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testBreak2() throws IOException {
        String programName = programsDirectory + breakReturnDirectory + "break2.txt";
        String expected = "1\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testReturn1() throws IOException {
        String programName = programsDirectory + breakReturnDirectory + "return1.txt";
        String expected = "1\n" +
                "8\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testPlusIntegers() throws IOException {
        String programName = programsDirectory + arithmeticFunctionsDirectory + "plus_integers.txt";
        String expected = "3\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testPlusReals() throws IOException {
        String programName = programsDirectory + arithmeticFunctionsDirectory + "plus_reals.txt";
        String expected = "4.199999999999999\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testPlusIntegerReals() throws IOException {
        String programName = programsDirectory + arithmeticFunctionsDirectory + "plus_integer_real.txt";
        String expected = "7.4\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testMinusIntegers() throws IOException {
        String programName = programsDirectory + arithmeticFunctionsDirectory + "minus_integers.txt";
        String expected = "4\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testMinusReals() throws IOException {
        String programName = programsDirectory + arithmeticFunctionsDirectory + "minus_reals.txt";
        String expected = "4.5\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testMinusIntegerReals() throws IOException {
        String programName = programsDirectory + arithmeticFunctionsDirectory + "minus_integer_real.txt";
        String expected = "3.9\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testTimesIntegers() throws IOException {
        String programName = programsDirectory + arithmeticFunctionsDirectory + "times_integers.txt";
        String expected = "18\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testTimesReals() throws IOException {
        String programName = programsDirectory + arithmeticFunctionsDirectory + "times_reals.txt";
        String expected = "22.11\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testTimesIntegerReals() throws IOException {
        String programName = programsDirectory + arithmeticFunctionsDirectory + "times_integer_real.txt";
        String expected = "20.4\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testDivideIntegers() throws IOException {
        String programName = programsDirectory + arithmeticFunctionsDirectory + "divide_integers.txt";
        String expected = "2.3333333333333335\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testDivideReals() throws IOException {
        String programName = programsDirectory + arithmeticFunctionsDirectory + "divide_reals.txt";
        String expected = "2.1176470588235294\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testDivideIntegerReal() throws IOException {
        String programName = programsDirectory + arithmeticFunctionsDirectory + "divide_integer_real.txt";
        String expected = "2.1875\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testHeadLiterals() throws IOException {
        String programName = programsDirectory + operationsOnListDirectory + "head_literals.txt";
        String expected = "1\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testHeadAtoms() throws IOException {
        String programName = programsDirectory + operationsOnListDirectory + "head_atoms.txt";
        String expected = "55\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testHeadEmptyList() throws IOException {
        String programName = programsDirectory + operationsOnListDirectory + "head_empty_list.txt";
        String expectedMessage = "Can't call 'head' from empty list";
        runCompilerException(programName, expectedMessage);
    }

    @Test
    void testTailLiterals() throws IOException {
        String programName = programsDirectory + operationsOnListDirectory + "tail_literals.txt";
        String expected = "'(2.4 true false null)\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testTailAtoms() throws IOException {
        String programName = programsDirectory + operationsOnListDirectory + "tail_atoms.txt";
        String expected = "'(55 1 66)\n" +
                "'(1 1 1)\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testTailEmptyList() throws IOException {
        String programName = programsDirectory + operationsOnListDirectory + "tail_empty_list.txt";
        String expectedMessage = "Can't call 'tail' from empty list";
        runCompilerException(programName, expectedMessage);
    }

    @Test
    void testConsLiterals() throws IOException {
        String programName = programsDirectory + operationsOnListDirectory + "cons_literals.txt";
        String expected = "'(1 2 3)\n" +
                "'(1)\n" +
                "'(1 4 6 7)\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testConsAtoms() throws IOException {
        String programName = programsDirectory + operationsOnListDirectory + "cons_atoms.txt";
        String expected = "'(true 2 null false -7.0)\n" +
                "'(true 5 2 null)\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testConsEmptyListLiteral() throws IOException {
        String programName = programsDirectory + operationsOnListDirectory + "cons_empty_list_literal.txt";
        String expected = "'(true)\n" +
                "'(1)\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testConsEmptyListAtom() throws IOException {
        String programName = programsDirectory + operationsOnListDirectory + "cons_empty_list_atom.txt";
        String expected = "'(false)\n" +
                "'(2)\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testConsNotListLiterals() throws IOException {
        String programName = programsDirectory + operationsOnListDirectory + "cons_not_list_literals.txt";
        String expectedMessage = "The second evaluated argument should be a list";
        runCompilerException(programName, expectedMessage);
    }

    @Test
    void testConsNotListAtoms() throws IOException {
        String programName = programsDirectory + operationsOnListDirectory + "cons_not_list_atoms.txt";
        String expectedMessage = "The second evaluated argument should be a list";
        runCompilerException(programName, expectedMessage);
    }

    @Test
    void testConsHeadNotList() throws IOException {
        String programName = programsDirectory + operationsOnListDirectory + "cons_head_not_list.txt";
        String expectedMessage = "The second evaluated argument should be a list";
        runCompilerException(programName, expectedMessage);
    }

    @Test
    void testConsTail() throws IOException {
        String programName = programsDirectory + operationsOnListDirectory + "cons_tail.txt";
        String expected = "'(1 3 4)\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testOperationsOnList() throws IOException {
        String programName = programsDirectory + operationsOnListDirectory + "operations_on_list.txt";
        String expected = "'(2 1 5)\n" +
                "'(2)\n" +
                "'(22 33 44)\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testComparisons() throws IOException {
        String programName = programsDirectory + comparisonsDirectory + "comparisons.txt";
        String expected = "false\nfalse\nfalse\ntrue\ntrue\nfalse\ntrue\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testComparisonException() throws IOException {
        String programName = programsDirectory + comparisonsDirectory + "comparison_exception.txt";
        String expectedMessage = "Wrong operands in EQUAL operation";
        runCompilerException(programName, expectedMessage);
    }

    @Test
    void testIsInt1() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isint1.txt";
        String expected = "true\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsInt2() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isint2.txt";
        String expected = "false\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsInt3() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isint3.txt";
        String expected = "true\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsInt4() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isint4.txt";
        String expected = "true\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsInt5() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isint5.txt";
        String expected = "false\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsInt6() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isint6.txt";
        String expected = "false\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsInt7() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isint7.txt";
        String expected = "true\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsInt8() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isint8.txt";
        String expected = "false\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsInt9() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isint9.txt";
        String expected = "false\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsIntException() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isint_exception.txt";
        String expectedMessage = "Predicate function must have one parameter!";
        runCompilerException(programName, expectedMessage);
    }

    @Test
    void testIsReal1() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isreal1.txt";
        String expected = "true\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsReal2() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isreal2.txt";
        String expected = "true\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsReal3() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isreal3.txt";
        String expected = "true\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsReal4() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isreal4.txt";
        String expected = "false\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsReal5() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isreal5.txt";
        String expected = "true\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsReal6() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isreal6.txt";
        String expected = "false\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsReal7() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isreal7.txt";
        String expected = "false\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsReal8() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isreal8.txt";
        String expected = "true\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsReal9() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isreal9.txt";
        String expected = "false\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsReal10() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isreal10.txt";
        String expected = "false\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsRealException() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isreal_exception.txt";
        String expectedMessage = "Predicate function must have one parameter!";
        runCompilerException(programName, expectedMessage);
    }

    @Test
    void testIsBool1() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isbool1.txt";
        String expected = "true\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsBool2() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isbool2.txt";
        String expected = "true\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsBool3() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isbool3.txt";
        String expected = "false\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsBool4() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isbool4.txt";
        String expected = "false\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsBool5() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isbool5.txt";
        String expected = "false\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsBool6() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isbool6.txt";
        String expected = "true\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsBool7() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isbool7.txt";
        String expected = "true\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsBool8() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isbool8.txt";
        String expected = "false\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsBool9() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isbool9.txt";
        String expected = "false\n";
        runCompilerEquals(programName, expected);
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
        String expected = "true\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsNull2() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isnull2.txt";
        String expected = "false\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsNull3() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isnull3.txt";
        String expected = "false\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsNull4() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isnull4.txt";
        String expected = "false\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsNull5() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isnull5.txt";
        String expected = "false\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsNull6() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isnull6.txt";
        String expected = "false\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsNull7() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isnull7.txt";
        String expected = "true\n";
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
        String expected = "true\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsAtom2() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isatom2.txt";
        String expected = "true\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsAtom3() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isatom3.txt";
        String expected = "'(22 22 22)\n" +
                "true\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsAtom4() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isatom4.txt";
        String expected = "true\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsAtom5() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isatom5.txt";
        String expected = "false\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsAtom6() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isatom6.txt";
        String expected = "false\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsAtom7() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isatom7.txt";
        String expected = "false\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsAtom8() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isatom8.txt";
        String expected = "false\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsAtom9() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isatom9.txt";
        String expected = "false\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsAtom10() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isatom10.txt";
        String expected = "false\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsAtom11() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "isatom11.txt";
        String expected = "true\n";
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
        String expected = "true\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsList2() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "islist2.txt";
        String expected = "true\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsList3() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "islist3.txt";
        String expected = "true\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsList4() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "islist4.txt";
        String expected = "true\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsList5() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "islist5.txt";
        String expected = "true\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsList6() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "islist6.txt";
        String expected = "false\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsList7() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "islist7.txt";
        String expected = "false\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsList8() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "islist8.txt";
        String expected = "false\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsList9() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "islist9.txt";
        String expected = "false\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsList10() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "islist10.txt";
        String expected = "false\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsList11() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "islist11.txt";
        String expected = "true\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsList12() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "islist12.txt";
        String expected = "true\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsList13() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "islist13.txt";
        String expected = "false\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testIsListException() throws IOException {
        String programName = programsDirectory + predicatesDirectory + "islist_exception.txt";
        String expectedMessage = "Predicate function must have one parameter!";
        runCompilerException(programName, expectedMessage);
    }

    @Test
    void testAnd1() throws IOException {
        String programName = programsDirectory + logicalOperatorsDirectory + "and1.txt";
        String expected = "true\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testAnd2() throws IOException {
        String programName = programsDirectory + logicalOperatorsDirectory + "and2.txt";
        String expected = "false\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testAnd3() throws IOException {
        String programName = programsDirectory + logicalOperatorsDirectory + "and3.txt";
        String expected = "false\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testAnd4() throws IOException {
        String programName = programsDirectory + logicalOperatorsDirectory + "and4.txt";
        String expected = "false\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testAnd5() throws IOException {
        String programName = programsDirectory + logicalOperatorsDirectory + "and5.txt";
        String expected = "true\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testAndException1() throws IOException {
        String programName = programsDirectory + logicalOperatorsDirectory + "and_exception1.txt";
        String expectedMessage = "Logical binary operator must accept two boolean arguments";
        runCompilerException(programName, expectedMessage);
    }

    @Test
    void testAndException2() throws IOException {
        String programName = programsDirectory + logicalOperatorsDirectory + "and_exception2.txt";
        String expectedMessage = "Logical Operator must have one or two parameters!";
        runCompilerException(programName, expectedMessage);
    }

    @Test
    void testAndException3() throws IOException {
        String programName = programsDirectory + logicalOperatorsDirectory + "and_exception3.txt";
        String expectedMessage = "Literal value must be boolean. Provided: '(true true)";
        runCompilerException(programName, expectedMessage);
    }

    @Test
    void testAndException4() throws IOException {
        String programName = programsDirectory + logicalOperatorsDirectory + "and_exception4.txt";
        String expectedMessage = "Literal value must be boolean. Provided: 1";
        runCompilerException(programName, expectedMessage);
    }

    @Test
    void testAndException5() throws IOException {
        String programName = programsDirectory + logicalOperatorsDirectory + "and_exception5.txt";
        String expectedMessage = "Literal value must be boolean. Provided: null";
        runCompilerException(programName, expectedMessage);
    }

    @Test
    void testOr1() throws IOException {
        String programName = programsDirectory + logicalOperatorsDirectory + "or1.txt";
        String expected = "true\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testOr2() throws IOException {
        String programName = programsDirectory + logicalOperatorsDirectory + "or2.txt";
        String expected = "true\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testOr3() throws IOException {
        String programName = programsDirectory + logicalOperatorsDirectory + "or3.txt";
        String expected = "true\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testOr4() throws IOException {
        String programName = programsDirectory + logicalOperatorsDirectory + "or4.txt";
        String expected = "false\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testOr5() throws IOException {
        String programName = programsDirectory + logicalOperatorsDirectory + "or5.txt";
        String expected = "true\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testOrException1() throws IOException {
        String programName = programsDirectory + logicalOperatorsDirectory + "or_exception1.txt";
        String expectedMessage = "Logical binary operator must accept two boolean arguments";
        runCompilerException(programName, expectedMessage);
    }

    @Test
    void testOrException2() throws IOException {
        String programName = programsDirectory + logicalOperatorsDirectory + "or_exception2.txt";
        String expectedMessage = "Logical Operator must have one or two parameters!";
        runCompilerException(programName, expectedMessage);
    }

    @Test
    void testOrException3() throws IOException {
        String programName = programsDirectory + logicalOperatorsDirectory + "or_exception3.txt";
        String expectedMessage = "Literal value must be boolean. Provided: '(true true)";
        runCompilerException(programName, expectedMessage);
    }

    @Test
    void testOrException4() throws IOException {
        String programName = programsDirectory + logicalOperatorsDirectory + "or_exception4.txt";
        String expectedMessage = "Literal value must be boolean. Provided: 1";
        runCompilerException(programName, expectedMessage);
    }

    @Test
    void testOrException5() throws IOException {
        String programName = programsDirectory + logicalOperatorsDirectory + "or_exception5.txt";
        String expectedMessage = "Literal value must be boolean. Provided: null";
        runCompilerException(programName, expectedMessage);
    }

    @Test
    void testXor1() throws IOException {
        String programName = programsDirectory + logicalOperatorsDirectory + "xor1.txt";
        String expected = "false\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testXor2() throws IOException {
        String programName = programsDirectory + logicalOperatorsDirectory + "xor2.txt";
        String expected = "true\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testXor3() throws IOException {
        String programName = programsDirectory + logicalOperatorsDirectory + "xor3.txt";
        String expected = "true\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testXor4() throws IOException {
        String programName = programsDirectory + logicalOperatorsDirectory + "xor4.txt";
        String expected = "false\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testXor5() throws IOException {
        String programName = programsDirectory + logicalOperatorsDirectory + "xor5.txt";
        String expected = "false\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testXorException1() throws IOException {
        String programName = programsDirectory + logicalOperatorsDirectory + "xor_exception1.txt";
        String expectedMessage = "Logical binary operator must accept two boolean arguments";
        runCompilerException(programName, expectedMessage);
    }

    @Test
    void testXorException2() throws IOException {
        String programName = programsDirectory + logicalOperatorsDirectory + "xor_exception2.txt";
        String expectedMessage = "Logical Operator must have one or two parameters!";
        runCompilerException(programName, expectedMessage);
    }

    @Test
    void testXorException3() throws IOException {
        String programName = programsDirectory + logicalOperatorsDirectory + "xor_exception3.txt";
        String expectedMessage = "Literal value must be boolean. Provided: '(true true)";
        runCompilerException(programName, expectedMessage);
    }

    @Test
    void testXorException4() throws IOException {
        String programName = programsDirectory + logicalOperatorsDirectory + "xor_exception4.txt";
        String expectedMessage = "Literal value must be boolean. Provided: 1";
        runCompilerException(programName, expectedMessage);
    }

    @Test
    void testXorException5() throws IOException {
        String programName = programsDirectory + logicalOperatorsDirectory + "xor_exception5.txt";
        String expectedMessage = "Literal value must be boolean. Provided: null";
        runCompilerException(programName, expectedMessage);
    }

    @Test
    void testNot1() throws IOException {
        String programName = programsDirectory + logicalOperatorsDirectory + "not1.txt";
        String expected = "false\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testNot2() throws IOException {
        String programName = programsDirectory + logicalOperatorsDirectory + "not2.txt";
        String expected = "true\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testNot3() throws IOException {
        String programName = programsDirectory + logicalOperatorsDirectory + "not3.txt";
        String expected = "false\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testNot4() throws IOException {
        String programName = programsDirectory + logicalOperatorsDirectory + "not4.txt";
        String expected = "true\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testNotException1() throws IOException {
        String programName = programsDirectory + logicalOperatorsDirectory + "not_exception1.txt";
        String expectedMessage = "Logical Operator must have one or two parameters!";
        runCompilerException(programName, expectedMessage);
    }

    @Test
    void testNotException2() throws IOException {
        String programName = programsDirectory + logicalOperatorsDirectory + "not_exception2.txt";
        String expectedMessage = "Logical unary operator must accept single boolean argument";
        runCompilerException(programName, expectedMessage);
    }

    @Test
    void testNotException3() throws IOException {
        String programName = programsDirectory + logicalOperatorsDirectory + "not_exception3.txt";
        String expectedMessage = "Literal value must be boolean. Provided: '(true)";
        runCompilerException(programName, expectedMessage);
    }

    @Test
    void testNotException4() throws IOException {
        String programName = programsDirectory + logicalOperatorsDirectory + "not_exception4.txt";
        String expectedMessage = "Literal value must be boolean. Provided: 1";
        runCompilerException(programName, expectedMessage);
    }

    @Test
    void testNotException5() throws IOException {
        String programName = programsDirectory + logicalOperatorsDirectory + "not_exception5.txt";
        String expectedMessage = "Literal value must be boolean. Provided: null";
        runCompilerException(programName, expectedMessage);
    }

    @Test
    void testEval2() throws IOException {
        String programName = programsDirectory + evalDirectory + "eval2.txt";
        String expected = "1\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testEval3() throws IOException {
        String programName = programsDirectory + evalDirectory + "eval3.txt";
        String expected = "1\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testEval4() throws IOException {
        String programName = programsDirectory + evalDirectory + "eval4.txt";
        String expected = "null\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testEval5() throws IOException {
        String programName = programsDirectory + evalDirectory + "eval5.txt";
        String expected = "3\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testEvalException1() throws IOException {
        String programName = programsDirectory + evalDirectory + "eval_exception1.txt";
        String expectedMessage = "The list can't be treated as a function: '(1 2 3)";
        runCompilerException(programName, expectedMessage);
    }
}
