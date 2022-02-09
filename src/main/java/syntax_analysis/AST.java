package syntax_analysis;

import java.util.ArrayList;
import java.util.List;

class Node {
    public Object get() {
        return null;
    }
}

/*ast.create(ast.createElementList($1));*/
/*ast.create(ast.addElementToList($1, $2));*/
/*$$ = ast.createEmptyList();*/
/*$$ = ast.addElementToList($1, $2);*/

class ListNode extends Node {
    List<Node> elements;
}

class ElementNode extends Node {
    AtomNode atomNode;
    LiteralNode literalNode;
    ListNode listNode;

    @Override
    public Object get() {
        if (atomNode != null) {
            return atomNode;
        }
        if (literalNode != null) {
            return literalNode;
        }
        if (listNode != null) {
            return listNode;
        }
        return null;
    }
}

class AtomNode extends Node {

}

class CondNode extends Node {
    Node condition;
    Node trueResult;
    Node falseResult;

    @Override
    public Object get() {
        return (Boolean) condition.get()
                ? trueResult
                : falseResult;
    }
}

class LiteralNode extends Node {
    Integer integerValue;
    Double realValue;
    Boolean booleanValue;

    @Override
    public Object get() {
        if (integerValue != null) {
            return integerValue;
        }
        if (realValue != null) {
            return realValue;
        }
        if (booleanValue != null) {
            return booleanValue;
        }
        return null;
    }
}

public class AST {

    private List<ElementNode> root;

    public AST() {
        root = new ArrayList<>();
    }

    public void create(List<AST> list) {


    }

    public static List<AST> createEmptyList() {
        return new ArrayList<>();
    }

    public static List<ElementNode> createElementList(ElementNode element) {
        System.out.println(element);

        List<ElementNode> n = new ArrayList<>();
        n.add(element);
        System.out.println(n);
        return n;

    }

    public static List<ElementNode> addElementToList(ElementNode element, List<ElementNode> list) {
        System.out.println(element);
        System.out.println(list);
        List<ElementNode> n = new ArrayList<>();
        n.add(element);
        n.addAll(list);
        System.out.println(n);
        return n;
    }

}
