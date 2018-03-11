package lispfunc2cfunc.visitor;

import lispfunc2cfunc.parser.node.*;

import java.util.ArrayList;

public class Visitor {

    public void visitor(ASTNode astNode, ASTNode parent) throws Exception {

        if ("NumberLiteral".equals(astNode.type)) {

            ASTNumberNode astNumberNode = new ASTNumberNode();
            astNumberNode.type = "NumberLiteral";
            astNumberNode.value = ((ASTNumberNode) astNode).value;
            parent._context.add(astNumberNode);

        } else if ("CallExpression".equals(astNode.type)) {

            ASTCalleeNode astCalleeNode = new ASTCalleeNode();
            astCalleeNode.type = "Identifier";
            astCalleeNode.name = ((ASTCallNode)astNode).name;

            ASTExprNode astExprNode = new ASTExprNode();

            astExprNode.type = "CallExpression";
            astExprNode.callee = astCalleeNode;
            astExprNode.arguments = new ArrayList<ASTNode>();

            //put terminal nodes to arguments.
            astNode._context = astExprNode.arguments;

            //
            if(!parent.type.equals("CallExpression")){

                ASTExpr2Node exprNode = new ASTExpr2Node();
                exprNode.type = "ExpressionStatement";
                exprNode.expression = astExprNode;

                parent._context.add(exprNode);
                return;
            }

            parent._context.add(astExprNode);

        }
    }
}