package syntax_analysis.node;

import lexical_analysis.tokens.literal.BooleanLiteralToken;
import lexical_analysis.tokens.literal.IntegerNumberLiteralToken;
import lexical_analysis.tokens.literal.LiteralToken;
import lexical_analysis.tokens.literal.RealNumberLiteralToken;

public class LiteralNode extends Node {
    public Integer integerValue;
    public Double realValue;
    public Boolean booleanValue;

    public LiteralNode(LiteralToken token) {
        String content = token.getContent();
        if (token instanceof IntegerNumberLiteralToken) {
            this.integerValue = Integer.valueOf(content);
        } else if (token instanceof RealNumberLiteralToken) {
            this.realValue = Double.valueOf(content);
        } else if (token instanceof BooleanLiteralToken) {
            this.booleanValue = Boolean.valueOf(content);
        }
    }

    @Override
    public Object get() {
        if (integerValue != null) {
            return integerValue;
        }
        if (realValue != null) {
            return realValue;
        }
        if (booleanValue != null) {
            return booleanValue;
        }
        return null;
    }

    @Override
    public String toString() {
        if (integerValue != null) {
            return "LiteralNode{" +
                    "integer=" + integerValue +
                    '}';
        }
        if (realValue != null) {
            return "LiteralNode{" +
                    "real=" + realValue +
                    '}';
        }
        if (booleanValue != null) {
            return "LiteralNode{" +
                    "boolean=" + booleanValue +
                    '}';
        }
        return "LiteralNode{null}";
    }
}