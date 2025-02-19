grammar GrammarGyh;

@header {
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
}

@members{
    private String _varName;
    private String _varType;
    private String _varValue;
    private String _varExp = "";
    private String _conditional = "";
    private String _conditionalIf = "";
    private String _conditionalWhile = "";


    private ProgramGeneratorGyh program = new ProgramGeneratorGyh();
    private Symbol _varSymbol;
    private SymbolTable tableSymbol = new SymbolTable();


    private ArrayList<Comando> cmdList = new ArrayList<Comando>();
    private ArrayList<Comando> auxList = new ArrayList<Comando>();
    private ArrayList<Comando> listTrue = new ArrayList<Comando>();
    private ArrayList<Comando> listFalse = new ArrayList<Comando>();
    private ArrayList<Comando> listIf = new ArrayList<Comando>();
    private ArrayList<Comando> listWhile = new ArrayList<Comando>();
    private ArrayList<Comando> listElse = new ArrayList<Comando>();


    public void generateComando(){
        program.generateTarget();
    }

    public SymbolTable getTableSymbol(){
        return tableSymbol;
    }

    public void verificaVariavel(String varName) {
        if (!tableSymbol.contains(varName)) {
            throw new RuntimeException("Variável " + varName + " não declarada.");
        }
    }
}

programa: Delim PCDec listaDeclaracoes Delim PCProg {System.out.println("passeido prog");}listaComandos{System.out.println("tonalista");}
          {program.setVarTable(tableSymbol);
          System.out.println("Programa --->>> VarTabe");
          program.setComandos(cmdList);
          System.out.println("Programa --->>> Comandos");
          program.generateTarget();
          }EOF;

listaDeclaracoes: declaracao (listaDeclaracoes)?;

declaracao: Var Delim tipoVar{
             _varName = _input.LT(-3).getText();
             _varType = _input.LT(-1).getText();
             _varValue = null;
             _varSymbol = new Symbol(_varName, _varType, _varValue);
             if (!tableSymbol.contains(_varName)){
                    tableSymbol.add(_varSymbol);
                    System.out.println("Símbolo adicionado " + _varSymbol);
            } else {
                    System.out.println("Variável já declarada anteriormente: " + _varName);
            }

   };


tipoVar: PCInt | PCReal ;

expressaoAritmetica: termoAritmetico expressaoAritmeticaCount;


expressaoAritmeticaCount: (OpAritSom { if (!_varExp.isEmpty()) _varExp += "+"; }
                           termoAritmetico expressaoAritmeticaCount
                           | OpAritSub { if (!_varExp.isEmpty()) _varExp += "-"; }
                           termoAritmetico expressaoAritmeticaCount)?;


termoAritmetico: fatorAritmetico termoAritmeticoCount;

            termoAritmeticoCount: (OpAritMult {  if (!_varExp.isEmpty()) _varExp += "*"; }
                  fatorAritmetico termoAritmeticoCount
                              | OpAritDiv {  if (!_varExp.isEmpty()) _varExp += "/"; }
                              fatorAritmetico termoAritmeticoCount)?; //{ _condicao += " " + _varExp;};


            fatorAritmetico: NumInt { _varExp += _input.LT(-1).getText();}
                            | NumReal { _varExp += _input.LT(-1).getText();}
                            | Var { verificaVariavel(_input.LT(-1).getText()); _varExp += _input.LT(-1).getText(); }
                            | AbrePar { _varExp += "("; }expressaoAritmetica{ _varExp += ")"; }FechaPar;



expressaoRelacional: termoRelacional expressaoRelacionalCount;


expressaoRelacionalCount: (operadorBooleano {
    if (_input.LT(-1).getText().equals("E")) {
        _conditional += " && ";
    } else {
        _conditional += " || ";
    }
} termoRelacional expressaoRelacionalCount)?;




termoRelacional: {_varExp = "";}expressaoAritmetica{_conditional += _varExp;
                                    _varExp = "";
                                    }
                opRel {if(_input.LT(-1).getText().equals(">")){ _conditional += " > "; }
                       else if(_input.LT(-1).getText().equals("<")){ _conditional += " < "; }
                       else if(_input.LT(-1).getText().equals("==")){ _conditional += " == "; }
                       else if(_input.LT(-1).getText().equals("!=")){ _conditional += " != "; }
                       else if(_input.LT(-1).getText().equals(">=")){ _conditional += " >= "; }
                       else if(_input.LT(-1).getText().equals("<=")){ _conditional += " <= "; }
                      }
                expressaoAritmetica{_conditional += _varExp;
                                    _varExp = "";
                                    }| '('{
                                    _conditional += "(";}
                expressaoRelacional{_conditional += ")";}')';

operadorBooleano: 'E' | 'OU';


listaComandos: (comando { cmdList.addAll(auxList);auxList.clear();})+;


