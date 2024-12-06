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
    } //funcao para testes, esqueci como q tava vindo do lexer

    public void startSint(){
        Programa();
    } //incia o sintatico

    public boolean match(TokenType type) { //funcao para comparar o token atual com o token esperado pra nao ficar uma bagunça no codigo cheio de if else
        if (index < tokens.size() && tokens.get(index).getType() == type) { //verifica se o index é menor que o tamanho da lista de tokens e se o token atual é igual ao token esperado
            index++;
            return true; //caso seja, incrementa o index e retorna true
        } else if (index >= tokens.size()) { //caso o index seja maior ou igual ao tamanho da lista de tokens
            throw SintException.endOfFileExpected(type); //lança uma exceção
        } else {
            throw SintException.expectedToken(type, tokens.get(index)); //caso o token atual nao seja igual ao token esperado, lança uma exceção
        }
    }

    //Programa → ':' 'DEC' ListaDeclaracoes ':' 'PROG' ListaComandos;
    public void Programa() {  //funcao que chama as outras funcoes para fazer a verificacao do programa
        if (index >= tokens.size() || !match(TokenType.Delim)) { //verifica se o token atual é Delim
            throw SintException.expectedToken(TokenType.Delim, tokens.get(index)); //caso nao seja, lança uma exceção
        }
        if (!match(TokenType.PCDec)) { //verifica se o token atual é PCDec
            throw SintException.unexpectedToken(tokens.get(index)); //
        }
        ListaDeclaracoes();
        if (!match(TokenType.Delim)) { //verifica se o token atual é Delim
            throw SintException.expectedToken(TokenType.Delim, tokens.get(index));
        }
        if (!match(TokenType.PCProg)) { //verifica se o token atual é PCProg
            throw SintException.unexpectedToken(tokens.get(index));
        }
        ListaComandos();
    }

    //*ListaDeclaracoes → Declaracao ListaDec;
    //ListDec  → Declaracao ListDec | E

    public void ListaDeclaracoes(){  //funcao que chama a declaracao e a lista de declaracoes
        Declaracao();
        ListaDec();
    }

    public void ListaDec(){ //funcao que verifica se tem mais declaracoes e evita os b.o de loop
        if(tokens.get(index).getType() == TokenType.Var){ //verifica se o token atual é Var
            Declaracao();
            ListaDec();
        }
    }

    //Declaracao → VARIAVEL ':' TipoVar;
    public void Declaracao(){  //funcao que verifica se a declaracao esta correta
        if(!match(TokenType.Var)) { //verifica se o token atual é Var
            throw SintException.unexpectedToken(tokens.get(index));
        }
        if(!match(TokenType.Delim)){ //verifica se o token atual é Delim
            throw SintException.expectedToken(TokenType.Delim, tokens.get(index));
        }
        TipoVar();
    }


    //TipoVar → 'INT' | 'REAL';
    public void TipoVar() { //funcao que verifica se o tipo da variavel esta correto
        if (tokens.get(index).getType() == TokenType.PCInt) { //verifica se o token atual é PCInt
            match(TokenType.PCInt);
        } else if (tokens.get(index).getType() == TokenType.PCReal) { //verifica se o token atual é PCReal
            match(TokenType.PCReal);
        } else { //caso nao seja nenhum dos dois, lança uma exceção
            throw SintException.unexpectedToken(tokens.get(index));
        }
    }


    //ExpressaoAritmetica → TermoAritmetico ExpressaoAritmeticaCont;
    public void ExpressaoAritmetica(){ //funcao que chama o termo aritmetico e a expressao aritmetica cont
        TermoAritmetico();
        ExpressaoAritmeticaCont();
    }

    //*ExpressaoAritmeticaCont → '+' TermoAritmetico ExpressaoAritmeticaCont
    //| '-' TermoAritmetico ExpressaoAritmeticaCont
    //| ε;

    public void ExpressaoAritmeticaCont(){  //funcao que verifica se tem mais expressoes aritmeticas e evita os b.o de loop
        if(tokens.get(index).getType() == TokenType.OpAritSoma){ //verifica se o token atual é OpAritSoma
            match(TokenType.OpAritSoma);
            TermoAritmetico();
            ExpressaoAritmeticaCont();
        }else if(tokens.get(index).getType() == TokenType.OpAritSub){ //verifica se o token atual é OpAritSub
            match(TokenType.OpAritSub);
            TermoAritmetico();
            ExpressaoAritmeticaCont();
        }
    }

    //TermoAritmetico → FatorAritmetico TermoAritmeticoCont;
    public void TermoAritmetico(){ //funcao que chama o fator aritmetico e o termo aritmetico cont
        FatorAritmetico();
        TermoAritmeticoCont();
    }

    //*TermoAritmeticoCont → '*' FatorAritmetico TermoAritmeticoCont
    //| '/' FatorAritmetico TermoAritmeticoCont
    //| ε;

    public void TermoAritmeticoCont(){ //funcao que verifica se tem mais termos aritmeticos e evita os b.o de loop
        if(tokens.get(index).getType() == TokenType.OpAritMult){ //verifica se o token atual é OpAritMult
            match(TokenType.OpAritMult);
            FatorAritmetico();
            TermoAritmeticoCont();
        }else if(tokens.get(index).getType() == TokenType.OpAritDiv){ //verifica se o token atual é OpAritDiv
            match(TokenType.OpAritDiv);
            FatorAritmetico();
            TermoAritmeticoCont();
        }
    }

    //FatorAritmetico → NUMINT| NUMREAL | VARIAVEL | '(' ExpressaoAritmetica ')';
    public void FatorAritmetico(){  //funcao que verifica se o fator aritmetico esta correto
        switch (tokens.get(index).getType()){ //verifica o tipo do token atual
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
                throw SintException.unexpectedToken(tokens.get(index)); //caso nao seja nenhum dos tipos acima, lança uma exceção
        }
    }

    //ExpressaoRelacional → TermoRelacional ExpressaoRelacionalCont;
    public void ExpressaoRelacional(){ //funcao que chama o termo relacional e a expressao relacional cont
        TermoRelacional();
        ExpressaoRelacionalCont();
    }
    //*ExpressaoRelacionalCont → OperadorBooleano TermoRelacional ExpressaoRelacionalCont
    //| ε;

    public void ExpressaoRelacionalCont(){ //funcao que verifica se tem mais expressoes relacionais e evita os b.o de loop
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
    public void TermoRelacional(){ //funcao que verifica se o termo relacional esta correto
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


    private boolean verificaOpRelacional(TokenType type) { //funcao que verifica se o token é um operador relacional pra nao ficar dando erro do termo relacional sem verificacao
        return type == TokenType.OpRelIgual ||
                type == TokenType.OpRelMaior ||
                type == TokenType.OpRelMenor ||
                type == TokenType.OpRelMaiorIgual ||
                type == TokenType.OpRelMenorIgual ||
                type == TokenType.OpRelDif;
    }

    //OperadorBooleano → 'E' | 'OU';

    public void OperadorBooleano(){ //funcao que verifica se o operador booleano esta correto
        if(tokens.get(index).getType() == TokenType.OpBoolE){
            match(TokenType.OpBoolE);
        }else if(tokens.get(index).getType() == TokenType.OpBoolOu){
            match(TokenType.OpBoolOu);
        }
    }

    //ListaComandos → Comando ListaComandos | Comando;
    public void ListaComandos() { //funcao que chama o comando e a lista de comandos
        while (index < tokens.size()) {
            if (tokens.get(index).getType() == TokenType.PCFim) {
                return; // finaliza o loop ao encontrar PCFim
            }
            Comando(); // processa os comandos
        }
    }

    //Comando → Atribuicao | Entrada | Saida | Condicao | Repeticao;
    public void Comando(){ //funcao que verifica qual comando esta sendo chamado
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

    public void Atribuicao(){  //funcao que verifica se a atribuicao esta correta
        match(TokenType.Var);
        match(TokenType.Atrib);
        ExpressaoAritmetica();
    }

    //ComandoEntrada → 'LER' VARIAVEL;

    public void Entrada(){ //funcao que verifica se a entrada esta correta
        match(TokenType.PCLer);
        match(TokenType.Var);
    }

    //ComandoSaida → 'IMPRIMIR'  VARIAVEL | 'IMPRIMIR' CADEIA;
    public void Saida(){ //funcao que verifica se a saida esta
        match(TokenType.PCImprimir);
        if(tokens.get(index).getType() == TokenType.Var){
            match(TokenType.Var);
        }else{
            match(TokenType.Cadeia);
        }
    }

    public void Condicao(){ //funcao que chama a expressao relacional e os comandos da condicao
        match(TokenType.PCSe);
        ExpressaoRelacional();
        match(TokenType.PCEntao);
        Comando();
        ComandoCondicaoCont();
    }

    public void ComandoCondicaoCont(){ //funcao que verifica se tem mais comandos na condicao e evita os b.o de loop
        if(tokens.get(index).getType() == TokenType.PCSenao){
            match(TokenType.PCSenao);
            Comando();
        }
    }

    //ComandoRepeticao → 'ENQTO' ExpressaoRelacional Comando;
    public void Repeticao(){ //funcao que chama a expressao relacional e o comando da repeticao
        match(TokenType.PCEnqto);
        ExpressaoRelacional();
        Comando();
    }

    //SubAlgoritmo → 'INI' ListaComandos 'FIM';
    public void SubAlgoritmo(){ //funcao que chama a lista de comandos do subalgoritmo
        if(index < tokens.size() && match(TokenType.PCIni)) { //verifica se o token atual é PCIni e verifica o proximo token
            ListaComandos(); //chama a lista de comandos
            if (index < tokens.size() && tokens.get(index).getType() == TokenType.PCFim) { //verifica se o token atual é PCFim
                match(TokenType.PCFim);
            } else {
                throw SintException.expectedToken(TokenType.PCFim, tokens.get(index - 1)); //caso o token atual nao seja PCFim, lança uma exceção
            }
        } else {
            throw SintException.expectedToken(TokenType.PCIni, tokens.get(index - 1)); //caso o token atual nao seja PCIni, lança uma exceção
        }
    }
}
