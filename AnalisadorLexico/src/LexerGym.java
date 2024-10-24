import java.util.ArrayList;
import java.util.List;
//se eu tivesse feito em python tava melhor essa merda de java de bosta essas funcao fica BUGANDO NESSA MERDA
public class LexerGym {
    public ArchiveReader reader;
    public String currentLine;
    public int currentLineNumber;
    public int currentPosition;

    public LexerGym(String arqName) {
        this.reader = new ArchiveReader(arqName);
        this.currentLine = reader.readNextLine();
        this.currentLineNumber = 1;
        this.currentPosition = 0;
    }

    public List<Token> nextToken() {
        List<Token> tokens = new ArrayList<>();
        while (currentLine != null) {  //esse while percorre todas as linhas do arquivo
            while (currentPosition < currentLine.length()) { //esse aqui já percorre os caracteres de cada linha
                char currentChar = currentLine.charAt(currentPosition); // define o caractere atual
                switch (currentChar) { //inicia a verificação do caractere atual pra definir o token
                    case ' ':
                        currentPosition++;
                        break;
                    case '+':
                        tokens.add(new Token(TokenType.OpAritSoma, "+", currentLineNumber));
                        currentPosition++;
                        break;
                    case '-':
                        tokens.add(new Token(TokenType.OpAritSub, "-", currentLineNumber));
                        currentPosition++;
                        break;
                    case '*':
                        tokens.add(new Token(TokenType.OpAritMult, "*", currentLineNumber));
                        currentPosition++;
                        break;
                    case '/':
                        tokens.add(new Token(TokenType.OpAritDiv, "/", currentLineNumber));
                        currentPosition++;
                        break;
                    case '(':
                        tokens.add(new Token(TokenType.AbrePar, "(", currentLineNumber));
                        currentPosition++;
                        break;
                    case ')':
                        tokens.add(new Token(TokenType.FechaPar, ")", currentLineNumber));
                        currentPosition++;
                        break;
                    case ':':
                        if (currentPosition + 1 < currentLine.length() && currentLine.charAt(currentPosition + 1) == '=') {
                            tokens.add(new Token(TokenType.Atrib, ":=", currentLineNumber));
                            currentPosition += 2;
                        } else {
                            tokens.add(new Token(TokenType.Delim, ":", currentLineNumber));
                            currentPosition++;
                        }
                        break;
                    case '<':
                        if (currentPosition + 1 < currentLine.length() && currentLine.charAt(currentPosition + 1) == '=') {
                            tokens.add(new Token(TokenType.OpRelMenorIgual, "<=", currentLineNumber));
                            currentPosition += 2;
                        } else {
                            tokens.add(new Token(TokenType.OpRelMenor, "<", currentLineNumber));
                            currentPosition++;
                        }
                        break;
                    case '>':
                        if (currentPosition + 1 < currentLine.length() && currentLine.charAt(currentPosition + 1) == '=') {
                            tokens.add(new Token(TokenType.OpRelMaiorIgual, ">=", currentLineNumber));
                            currentPosition += 2;
                        } else {
                            tokens.add(new Token(TokenType.OpRelMaior, ">", currentLineNumber));
                            currentPosition++;
                        }
                        break;
                    case '=':
                        if (currentPosition + 1 < currentLine.length() && currentLine.charAt(currentPosition + 1) == '=') {
                            tokens.add(new Token(TokenType.OpRelIgual, "==", currentLineNumber));
                            currentPosition += 2;
                        } else {
                            throw LexerEceptions.invalidCharacter(currentChar,currentLineNumber);
                        }
                        break;
                    case '!':
                        if (currentPosition + 1 < currentLine.length() && currentLine.charAt(currentPosition + 1) == '=') {
                            tokens.add(new Token(TokenType.OpRelDif, "!=", currentLineNumber));
                            currentPosition += 2;
                        } else {
                            throw LexerEceptions.invalidCharacter(currentChar, currentLineNumber);
                        }
                        break;
                    case '"':
                        int start = currentPosition;
                        currentPosition++;
                        while (currentPosition < currentLine.length() && currentLine.charAt(currentPosition) != '"') {
                            currentPosition++;
                        }
                        if (currentPosition < currentLine.length()) {
                            String strValue = currentLine.substring(start, currentPosition + 1);
                            tokens.add(new Token(TokenType.Cadeia, strValue, currentLineNumber));
                            currentPosition++;
                        } else {
                            throw LexerEceptions.invalidToken(currentLine.substring(start), currentLineNumber);
                        }
                        break;
                    case '#':
                        currentPosition = currentLine.length();
                        break;
                    default:  // deixei o default para os casos de números e identificadores pq se colocar ali em cima fica muito grande fazer as verificoes e aqui fica mais limpo nessa merda
                        if (Character.isDigit(currentChar)) {
                            start = currentPosition;
                            while (currentPosition < currentLine.length() && Character.isDigit(currentLine.charAt(currentPosition))) {
                                currentPosition++;
                            }
                            if (currentPosition < currentLine.length() && currentLine.charAt(currentPosition) == '.') {
                                currentPosition++;
                                while (currentPosition < currentLine.length() && Character.isDigit(currentLine.charAt(currentPosition))) {
                                    currentPosition++;
                                }
                                tokens.add(new Token(TokenType.NumReal, currentLine.substring(start, currentPosition), currentLineNumber));
                            } else {
                                tokens.add(new Token(TokenType.NumInt, currentLine.substring(start, currentPosition), currentLineNumber));
                            }
                        } else if (Character.isLetter(currentChar)) {
                            start = currentPosition;
                            while (currentPosition < currentLine.length() && (Character.isLetterOrDigit(currentLine.charAt(currentPosition)) || currentLine.charAt(currentPosition) == '_')) {
                                currentPosition++;
                            }
                            String lexeme = currentLine.substring(start, currentPosition);
                            switch (lexeme) {
                                case "DEC":
                                    tokens.add(new Token(TokenType.PCDec, lexeme, currentLineNumber));
                                    break;
                                case "PROG":
                                    tokens.add(new Token(TokenType.PCProg, lexeme, currentLineNumber));
                                    break;
                                case "INT":
                                    tokens.add(new Token(TokenType.PCInt, lexeme, currentLineNumber));
                                    break;
                                case "REAL":
                                    tokens.add(new Token(TokenType.PCReal, lexeme, currentLineNumber));
                                    break;
                                case "LER":
                                    tokens.add(new Token(TokenType.PCLer, lexeme, currentLineNumber));
                                    break;
                                case "IMPRIMIR":
                                    tokens.add(new Token(TokenType.PCImprimir, lexeme, currentLineNumber));
                                    break;
                                case "SE":
                                    tokens.add(new Token(TokenType.PCSe, lexeme, currentLineNumber));
                                    break;
                                case "ENTAO":
                                    tokens.add(new Token(TokenType.PCEntao, lexeme, currentLineNumber));
                                    break;
                                case "ENQTO":
                                    tokens.add(new Token(TokenType.PCEnqto, lexeme, currentLineNumber));
                                    break;
                                case "INI":
                                    tokens.add(new Token(TokenType.PCIni, lexeme, currentLineNumber));
                                    break;
                                case "FIM":
                                    tokens.add(new Token(TokenType.PCFim, lexeme, currentLineNumber));
                                    break;
                                case "OU" :
                                    tokens.add(new Token(TokenType.OpBoolOu, lexeme, currentLineNumber));
                                    break;
                                case "E":
                                    tokens.add(new Token(TokenType.OpBoolE, lexeme, currentLineNumber));
                                    break;

                                default:
                                    if(Character.isUpperCase(lexeme.charAt(0))){
                                        throw LexerEceptions.invalidKeyword(lexeme, currentLineNumber);
                                    }else{
                                    tokens.add(new Token(TokenType.Var, lexeme, currentLineNumber));
                                    }
                                    break;
                            }
                        break;
                        } else {
                            throw new LexerEceptions("Erro léxico na linha " + currentLineNumber + ": " + currentChar); //tratamento de erro generico pq to com preguiça de fazer um pra cada caractere
                        }// se nao ia virar um if else do tamanho da minha cabeça e mo pregs
                }
            }
            currentLine = reader.readNextLine(); // continua ate essa bomba comecar a dar tudo errado e eu nao saber onde é
            currentLineNumber++;
            currentPosition = 0;
        }
        return tokens;
    }
}
