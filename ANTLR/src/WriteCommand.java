public class WriteCommand extends Comando {
    private String id;         // Nome da variável ou mensagem
    private String type;       // Tipo da variável (int, double, etc.)


    public WriteCommand(String id, String type) {
        this.id = id;
        this.type = type;
    }


    @Override
    public StringBuilder generateCode() {
        StringBuilder str = new StringBuilder();
        switch (type) {
            case "INT":
                str.append("printf(\"%d\", ").append(id).append(");");
                break;
            case "REAL":
                str.append("printf(\"%f\", ").append(id).append(");");
                break;
            case "Cadeia":
                str.append("printf(").append(id).append(");");
                break;
            default:
                throw new RuntimeException("Tipo desconhecido: " + type);
        }

        return str;
    }


    // Getters e Setters
    public String getId() {
        return id;
    }

    public void setVarValue(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setVarType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "WriteCommand [id=" + id + ", type=" + type + "]";
    }
}
