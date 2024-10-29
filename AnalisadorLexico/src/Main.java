//Alexandre Aparecido da Silva - a2408724
//Guilherme de Almeida do Carmo - a2207184

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String fileName = args[0];
        LexerGyh lex = new LexerGyh(fileName);


        List<Token> tokens = lex.nextToken(); //retorna a lista de tokens finalizada da lexergyh mas da pra colocar na funcao se pa
        for (Token token : tokens) {
            System.out.println(token); //printa os tokens
        }
    }
}
