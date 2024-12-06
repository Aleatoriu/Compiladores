public class SintException extends RuntimeException {  //exceptions especificas para o sintatico, a depender do caso lanca a forma de exceção informando inesperado ou esperado.
    public SintException(String message) {
        super(message);
    }

    public static SintException endOfFileExpected(TokenType type) {
        return new SintException("Fim do aquivo esperado, mas encontrou: " + type);
    }

    public static SintException expectedToken(TokenType expected, Token actual) {
        return new SintException("Token esperado: " + expected + ", Inesperado encontrado: " + actual.getType());
    }

    public static SintException unexpectedToken(Token token) {
        return new SintException("Token inesperado: " + token.getType());
    }
}
