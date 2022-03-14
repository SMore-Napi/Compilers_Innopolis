import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        final String DEFAULT_PATH = "Tests/program.txt";
        final boolean LOG_DEFAULT = true;
        final String LOG_PARAMETER_NAME = "log";
        final String programSourcePath = args.length >= 1 ? args[0] : DEFAULT_PATH;
        boolean logging = args.length >= 2 ? LOG_PARAMETER_NAME.equals(args[1]) : LOG_DEFAULT;
        run(programSourcePath, logging);
    }

    public static void run(final String programSourcePath, final boolean logging) {
        if (logging) {
            LogMode logMode = new LogMode(programSourcePath);
            logMode.logging();
        } else {
            try {
                Compiler compiler = new Compiler(programSourcePath);
                System.out.println(compiler.interpret());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
