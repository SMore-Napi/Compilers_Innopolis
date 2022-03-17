package syntax_analysis.node.special_form;

import interpreter.NestedFormBreak;
import syntax_analysis.node.ElementInterface;

public class BreakNode implements ElementInterface {
    @Override
    public ElementInterface evaluate() {
        NestedFormBreak.getInstance().leaveLocalScope();
        return this;
    }

    @Override
    public String toString() {
        return "BreakNode";
    }
}
