package syntax_analysis.node;

import java.util.ArrayList;
import java.util.List;


public class AST {

    private final List<ElementNode> root;

    public AST(ListNode lst){
        this.root = lst.elements;
    }

    public void printAST() {
        System.out.println(root);
    }

    public List<Node> getNodes() {
        List<Node> nodes = new ArrayList<>();
        for (ElementNode node : root) {
            nodes.add(node);
            nodes.addAll(node.inorderTraversal());
        }
        return nodes;
    }
}
