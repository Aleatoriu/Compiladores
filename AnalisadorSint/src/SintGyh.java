import java.util.List;

public class SintGyh {
    private List<Token> tokens;
    private int index;

    public SintGyh(List<Token> tokenList){
        this.tokens = tokenList;
        this.index = 0;
    }

    public void printTokenList(){
        for(int i = 0; i < tokens.size(); i++){
            System.out.println(tokens.get(i) + " ");
        }
    }

    public void printLexeme(){
        for(int i = 0; i < tokens.size(); i++){
            System.out.println(tokens.get(i).getLexeme());
        }
    }

    public void printLine(){
        for(int i = 0; i < tokens.size(); i++){
            System.out.println(tokens.get(i).getLineNumber());
        }
    }

    public void printType(){
        for(int i = 0; i < tokens.size(); i++){
            System.out.println(tokens.get(i).getType());
        }
    }

    public boolean match(TokenType type) {
        if (index < tokens.size() && tokens.get(index).getType() == type) {
            index++;
            return true;
        } else if (index >= tokens.size()) {
            throw SintException.endOfFileExpected(type);
        } else {
            throw SintException.expectedToken(type, tokens.get(index));
        }
    }

    //Programa → ':' 'DEC' ListaDeclaracoes ':' 'PROG' ListaComandos;
    public void Programa() {
        if (index >= tokens.size() || !match(TokenType.Delim)) {
            throw SintException.expectedToken(TokenType.Delim, tokens.get(index));
        }
        if (!match(TokenType.PCDec)) {
            throw SintException.unexpectedToken(tokens.get(index));
        }
        ListaDeclaracoes();
        if (!match(TokenType.Delim)) {
            throw SintException.expectedToken(TokenType.Delim, tokens.get(index));
        }
        if (!match(TokenType.PCProg)) {
            throw SintException.unexpectedToken(tokens.get(index));
        }
        ListaComandos();
    }

    //*ListaDeclaracoes → Declaracao ListaDec;
    //ListDec  → Declaracao ListDec | E

    public void ListaDeclaracoes(){
        Declaracao();
        ListaDec();
    }

    public void ListaDec(){
        if(tokens.get(index).getType() == TokenType.Var){
            Declaracao();
            ListaDec();
        }
    }

    //Declaracao → VARIAVEL ':' TipoVar;
    public void Declaracao(){
        if(!match(TokenType.Var)) {
            throw SintException.unexpectedToken(tokens.get(index));
        }
        if(!match(TokenType.Delim)){
            throw SintException.expectedToken(TokenType.Delim, tokens.get(index));
        }
        TipoVar();
    }


    //TipoVar → 'INT' | 'REAL';
    public void TipoVar() {
        if (tokens.get(index).getType() == TokenType.PCInt) {
            match(TokenType.PCInt);
        } else if (tokens.get(index).getType() == TokenType.PCReal) {
            match(TokenType.PCReal);
        } else {
            throw SintException.unexpectedToken(tokens.get(index));
        }
    }


    //ExpressaoAritmetica → TermoAritmetico ExpressaoAritmeticaCont;
    public void ExpressaoAritmetica(){
        TermoAritmetico();
        ExpressaoAritmeticaCont();
    }

    //*ExpressaoAritmeticaCont → '+' TermoAritmetico ExpressaoAritmeticaCont
    //| '-' TermoAritmetico ExpressaoAritmeticaCont
    //| ε;

    public void ExpressaoAritmeticaCont(){
        if(tokens.get(index).getType() == TokenType.OpAritSoma){
            match(TokenType.OpAritSoma);
            TermoAritmetico();
            ExpressaoAritmeticaCont();
        }else if(tokens.get(index).getType() == TokenType.OpAritSub){
            match(TokenType.OpAritSub);
            TermoAritmetico();
            ExpressaoAritmeticaCont();
        }
    }

    //TermoAritmetico → FatorAritmetico TermoAritmeticoCont;
    public void TermoAritmetico(){
        FatorAritmetico();
        TermoAritmeticoCont();
    }

    //*TermoAritmeticoCont → '*' FatorAritmetico TermoAritmeticoCont
    //| '/' FatorAritmetico TermoAritmeticoCont
    //| ε;

    public void TermoAritmeticoCont(){
        if(tokens.get(index).getType() == TokenType.OpAritMult){
            match(TokenType.OpAritMult);
            FatorAritmetico();
            TermoAritmeticoCont();
        }else if(tokens.get(index).getType() == TokenType.OpAritDiv){
            match(TokenType.OpAritDiv);
            FatorAritmetico();
            TermoAritmeticoCont();
        }
    }

    //FatorAritmetico → NUMINT| NUMREAL | VARIAVEL | '(' ExpressaoAritmetica ')';
    public void FatorAritmetico(){
        switch (tokens.get(index).getType()){
            case NumInt:
                match(TokenType.NumInt);
                break;
            case NumReal:
                match(TokenType.NumReal);
                break;
            case Var:
                match(TokenType.Var);
                break;
            case AbrePar:
                match(TokenType.AbrePar);
                ExpressaoAritmetica();
                match(TokenType.FechaPar);
                break;
            default:
                throw SintException.unexpectedToken(tokens.get(index));
        }
    }

