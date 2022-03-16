package syntax_analysis.node.special_form;

import syntax_analysis.node.ElementInterface;

public class ProgNode implements ElementInterface {
    ElementInterface list;
    ElementInterface element;

    public ProgNode(ElementInterface list, ElementInterface element) {
        this.list = list;
        this.element = element;
    }

    @Override
    public String toString() {
        return "ProgNode{" +
                "list=" + list +
                ", element=" + element +
                '}';
    }
}
