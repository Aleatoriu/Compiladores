import java.util.ArrayList;
public class ConditionalCommand extends Comando {
    private String condition;
    private ArrayList<Comando> ifCommands;
    private ArrayList<Comando> elseCommands;

    public ConditionalCommand(String condition, ArrayList<Comando> ifCommands, ArrayList<Comando> elseCommands) {
        this.condition = condition;
        this.ifCommands = ifCommands;
        this.elseCommands = elseCommands;
    }

    @Override
    public StringBuilder generateCode() {
        StringBuilder str = new StringBuilder("if(" + condition + "){\n");
        System.out.println("IF COMMANDS: " + ifCommands);
        for(Comando c : ifCommands){
            str.append("\t\t").append(c.generateCode());
        }
        str.append("\t}");
        System.out.println("ELSE COMMANDS: " + elseCommands);
        if(!elseCommands.isEmpty()){
            str.append("else {\n");
            for(Comando c : elseCommands){
                str.append("\t\t").append(c.generateCode());
            }
            str.append("\n\t}");
        }
        return str;
    }

    public String getCondition() {
        return condition;
    }

    public void setConditional(String condition) {
        this.condition = condition;
    }



    public ArrayList<Comando> getIfCommands() {
        return ifCommands;
    }

    public void setIfCommands(ArrayList<Comando> ifCommands) {
        this.ifCommands = ifCommands;
    }

    public ArrayList<Comando> getElseCommands() {
        return elseCommands;
    }

    public void setElseCommands(ArrayList<Comando> elseCommands) {
        this.elseCommands = elseCommands;
    }

    public ArrayList<Comando> getListIf() {
        return ifCommands;
    }

    public ArrayList<Comando> getListElse() {
        return elseCommands;
    }


    @Override
    public String toString() {
        return "ConditionalCommand [condition=" + condition + ", ifCommands=" + ifCommands + ", elseCommands="
                + elseCommands + "]";
    }

    public void setListElse(ArrayList<Comando> elseCommands) {
        this.elseCommands = elseCommands;
    }

    public void setListIf(ArrayList<Comando> ifCommands) {
        this.ifCommands = ifCommands;
    }

}


