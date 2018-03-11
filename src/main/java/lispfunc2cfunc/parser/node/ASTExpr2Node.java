package lispfunc2cfunc.parser.node;

public class ASTExpr2Node extends ASTExprNode {

    public ASTExprNode expression;

    @Override
    public String toString() {
        return "ASTExpr2Node{" +
                "expression=" + expression +
                '}';
    }
}