package lispfunc2cfunc.parser;

import lispfunc2cfunc.lexer.Token;
import lispfunc2cfunc.parser.node.ASTCallNode;
import lispfunc2cfunc.parser.node.ASTNode;
import lispfunc2cfunc.parser.node.ASTNumberNode;
import lispfunc2cfunc.parser.node.ASTProgramNode;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    private int currentPos = 0;
    private List<Token> tokens = null;

    public ASTNode parser(List<Token> tokens) throws Exception {

        currentPos = 0;
        this.tokens = tokens;

        ASTProgramNode astProgramNode = new ASTProgramNode();
        astProgramNode.type = "Program";

        List<ASTNode> bodyNodeArray = new ArrayList<ASTNode>();

        for (; currentPos < tokens.size(); currentPos++) {
            bodyNodeArray.add(walk());
        }

        astProgramNode.body = bodyNodeArray;
        return astProgramNode;
    }

    private ASTNode walk() throws Exception {

        Token token = tokens.get(currentPos);

        if ("number".equals(token.getType())) {
            currentPos++;
            ASTNumberNode astNumberNode = new ASTNumberNode();
            astNumberNode.type = "NumberLiteral";
            astNumberNode.value = token.getValue();
            return astNumberNode;
        }

        if ("paren".equals(token.getType()) && "(".equals(token.getValue())) {

            token = tokens.get(++currentPos);

            ASTCallNode astCallNode = new ASTCallNode();
            astCallNode.type = "CallExpression";
            astCallNode.name = token.getValue();

            token = tokens.get(++currentPos);

            List<ASTNode> paramArray = new ArrayList<ASTNode>();

            while (!"paren".equals(token.getType())
                    ||
                    ("paren".equals(token.getType()) && !")".equals(token.getValue()))
                    ) {
                paramArray.add(walk());
                token = tokens.get(currentPos);
            }

            astCallNode.params = paramArray;

            currentPos++;//跳过右圆括号
            return astCallNode;
        }

        throw new Exception("类型未知");
    }
}