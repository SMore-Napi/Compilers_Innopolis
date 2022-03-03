package syntax_analysis.node;

public class EvaluatorNode implements NodeInterface {
    NodeInterface element;

    public EvaluatorNode(NodeInterface element) {
        this.element = element;
    }

    @Override
    public NodeInterface evaluate() {
        System.out.println("=====");
        System.out.println("Initial node: " + this);
        System.out.println("Evaluated node: " + element);
        System.out.println("=====");
        return element.evaluate();
    }

    @Override
    public String toString() {
        return "eval{" + element + '}';
    }
}
