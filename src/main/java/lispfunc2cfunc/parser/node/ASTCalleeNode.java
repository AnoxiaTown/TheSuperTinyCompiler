package lispfunc2cfunc.parser.node;

public class ASTCalleeNode extends ASTNode {

    public String name;

    @Override
    public String toString() {
        return "ASTCalleeNode{" +
                "name='" + name + '\'' +
                '}';
    }
}