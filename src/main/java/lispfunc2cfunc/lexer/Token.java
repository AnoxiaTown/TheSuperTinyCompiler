package lispfunc2cfunc.lexer;

public class Token {

    private String type;
    private String value;

    public String getType() {
        return type;
    }

    public Token setType(String type) {
        this.type = type;
        return this;
    }

    public String getValue() {
        return value;
    }

    public Token setValue(String value) {
        this.value = value;
        return this;
    }

    @Override
    public String toString() {
        return "Token{" +
                "type='" + type + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}