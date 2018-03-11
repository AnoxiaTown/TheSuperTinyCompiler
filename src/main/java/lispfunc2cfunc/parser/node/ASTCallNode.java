package lispfunc2cfunc.parser.node;

import java.util.List;

public class ASTCallNode extends ASTNode {

    public String name;
    public List<ASTNode> params;

    @Override
    public String toString() {
        return "ASTCallNode{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", params=" + params +
                '}';
    }
}