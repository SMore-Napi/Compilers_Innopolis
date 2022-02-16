package syntax_analysis.node;

public class EvaluatorNode implements NodeInterface {
    NodeInterface element;

    public EvaluatorNode(NodeInterface element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return "EvaluatorNode{" +
                "element=" + element +
                '}';
    }
}
