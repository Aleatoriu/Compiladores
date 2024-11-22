public class SintException extends RuntimeException {
    public SintException(String message) {
        super(message);
    }

    public static SintException unexpectedToken(Token token) {
        return new SintException("Erro sintático: token inesperado '" + token.getLexeme() +
                "' na linha " + token.getLineNumber());
    }

    public static SintException expectedToken(TokenType expectedType, Token foundToken) {
        if (foundToken == null) {
            return new SintException("Erro sintático: esperado '" + expectedType +
                    "', mas fim do arquivo encontrado.");
        } else {
            return new SintException("Erro sintático: esperado '" + expectedType +
                    "', mas encontrado '" + foundToken.getLexeme() +
                    "' na linha " + foundToken.getLineNumber());
        }
    }

    public static SintException unexpectedEOF() {
        return new SintException("Erro sintático: fim do arquivo inesperado.");
    }
}
