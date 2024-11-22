import java.util.List;

public class SintGyh {
    List<Token> tokens;

    public SintGyh(List<Token> tokens) {
        this.tokens = tokens;
    }

    private boolean match(TokenType type) {
        if (tokens.get(0).getType() == type) {
            tokens.remove(0);
            return true;
        }
        return false;
    }

    public void start() {
        program();
    }

    //Programa → ':' 'DEC' ListaDeclaracoes ':' 'PROG' ListaComandos;

    private void program() {
        if (match(TokenType.PCDec)) {
            declarationsList();
            if (match(TokenType.PCProg)) {
                commandsList();
            }
        }
    }
    //*ListaDeclaracoes → Declaracao ListaDec;
    //ListDec2  → Declaracao ListDec2 | E


    private void declarationsList() {
        declaration();
        declarationsList2();
    }

    private void declarationsList2() {
        declaration();
        declarationsList2();
    }

    //Declaracao → VARIAVEL ':' TipoVar;

    private void declaration(){

    }
}
    


