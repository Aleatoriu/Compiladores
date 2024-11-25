//Alexandre Aparecido da Silva - a2408724
//Guilherme de Almeida do Carmo - a2207184

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String fileName = args[0];
        LexerGyh lex = new LexerGyh(fileName);
        List<Token> tokens = lex.nextToken();
        SintGyh sint = new SintGyh(tokens);
        sint.printType();
        sint.Programa();
    }
}
