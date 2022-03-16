package syntax_analysis.node;

import java.util.List;

public class FunctionAtom implements ElementInterface {

    private final List<AtomNode> arguments;
    List<ElementInterface> parameters;
    private final ElementInterface body;


    public FunctionAtom(List<AtomNode> arguments, ElementInterface body) {
        this.arguments = arguments;
        this.body = body;
    }

    @Override
    public ElementInterface evaluate() {
        System.out.println("hhhhh");
        // todo тут надо создать что-то типа new LocalContext()
        // это singleton? класс который как-то замапит arguments -> parameters
        // либо нужно как-то заменить внутри body все аргументы на параметры
        // либо (мне кажется проще) при вызове у AtomNode .evaluate() проверять, если эта
        // переменная 'Undefined atom' или есть в LocalContext() среди arguments, то вернуть значение
        // соответствующего parameter, с которым мы замапили этот аргумент
        body.evaluate();
        return null;
    }

    public void setParameters(List<ElementInterface> parameters) {
        this.parameters = parameters;
    }
}
