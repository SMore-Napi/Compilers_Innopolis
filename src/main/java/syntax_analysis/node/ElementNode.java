package syntax_analysis.node;

import java.util.ArrayList;
import java.util.List;

public class ElementNode extends Node {
    public AtomNode atomNode;
    public LiteralNode literalNode;
    public ListNode list;

    public ElementNode(Node node) {
        if (node instanceof AtomNode) {
            this.atomNode = (AtomNode) node;
        } else if (node instanceof LiteralNode) {
            this.literalNode = (LiteralNode) node;
        }
    }

    public ElementNode(ListNode list) {
        this.list = list;
    }

    @Override
    public Object get() {
        if (atomNode != null) {
            return atomNode;
        }
        if (literalNode != null) {
            return literalNode;
        }
        if (list != null) {
            return list;
        }
        return null;
    }

    @Override
    public List<Node> inorderTraversal () {
        if (atomNode != null) {
            List<Node> lst = new ArrayList<>();
            lst.add(atomNode);
            return lst;
        }
        if (literalNode != null) {
            List<Node> lst = new ArrayList<>();
            lst.add(literalNode);
            return lst;
        }
        if (list != null) {
            List<Node> lst = new ArrayList<>();
            for (Node n : list.elements){
                lst.addAll(n.inorderTraversal());
            }
            return lst;
        }
        return null;
    }

    @Override
    public String toString() {
        if (atomNode != null) {
            return "ElementNode{" +
                    "atomNode=" + atomNode +
                    '}';
        }
        if (literalNode != null) {
            return "ElementNode{" +
                    "literalNode=" + literalNode +
                    '}';
        }
        if (list != null) {
            return "ElementNode{" +
                    "list=" + list +
                    '}';
        }
        return "ElementNode{null}";
    }
}