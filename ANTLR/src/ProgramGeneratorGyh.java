import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class ProgramGeneratorGyh {
    private SymbolTable varTable;
    private ArrayList<Comando> comandos;

    public void setVarTable(SymbolTable varTable) {
        this.varTable = varTable;
    }

    public void setComandos(ArrayList<Comando> comandos) {
        this.comandos = comandos;
    }

    public ArrayList<Comando> getComandos() {
        return comandos;
    }

    public SymbolTable getVarTable() {
        return varTable;
    }

    public void generateTarget(){

        StringBuilder str = new StringBuilder();

        str.append("#include <stdio.h>\n");
        str.append("#include <stdlib.h>\n\n\n");
        str.append("int main(){\n\n");

        for(Symbol symbol : varTable.getAll()){
            if(symbol.getType().equals("INT")){
                str.append("\t").append("int ").append(symbol.getName()).append(" = ").append(symbol.getValue() != null ? symbol.getValue() : "0").append(";\n");
            } else if(symbol.getType().equals("REAL")) {
                str.append("\t").append("float ").append(symbol.getName()).append(" = ").append(symbol.getValue() != null ? symbol.getValue() : "0.0").append(";\n");
            }
        }
        str.append("\n\n");

        for(Comando c : comandos){
            System.out.println(c);
        }

        System.out.println("Comandos: " + comandos.size());

        for(Comando c : comandos){
            str.append("\t").append(c.generateCode()).append("\n");
        }

        str.append("return 0;\n");


        str.append("}");

        try {
            FileWriter file = new FileWriter(new File("target.c"));
            file.write(str.toString());
            file.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
