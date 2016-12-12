package sistemateatro;

import java.io.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sala {

    static boolean HaVaga(int Assento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    static void ExibirVagas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private int idSala;
    private String descricao;
    private int totalAssentos;
    private int totalFileira;
    private static int genID = 0;
    public Apresentacao fk_apresentacao;
    private static final File arq = new File("Dados", "Sala.txt");
    public static final String UTF8_BOM = "\uFEFF";

    public int getIdSala() {
        return idSala;
    }

    private void setIDSala(int idSala) {
        this.idSala = idSala;
    }

    private void setFk_Apresentacao(Apresentacao fk_apresentacao) {
        this.fk_apresentacao = fk_apresentacao;
    }

    public static Sala buscaID(int codigo) {
        Reader fileReader = null;
        boolean existe = arq.exists();
        Sala sala = null;
        try {
            if (existe) {
                fileReader = new FileReader(arq.getAbsolutePath());
                BufferedReader br = new BufferedReader(fileReader);
                String linha = br.readLine();
                while (linha != null) {
                    linha = Sala.removeUTF8BOM(linha);
                    if (!linha.equals("")) {
                        String[] dados = linha.split(";");

                        int id = Integer.parseInt(dados[0]);

                        if (id == codigo) {
                            sala = new Sala();
                            sala.setIDSala(id);
                            Apresentacao apresentacao = Apresentacao.buscaID(Integer.parseInt(dados[1]));
                            if (apresentacao != null) {
                                sala.setFk_Apresentacao(apresentacao);
                            }
                            sala.setDescricao()
                            
                        }
                    }
                }
            }

        } catch (IOException ex) {
            System.out.println("Não foi possível alterar o arquivo");
        }

    }

    private static String removeUTF8BOM(String s) {
        if (s.startsWith(UTF8_BOM)) {
            s = s.substring(1);
        }
        return s;
    }
}
