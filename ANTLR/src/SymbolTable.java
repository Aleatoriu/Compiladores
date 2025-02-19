import java.util.HashMap;
import java.util.LinkedList;

public class SymbolTable {
    private HashMap<String, Symbol> table;

    public SymbolTable() {
        this.table = new HashMap<String,Symbol>();
    }

    public HashMap<String, Symbol> getTable() {
        return table;
    }

    public void setTable(Symbol symbol) {
        this.table.put(symbol.getName(), symbol);
    }

    public Symbol getSymb(String symbol) {
        return table.get(symbol);
    }

    public boolean contains(String name) {
        return table.containsKey(name);
    }

    public Symbol get(String name) {
        if (!table.containsKey(name)) {
            throw new RuntimeException("Variável " + name + " não encontrada na tabela de símbolos.");
        }
        return table.get(name);
    }

    public void add(Symbol symbol) {
        if (table.containsKey(symbol.getName())) {
            throw new RuntimeException("Variável " + symbol.getName() + " já declarada.");
        }
        table.put(symbol.getName(), symbol);
    }

    public LinkedList<Symbol> getAll() {
        LinkedList<Symbol> list = new LinkedList<>();
        list.addAll(table.values());
        return list;
    }


    // Imprime todos os símbolos da tabela
    public void printTable() {
        table.forEach((key, value) -> System.out.println(value));
    }
}
