package lispfunc2cfunc.parser.node;

import java.util.List;

public class ASTExprNode extends ASTNode {

    public String name;
    public ASTCalleeNode callee;
    public List<ASTNode> arguments;

    @Override
    public String toString() {
        return "ASTExprNode{" +
                "name='" + name + '\'' +
                ", callee=" + callee +
                ", arguments=" + arguments +
                '}';
    }
}