comando: comandoAtribuicao | comandoEntrada | comandoSaida | comandoCondicao | comandoRepeticao | subAlgoritmo;

comandoAtribuicao: {_conditional += _varExp;
                     _varExp = "";
                    }Var{_varName = _input.LT(-1).getText();
                    }Atrib expressaoAritmetica
                    {
                        verificaVariavel(_varName);

                        Symbol varSymbol = tableSymbol.get(_varName);
                        String expectedType = varSymbol.getType();

                        String expressionType = (_varExp.contains(".") ? "REAL" : "INT");

                        if (!expectedType.equals(expressionType)) {
                            throw new RuntimeException("Erro semântico: Tipos incompatíveis na atribuição de " + _varExp + " para " + _varName + " (" + expectedType + ").");
                        }
                        AtribuicaoCommand cmd = new AtribuicaoCommand(_varName,_varExp);
                        auxList.add(cmd);
                    };

comandoEntrada: PCLer Var {
        _varName = _input.LT(-1).getText();
        ReadCommand cmd = new ReadCommand(_varName,_varType);
        auxList.add(cmd);
        System.out.println("Comando de leitura: " + cmd);
};


comandoSaida: PCImprimir Var{
                             _varName = _input.LT(-1).getText();
                             WriteCommand cmd = new WriteCommand(_varName,_varType);
                             auxList.add(cmd);
                             System.out.println("Comando de escrita: " + cmd);
                            }
            | PCImprimir Cadeia{
            _varType = "Cadeia";
            _varName = _input.LT(-1).getText();
            WriteCommand cmd = new WriteCommand(_varName,_varType);
            System.out.println("Comando de escrita: " + cmd);
            auxList.add(cmd);
            };

comandoCondicao: PCSe {
                    _conditional = "";
                    System.out.println("spike is there");
                    listTrue.clear();
                    listFalse.clear();
                }
                expressaoRelacional{_conditionalIf = _conditional;}
                PCEntao
                comando {
                    listTrue.addAll(auxList);
                    listIf = new ArrayList<>(listTrue);
                    auxList.clear();
                    System.out.println("listaTrue preenchida: " + listTrue);
                    System.out.println("listaIf copiada: " + listIf);
                }
                (PCSenao comando {
                    listFalse.addAll(auxList);
                    listElse = new ArrayList<>(listFalse);
                    auxList.clear();
                    System.out.println("listaFalse preenchida: " + listFalse);
                    System.out.println("listaElse copiada: " + listElse);
                })?
                {
                    System.out.println("Final: listIf = " + listIf);
                    System.out.println("Final: listElse = " + listElse);


                    ConditionalCommand cmd = new ConditionalCommand(_conditionalIf,new ArrayList<>(listIf),new ArrayList<>(listElse));

                    auxList.add(cmd);
                };

comandoRepeticao: PCEnqto {
                    _conditional = "";
                    listWhile.clear();
                 }
                 expressaoRelacional
                 {_conditionalWhile = _conditional;}
                 comando {
                    listWhile.addAll(auxList);
                    auxList.clear();
                    System.out.println("Lista While preenchida: " + listWhile);
                 } {
                 {System.out.println("o que vem da condicao31231: " + _conditional);}
                    LoopCommand cmd = new  LoopCommand(_conditionalWhile, new ArrayList<>(listWhile));
                    auxList.add(cmd);
                 };



subAlgoritmo : PCIni (comando)+ PCFim;
opRel: OpRelMaior | OpRelMenor | OpRelIgual | OpRelDiferente | OpRelMaiorIgual | OpRelMenorIgual;

Delim: ':';

OpRelMaior: '>';
OpRelMenor: '<';
OpRelIgual: '==';
OpRelDiferente: '!=';
OpRelMaiorIgual: '>=';
OpRelMenorIgual: '<=';
Terminal: ';' -> skip;
OpBoolE: 'E';
OpBoolOU: 'OU';

PCDec: 'DEC';
PCInt: 'INT';
PCProg: 'PROG';
PCReal: 'REAL';
PCSe: 'SE';
PCEntao: 'ENTAO';
PCSenao: 'SENAO';
PCEnqto: 'ENQTO';
PCIni: 'INI';
PCFim: 'FIM';
PCImprimir: 'IMPRIMIR';
PCLer: 'LER';
Atrib: ':=';
AbrePar: '(';
FechaPar: ')';
OpAritSom: '+';
OpAritSub: '-';
OpAritMult: '*';
OpAritDiv: '/';



Var: [a-z] ([0-9] | [a-z] | [A-Z])*;
Cadeia:'"'([A-Z] | [a-z] | [0-9] | '!' | ' ' | '&')*'"';

NumInt: [0-9]+;
NumReal: [0-9]+'.'[0-9]*;

Coment: ('#' (~[\r\n])*) -> skip;

EspBranco:('\n' | '\t' | '\r' |' ')->skip;