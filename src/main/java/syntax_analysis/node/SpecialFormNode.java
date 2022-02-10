package syntax_analysis.node;

public class SpecialFormNode {
    public enum Form {
        QUOTE, SETQ, FUNC, LAMBDA, PROG, COND, WHILE, RETURN, BREAK
    }

    ElementNode firstElement;
    ElementNode secondElement;
    ElementNode thirdElement;
    AtomNode atomNode;
    ListNode list;
    Form form;

    public SpecialFormNode(Form form, AtomNode atomNode, ElementNode firstElement) {
        this.firstElement = firstElement;
        this.atomNode = atomNode;
        this.form = form;
    }

    public SpecialFormNode(Form form, AtomNode atomNode,  ListNode list, ElementNode firstElement) {
        this.firstElement = firstElement;
        this.atomNode = atomNode;
        this.form = form;
        this.list = list;
    }

    public SpecialFormNode(Form form, ListNode list, ElementNode firstElement) {
        this.firstElement = firstElement;
        this.form = form;
        this.list = list;
    }

    public SpecialFormNode(Form form, ElementNode firstElement, ElementNode secondElement, ElementNode thirdElement) {
        this.firstElement = firstElement;
        this.secondElement = secondElement;
        this.thirdElement = thirdElement;
        this.form = form;
    }

    public SpecialFormNode(Form form, ElementNode firstElement) {
        this.firstElement = firstElement;
        this.form = form;
    }

    public SpecialFormNode(Form form, ElementNode firstElement, ElementNode secondElement) {
        this.firstElement = firstElement;
        this.secondElement = secondElement;
        this.form = form;
    }

    public SpecialFormNode(Form form) {
        this.form = form;
    }

    @Override
    public String toString() {
        return "SpecialFormNode{" +
                "firstElement=" + firstElement +
                ", secondElement=" + secondElement +
                ", thirdElement=" + thirdElement +
                ", atomNode=" + atomNode +
                ", list=" + list +
                ", form=" + form +
                '}';
    }
}
