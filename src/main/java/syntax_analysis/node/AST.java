package syntax_analysis.node;

public class AST {

    private final ListNode root;

    public AST(ListNode lst) {
        this.root = lst;
    }

    public void printAST() {
        System.out.println(root);
    }
}
