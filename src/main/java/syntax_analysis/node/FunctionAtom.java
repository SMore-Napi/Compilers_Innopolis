package syntax_analysis.node;

import interpreter.AtomsTable;

import java.util.List;
import java.util.stream.Collectors;

public class FunctionAtom implements ElementInterface {

    private final List<AtomNode> arguments;
    List<ElementInterface> parameters;
    private final ElementInterface body;


    public FunctionAtom(List<AtomNode> arguments, ElementInterface body) {
        this.arguments = arguments;
        this.body = body;
    }

    @Override
    public ElementInterface evaluate() {
        System.out.println("Calling function");
        System.out.println("Arguments: " + arguments);
        System.out.println("Parameters: " + parameters);
        System.out.println("Function body: " + body);
        AtomsTable.getInstance().introduceLocalContext();
        for (int i = 0; i < parameters.size(); i++) {
            //todo evaluate parameter?
            AtomsTable.getInstance().addAtom(new AtomNode(arguments.get(i).name, parameters.get(i).evaluate()));
        }
        System.out.println("New local context");
        AtomsTable.getInstance().printAtomsInNestedContext();
        System.out.println("=======");
        ElementInterface result = body.evaluate();
        System.out.println("Function result: " + result);
        AtomsTable.getInstance().leaveLocalContext();
        return result;
    }

    public void setParameters(List<ElementInterface> parameters) {
        //todo is it allowed to have a partially defined function?
        /*
        if (parameters.size() > this.arguments.size()){
            throw new RuntimeException("Too much");
        }
         */
        if (parameters.size() != this.arguments.size()) {
            throw new RuntimeException("Expected number of arguments doesn't match the given number.\n"
                    + "Expected: " + this.arguments.size() + ". Actual: " + parameters.size());
        }
        this.parameters = parameters;
    }


    public static boolean checkFunctionArguments(ElementInterface argumentsList) {
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

    public static List<AtomNode> getListFunctionArguments(ElementInterface argumentsList) {
        return ((ListNode) argumentsList).elements.stream().map(a -> (AtomNode) a).collect(Collectors.toList());
    }
}
