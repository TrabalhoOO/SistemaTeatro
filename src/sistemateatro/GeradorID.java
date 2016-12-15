package sistemateatro;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

/**
 *
 * @author jpdia
 */
public class GeradorID {

    /**
     *
     * @param contavel
     * @return
     */
    public int genID(Contavel contavel) {
        if(!contavel.getArq().exists())
        {
            try{
            contavel.getArq().createNewFile();
            }
            catch(IOException e)
            {
                System.out.println("Não foi possível criar o arquivo");
            }
        }
        File arquivo = contavel.getArq().getAbsoluteFile();
        long tamanho = arquivo.length();
        try {
            FileInputStream fs = new FileInputStream(arquivo);
            DataInputStream in = new DataInputStream(fs);
             LineNumberReader lineRead = new LineNumberReader(new InputStreamReader(in));
	    lineRead.skip(tamanho);
	    // conta o numero de linhas do arquivo, começa com zero, por isso adiciona 1
	    int numLinhas = lineRead.getLineNumber() + 1;
            return numLinhas;
        } catch (IOException e) {
            System.out.println(e+"Erro de leitura: " + arquivo.getName());
        }
        
        return -1;
    }
}
