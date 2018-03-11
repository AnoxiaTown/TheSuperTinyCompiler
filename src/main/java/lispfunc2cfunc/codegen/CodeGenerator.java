package lispfunc2cfunc.codegen;


import lispfunc2cfunc.parser.node.*;

import java.util.List;

public class CodeGenerator {

    /**
     * 遍历AST生成字符串
     *
     * @param astNode
     * @return
     * @throws Exception
     */
    public String codeGen(ASTNode astNode) throws Exception {

        if ("Program".equals(astNode.type)) {

            ASTProgramNode astProgramNode = (ASTProgramNode) astNode;
            return nodeList(astProgramNode.body, "\n");

        } else if ("ExpressionStatement".equals(astNode.type)) {

            ASTExpr2Node astExpr2Node = (ASTExpr2Node) astNode;
            return codeGen(astExpr2Node.expression) + ";";

        } else if ("CallExpression".equals(astNode.type)) {

            ASTExprNode astExprNode = (ASTExprNode) astNode;
            return
                    codeGen(astExprNode.callee)
                            + "("
                            + nodeList(astExprNode.arguments, ",")
                            + ")"
                    ;

        } else if ("Identifier".equals(astNode.type)) {

            return ((ASTCalleeNode) astNode).name;

        } else if ("NumberLiteral".equals(astNode.type)) {

            return ((ASTNumberNode) astNode).value;

        }
        throw new Exception("类型错误");
    }

    private String nodeList(List<ASTNode> nodeList, String symbol) throws Exception {
        StringBuilder result = new StringBuilder();
        for (int j = 0; j < nodeList.size(); j++) {
            ASTNode astNode = nodeList.get(j);
            result.append(codeGen(astNode));
            if (j != nodeList.size() - 1) {
                result.append(symbol);
            }

        }
        return result.toString();
    }
}