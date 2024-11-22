public enum TokenType { //aqui é o enum que representa os tipos de tokens que o lexer reconhece
    PCDec, PCProg, PCInt, PCReal, PCLer,
    PCImprimir, PCSe,PCSenao, PCEntao, PCEnqto, PCIni, PCFim,
    OpAritMult, OpAritDiv, OpAritSoma, OpAritSub, OpRelMenor, OpRelMenorIgual,
    OpRelMaior, OpRelMaiorIgual, OpRelIgual, OpRelDif,
    OpBoolE, OpBoolOu, Delim, Atrib, AbrePar, FechaPar,
    Var, NumInt,NumReal, Cadeia
} //sao os tokens que o lixo dessa disgraça tao reconhecendo e eu acho q ta tudo ai se nao tiver fudeu
