package syntax_analysis.node;

public interface ElementInterface {
    // todo delete default and implement this method for all classes
    default ElementInterface evaluate() {
        return null;
    }
}
