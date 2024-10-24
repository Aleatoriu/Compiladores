import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Erro: Por favor, forneça o caminho para o arquivo como argumento.");
            System.exit(1); // verifica se o arquivo foi passado como argumento se nao manda pra casa do krlh
        }

        String fileName = args[0]; // pega o nome do arquivo
            LexerGym lex = new LexerGym(fileName);
            List<Token> tokens = lex.nextToken();
            for (Token token : tokens) {
                System.out.println(token);
            }
    }
}
