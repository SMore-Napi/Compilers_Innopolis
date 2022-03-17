import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class TestDemo {
    private final String programsDirectory = "Tests/Demo/";

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
    void testFactorial() throws IOException {
        String programName = programsDirectory  + "factorial.txt";
        String expected = "'('(120))\n" +
                "'('(720))\n";
        runCompilerEquals(programName, expected);
    }

    @Test
    void testFibonacci() throws IOException {
        String programName = programsDirectory  + "fibonacci.txt";
        String expected = "'('('(377 233 144 89 55 34 21 13 8 5 3 2 1 1 0)))\n";
        runCompilerEquals(programName, expected);
    }

}
