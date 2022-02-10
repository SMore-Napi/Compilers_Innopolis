package syntax_analysis.node;

public class EvaluatorNode extends Node {
    ElementNode element;

    public EvaluatorNode(ElementNode element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return "EvaluatorNode{" +
                "element=" + element +
                '}';
    }
}
