public class AtribuicaoCommand extends Comando{
    private String id;
    private String atribuicao;

        public AtribuicaoCommand(String id, String atribuicao) {
        this.id = id;
        this.atribuicao = atribuicao;
    }
    @Override
    public StringBuilder generateCode() {
        StringBuilder code = new StringBuilder();
        code.append(id + " = " + atribuicao + ";\n");
        return code;
    }

    public String getId() {
        return id;
    }

    public void setVarName(String id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "AtribuicaoCommand [id=" + id + ", atribuicao=" + atribuicao + "]";
    }

    public void setVarValue(String varExp) {
        this.atribuicao = varExp;
    }
}
