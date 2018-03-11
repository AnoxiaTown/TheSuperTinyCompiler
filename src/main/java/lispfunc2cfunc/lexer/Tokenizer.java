package lispfunc2cfunc.lexer;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer {

    public List<Token> tokens(String input) throws Exception {

        List<Token> tokenList = new ArrayList<Token>();
        int currentPos = 0;
        while (currentPos < input.length()) {

            char currentChar = input.charAt(currentPos);

            if ('(' == currentChar) {
                tokenList.add(new Token().setType("paren").setValue("("));
                currentPos++;
                continue;
            } else if (')' == currentChar) {
                tokenList.add(new Token().setType("paren").setValue(")"));
                currentPos++;
                continue;
            } else if (Character.isWhitespace(currentChar)) {
                currentPos++;
                continue;
            } else if (Character.isDigit(currentChar)) {
                StringBuilder digitsBuilder = new StringBuilder();
                while (Character.isDigit(currentChar)) {
                    digitsBuilder.append(currentChar);
                    currentChar = input.charAt(++currentPos);
                }
                tokenList.add(new Token().setType("number").setValue(digitsBuilder.toString()));
                continue;
            } else if (isAlphabet(currentChar)) {
                StringBuilder charsBuilder = new StringBuilder();
                while (isAlphabet(currentChar)) {
                    charsBuilder.append(currentChar);
                    currentChar = input.charAt(++currentPos);
                }
                tokenList.add(new Token().setType("name").setValue(charsBuilder.toString()));
                continue;
            } else {
                throw new Exception("I dont know what this character is: " + currentChar);
            }
        }
        return tokenList;
    }

    private boolean isAlphabet(char inputChar) {
        return (inputChar >= 'A' && inputChar <= 'Z')
                || (inputChar >= 'a' && inputChar <= 'z');
    }
}