package syntax_analysis.node.special_form;

import interpreter.AtomsTable;
import interpreter.FunctionsTable;
import syntax_analysis.node.ElementInterface;

public class ProgNode implements ElementInterface {
    ElementInterface arguments;
    ElementInterface elements;

    public ProgNode(ElementInterface arguments, ElementInterface elements) {
        this.arguments = arguments;
        this.elements = elements;
    }

    @Override
    public ElementInterface evaluate() {
        AtomsTable.getInstance().introduceLocalContext();
        FunctionsTable.getInstance().introduceLocalContext();




        AtomsTable.getInstance().leaveLocalContext();
        FunctionsTable.getInstance().leaveLocalContext();

        return null;

    }


    @Override
    public String toString() {
        return "ProgNode{" +
                "list=" + arguments +
                ", element=" + elements +
                '}';
    }
}
