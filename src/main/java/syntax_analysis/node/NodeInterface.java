package syntax_analysis.node;

public interface NodeInterface {
    // todo delete default and implement this method for all classes
    default NodeInterface evaluate() {
        return null;
    }
}
