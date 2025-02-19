public class ReadCommand extends Comando{
    private String id;
    private String type;

    public ReadCommand(String id, String type) {
        this.id = id;
        this.type = type;
        System.out.println(id);
        System.out.println(type);
    }

    @Override
    public StringBuilder generateCode() {
        StringBuilder str = new StringBuilder();
        switch (type) {
            case "INT":
                str.append("scanf(\"%d\", &" + id + ");");
                break;
            case "REAL":
                str.append("scanf(\"%f\", &" + id + ");");
                break;
            default:
                throw new RuntimeException("Tipo desconhecido: " + type);
        }
        return str;
    }


    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ReadCommand [id=" + id + ", type=" + type + "]";
    }
}
