package interpreter;

import syntax_analysis.node.AtomNode;
import syntax_analysis.node.ElementInterface;
import syntax_analysis.node.FunctionAtom;

import java.util.List;

public class DefinedFunction {

    List<ElementInterface> parameters;

    public DefinedFunction(List<ElementInterface> parameters) {
        this.parameters = parameters;
    }

    public static boolean isDefinedFunction(String functionName) {
        return FunctionsTable.getInstance().contains(functionName);
    }

    public boolean isDefinedFunction() {
        return isDefinedFunction(parameters.get(0));
    }

    public static boolean isDefinedFunction(ElementInterface element) {
        try {
            AtomNode atom = (AtomNode) element;
            System.out.println("Check if " + atom + " is defined function");
            System.out.println(FunctionsTable.getInstance().contains(atom.name)
                    || (AtomsTable.getInstance().getAtomValue(atom.name) instanceof FunctionAtom));
            return FunctionsTable.getInstance().contains(atom.name)
                    || (AtomsTable.getInstance().getAtomValue(atom.name) instanceof FunctionAtom);
        } catch (ClassCastException | IndexOutOfBoundsException e) {
            return false;
        }
    }

    public ElementInterface performFunctionAction() {
        System.out.println("User-Defined Function Call");
        AtomNode atom = (AtomNode) parameters.get(0);
        FunctionAtom function;
        if (FunctionsTable.getInstance().contains(atom.name)) {
            function = FunctionsTable.getInstance().getFunctionValue(atom.name);
        } else if (AtomsTable.getInstance().getAtomValue(atom.name) instanceof FunctionAtom) {
            function = (FunctionAtom) AtomsTable.getInstance().getAtomValue(atom.name);
        } else {
            throw new RuntimeException(atom + " is not a function");
        }
        function.setParameters(parameters.subList(1, parameters.size()));
        return function.evaluate();
    }
}
