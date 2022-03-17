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
    void testQuickSort() throws IOException {
        String programName = programsDirectory  + "quicksort.txt";
        String expected = "";
        runCompilerEquals(programName, expected);
    }

}
