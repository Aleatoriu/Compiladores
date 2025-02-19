import java.util.ArrayList;

public class LoopCommand extends Comando {
    private String condition;
    private ArrayList<Comando> commandsLoop = new ArrayList<>();

    public LoopCommand(String condition, ArrayList<Comando> commandsLoop) {
        this.condition = condition;
        this.commandsLoop = commandsLoop;
    }


    @Override
    public StringBuilder generateCode() {
        System.out.println("LOOP COMMANDS: " + commandsLoop);
        System.out.println("CONDITION: " + condition);
        StringBuilder str = new StringBuilder("while(" + condition + "){\n");
        for(Comando c : commandsLoop){
            str.append("\t\t").append(c.generateCode());
        }
        str.append("\t}");
        return str;
    }


    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public ArrayList<Comando> getCommandsLoop() {
        return commandsLoop;
    }

    public void setCommandsLoop(ArrayList<Comando> commandsLoop) {
        this.commandsLoop = commandsLoop;
    }
    @Override
    public String toString() {
        return "LoopCommand [condition=" + condition + ", commandsLoop=" + commandsLoop + "]";
    }
}
