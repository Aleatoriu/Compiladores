public class SintException extends RuntimeException {
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
