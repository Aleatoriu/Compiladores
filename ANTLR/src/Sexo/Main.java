import java.io.IOException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
//Alexandre Aparecido da Silva - a2408724
//Guilherme de Almeida do Carmo - a2207184
//https://www.youtube.com/watch?v=Wokod0waNKw
//https://docs.google.com/document/d/1Opq4jkcF4XDt--TIwDGKR_o8fksh2ytLAY6M4jqtmgc/edit?usp=sharing
public class Main {
    public static void main(String[] args)  {
        try{
           CharStream cs = CharStreams.fromFileName(args[0]);

            GrammarGyhLexer lexer = new GrammarGyhLexer(cs);
            CommonTokenStream token = new CommonTokenStream(lexer);
            GrammarGyhParser parser = new GrammarGyhParser(token);

            parser.programa();

            parser.generateComando();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}