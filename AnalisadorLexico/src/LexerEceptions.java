public class LexerEceptions extends RuntimeException {  //aqui é minha tentativa de criar exceções que são especificas para o lexer porem nao ficou legal
    public LexerEceptions (String message) {
        super(message);
    }
    public static LexerEceptions invalidToken(String token, int line) {
        return new LexerEceptions("Token inválido na linha " + line + ": " + token);
    }
    public static LexerEceptions invalidCharacter(char c, int line) {
        return new LexerEceptions("Caractere inválido na linha " + line + ": " + c);
    }
    public static LexerEceptions unknownToken(String token, int line) {
        return new LexerEceptions("Token desconhecido na linha " + line + ": " + token);
    }
    public static LexerEceptions invalidKeyword(String token,int line) {
        return new LexerEceptions("Palavra chave inválida na linha " + line + ": " + token);

    }
}


