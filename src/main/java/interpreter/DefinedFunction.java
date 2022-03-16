package interpreter;

import syntax_analysis.node.AtomNode;
import syntax_analysis.node.ElementInterface;
import syntax_analysis.node.FunctionAtom;

import java.util.List;
import java.util.stream.Collectors;

public class DefinedFunction {

    List<ElementInterface> parameters;

    public DefinedFunction(List<ElementInterface> parameters) {
        this.parameters = parameters;
    }

    public boolean isDefinedFunction() {
        try {
            AtomNode atom = (AtomNode) parameters.get(0);
            return FunctionsTable.getInstance().contains(atom.name);
        } catch (ClassCastException | IndexOutOfBoundsException e) {
            return false;
        }
    }

    public ElementInterface performFunctionAction() {
        System.out.println("User-Defined Function Call");
        AtomNode atom = (AtomNode) parameters.get(0);
        FunctionAtom function = FunctionsTable.getInstance().getFunctionValue(atom.name);
        function.setParameters(parameters.subList(1, parameters.size()));
        return function.evaluate();
    }
}
