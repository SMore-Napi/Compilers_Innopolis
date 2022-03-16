package syntax_analysis.node.special_form;

import syntax_analysis.node.ElementInterface;

public class ReturnNode implements ElementInterface {
    ElementInterface element;

    public ReturnNode(ElementInterface element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return "ReturnNode{" +
                "element=" + element +
                '}';
    }
}
