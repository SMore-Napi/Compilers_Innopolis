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

    public static boolean isDefinedFunction(ElementInterface element) {
        try {
            AtomNode atom = (AtomNode) element;
            return FunctionsTable.getInstance().contains(atom.name)
                    || (AtomsTable.getInstance().getAtomValue(atom.name) instanceof FunctionAtom);
        } catch (ClassCastException | IndexOutOfBoundsException e) {
            return false;
        }
    }

    public boolean isDefinedFunction() {
        if (parameters.isEmpty()) {
            return false;
        }
        return isDefinedFunction(parameters.get(0));
    }

    public ElementInterface performFunctionAction() {
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
