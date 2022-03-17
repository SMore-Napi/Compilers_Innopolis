package interpreter;

public class NestedFormBreak {
    private static NestedFormBreak INSTANCE;
    private int nestedScope;

    private NestedFormBreak() {
        nestedScope = 0;
    }

    public static NestedFormBreak getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new NestedFormBreak();
        }
        return INSTANCE;
    }

    public void resetNestedForm() {
        INSTANCE = new NestedFormBreak();
    }

    public void introduceLocalScope() {
        this.nestedScope++;
    }

    public void leaveLocalScope() {
        this.nestedScope--;
    }

    public int scopeValue() {
        return nestedScope;
    }
}
