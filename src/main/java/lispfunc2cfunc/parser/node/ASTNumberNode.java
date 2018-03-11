package lispfunc2cfunc.parser.node;

public class ASTNumberNode extends ASTNode {

    public String value;

    @Override
    public String toString() {
        return "ASTNumberNode{" +
                "type='" + type + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}