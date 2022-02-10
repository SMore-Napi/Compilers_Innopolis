package syntax_analysis.node;

public
class CondNode extends Node {
    Node condition;
    Node trueResult;
    Node falseResult;

    @Override
    public Object get() {
        return (Boolean) condition.get()
                ? trueResult
                : falseResult;
    }
}