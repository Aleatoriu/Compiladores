public class Symbol {
    private String name;
    private String type;
    private String value;


    public Symbol(String name, String type, String value) {
        this.name = name;
        this.type = type;
        this.value = value;
    }

    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }


    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Symbol [name=" + this.getName() + ", type=" + this.getType() + ", value=" + this.getValue() + "]";
    }
}
