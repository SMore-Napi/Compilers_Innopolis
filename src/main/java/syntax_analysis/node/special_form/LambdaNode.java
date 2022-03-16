package syntax_analysis.node.special_form;

import syntax_analysis.node.ElementInterface;
import syntax_analysis.node.FunctionAtom;

public class LambdaNode implements ElementInterface {
    ElementInterface argumentsList;
    ElementInterface functionBody;

    public LambdaNode(ElementInterface argumentsList, ElementInterface functionBody) {
        this.argumentsList = argumentsList;
        this.functionBody = functionBody;
    }

    @Override
    public ElementInterface evaluate() {
        if (!FunctionAtom.checkFunctionArguments(argumentsList)) {
            throw new RuntimeException("The first argument should contain a number of atoms that represent " +
                    "the lambda parameters: " + argumentsList);
        }
        return new FunctionAtom(FunctionAtom.getListFunctionArguments(argumentsList), functionBody);
    }

    @Override
    public String toString() {
        return "LambdaNode{" +
                "list=" + argumentsList +
                ", element=" + functionBody +
                '}';
    }
}
