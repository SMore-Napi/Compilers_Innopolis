package syntax_analysis.node.special_form;

import syntax_analysis.node.ElementInterface;

public class LambdaNode implements ElementInterface {
    ElementInterface list;
    ElementInterface element;

    public LambdaNode(ElementInterface list, ElementInterface element) {
        this.list = list;
        this.element = element;
    }

    @Override
    public String toString() {
        return "LambdaNode{" +
                "list=" + list +
                ", element=" + element +
                '}';
    }
}