    //ExpressaoRelacional → TermoRelacional ExpressaoRelacionalCont;
    public void ExpressaoRelacional(){
        TermoRelacional();
        ExpressaoRelacionalCont();
    }
    //*ExpressaoRelacionalCont → OperadorBooleano TermoRelacional ExpressaoRelacionalCont
    //| ε;

    public void ExpressaoRelacionalCont(){
        if(tokens.get(index).getType() == TokenType.OpBoolE){
            OperadorBooleano();
            TermoRelacional();
            ExpressaoRelacionalCont();
        }else if(tokens.get(index).getType() == TokenType.OpBoolOu){
            OperadorBooleano();
            TermoRelacional();
            ExpressaoRelacionalCont();
        }
    }

    //TermoRelacional → ExpressaoAritmetica OP_REL ExpressaoAritmetica | '(' ExpressaoRelacional ')';
    public void TermoRelacional(){
        if(tokens.get(index).getType() == TokenType.AbrePar){
            match(TokenType.AbrePar);
            ExpressaoRelacional();
            match(TokenType.FechaPar);
        }else{
            ExpressaoAritmetica();
            if (verificaOpRelacional(tokens.get(index).getType())) {
                match(tokens.get(index).getType());
            } else {
                throw SintException.unexpectedToken(tokens.get(index));
            }
            ExpressaoAritmetica();
        }
    }


    private boolean verificaOpRelacional(TokenType type) {
        return type == TokenType.OpRelIgual ||
                type == TokenType.OpRelMaior ||
                type == TokenType.OpRelMenor ||
                type == TokenType.OpRelMaiorIgual ||
                type == TokenType.OpRelMenorIgual ||
                type == TokenType.OpRelDif;
    }

    //OperadorBooleano → 'E' | 'OU';

    public void OperadorBooleano(){
        if(tokens.get(index).getType() == TokenType.OpBoolE){
            match(TokenType.OpBoolE);
        }else if(tokens.get(index).getType() == TokenType.OpBoolOu){
            match(TokenType.OpBoolOu);
        }
    }

    //ListaComandos → Comando ListaComandos | Comando;
    public void ListaComandos() {
        while (index < tokens.size()) {
            if (tokens.get(index).getType() == TokenType.PCFim) {
                return; // Finaliza o loop ao encontrar PCFim
            }
            Comando(); // Processa os comandos
        }
    }

    //Comando → Atribuicao | Entrada | Saida | Condicao | Repeticao;
    public void Comando(){
        switch (tokens.get(index).getType()){
            case Var:
                Atribuicao();
                break;
            case PCLer:
                Entrada();
                break;
            case PCImprimir:
                Saida();
                break;
            case PCSe:
                Condicao();
                break;
            case PCEnqto:
                Repeticao();
                break;
            case PCIni:
                SubAlgoritmo();
                break;
            default:
                throw SintException.unexpectedToken(tokens.get(index));
        }
    }

    //ComandoAtribuicao → VARIAVEL ':=' ExpressaoAritmetica;

    public void Atribuicao(){
        match(TokenType.Var);
        match(TokenType.Atrib);
        ExpressaoAritmetica();
    }

    //ComandoEntrada → 'LER' VARIAVEL;

    public void Entrada(){
        match(TokenType.PCLer);
        match(TokenType.Var);
    }

    //ComandoSaida → 'IMPRIMIR'  VARIAVEL | 'IMPRIMIR' CADEIA;
    public void Saida(){
        match(TokenType.PCImprimir);
        if(tokens.get(index).getType() == TokenType.Var){
            match(TokenType.Var);
        }else{
            match(TokenType.Cadeia);
        }
    }

    public void Condicao(){
        match(TokenType.PCSe);
        ExpressaoRelacional();
        match(TokenType.PCEntao);
        Comando();
        ComandoCondicaoCont();
    }

    public void ComandoCondicaoCont(){
        if(tokens.get(index).getType() == TokenType.PCSenao){
            match(TokenType.PCSenao);
            Comando();
        }
    }

    //ComandoRepeticao → 'ENQTO' ExpressaoRelacional Comando;
    public void Repeticao(){
        match(TokenType.PCEnqto);
        ExpressaoRelacional();
        Comando();
    }

    //SubAlgoritmo → 'INI' ListaComandos 'FIM';
    public void SubAlgoritmo(){
        if(index < tokens.size() && match(TokenType.PCIni)) {
            ListaComandos();
            if (index < tokens.size() && tokens.get(index).getType() == TokenType.PCFim) {
                match(TokenType.PCFim);
            } else {
                throw SintException.expectedToken(TokenType.PCFim, tokens.get(index - 1));
            }
        } else {
            throw SintException.expectedToken(TokenType.PCIni, tokens.get(index - 1));
        }
    }
}
