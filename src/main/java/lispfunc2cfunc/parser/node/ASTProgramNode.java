package lispfunc2cfunc.parser.node;

import java.util.List;

public class ASTProgramNode extends ASTNode {

    public List<ASTNode> body;

    @Override
    public String toString() {
        return "ASTProgramNode{" +
                "type='" + type + '\'' +
                ", body=" + body +
                '}';
    }
}