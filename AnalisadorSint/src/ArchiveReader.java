import java.io.*;

public class ArchiveReader {
    private BufferedReader reader; //essa porra aqui é o buffer pra nao fazer merda e ler de 1 em 1

    public ArchiveReader(String arqName) {
        try {
            this.reader = new BufferedReader(new FileReader(arqName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String readNextLine() { //essa porra aqui é pra ler a proxima linha
        String line = null;

        try {
            line = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }


}
