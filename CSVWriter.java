import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class CSVWriter {
    
    private String caminhoArquivo = "relatorio_hash.csv";

    public CSVWriter(){

    }

    public CSVWriter(String caminhoArquivo){
        this.caminhoArquivo = caminhoArquivo;
    }

    public void inserirNovoRegistro(Object... strings){

        try{

            PrintWriter pw = new PrintWriter(new FileWriter(caminhoArquivo,true));

            StringBuilder sb = new StringBuilder();

            int index = 0;

            for (Object string : strings) {
                
                sb.append(string);

                if(index + 1 < strings.length){

                    sb.append(',');

                } else {

                    sb.append("\r\n");

                }

                index++;

            }

            pw.write(sb.toString());
            pw.close();

        } catch (Exception ignore){

            System.out.println(ignore.getMessage());
            System.out.println(ignore.getStackTrace());

        }

    }


}
