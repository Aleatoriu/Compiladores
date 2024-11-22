
public class Token {  //aqui é a classe token que é a classe que representa os tokens que são retornados pelo lexer pra nao ficar bagunçado
    public TokenType type;
    public String lexeme;
    public int line;

    public Token(TokenType type, String lexeme, int line) {
        this.type = type;
        this.lexeme = lexeme;
        this.line = line;
    }

    @Override
    public String toString() {
        return "<" + type + ", " + lexeme + ", " + line + ">";
    }

    public TokenType getType() {
        return type;
    }

    public String getLexeme() {
        return lexeme;
    }

    public int getLineNumber() {
        return line;
    }
}
