package syntax_analysis.node.special_form;

import interpreter.FunctionsTable;
import syntax_analysis.node.AtomNode;
import syntax_analysis.node.ElementInterface;
import syntax_analysis.node.FunctionAtom;
import syntax_analysis.node.ListNode;

import java.util.List;
import java.util.stream.Collectors;

public class FuncNode implements ElementInterface {
    AtomNode functionName;
    ElementInterface argumentsList;
    ElementInterface functionBody;

    public FuncNode(AtomNode functionName, ElementInterface argumentsList, ElementInterface functionBody) {
        this.functionName = functionName;
        this.argumentsList = argumentsList;
        this.functionBody = functionBody;
    }

    //todo local context


    @Override
    public ElementInterface evaluate() {
        if (!checkArguments()) {
            throw new RuntimeException("The second argument should contain a number of atoms that represent " +
                    "the function parameters: " + argumentsList);
        }
        FunctionAtom function = new FunctionAtom(this.getListArguments(), functionBody);
        functionName.value = function;
        FunctionsTable.getInstance().addFunction(functionName.name, function);
        return functionName;
    }

    private boolean checkArguments() {
        try {
            if (argumentsList instanceof ListNode) {
                for (ElementInterface atomArgument : ((ListNode) argumentsList).elements) {
                    try {
                        if (!(atomArgument instanceof AtomNode)) {
                            return false;
                        }
                    } catch (ClassCastException e) {
                        return false;
                    }
                }
                return true;
            } else {
                return false;
            }
        } catch (ClassCastException e) {
            return false;
        }
    }

    private List<AtomNode> getListArguments() {
        return ((ListNode) argumentsList).elements.stream().map(a -> (AtomNode) a).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "FuncNode{" +
                "atom=" + functionName +
                ", list=" + argumentsList +
                ", element=" + functionBody +
                '}';
    }
}
