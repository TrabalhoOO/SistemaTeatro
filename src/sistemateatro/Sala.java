package sistemateatro;

import java.io.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jpdia
 */
public class Sala implements Contavel {

    private int idSala;
    private String descricao;
    private int totalAssentos;
    private int totalFileira;

    /**
     *
     */
    public Apresentacao fk_apresentacao;

    /**
     *
     */
    public LinkedList<Integer> assentosComprados = new LinkedList<Integer>();
    private static final File arq = new File("Dados", "Sala.txt");

    /**
     *
     */
    public static final String UTF8_BOM = "\uFEFF";

    /**
     *
     * @return
     */
    public File getArq() {
        return arq;
    }

    /**
     *
     * @return
     */
    public int getIdSala() {
        return idSala;
    }

    /**
     *
     * @return
     */
    public Apresentacao getFk_Apresentacao() {
        return fk_apresentacao;
    }

    /**
     *
     * @return
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     *
     * @return
     */
    public int getTotalFileira() {
        return totalFileira;
    }

    /**
     *
     * @return
     */
    public int getTotalAssentos() {
        return totalAssentos;
    }

    /**
     *
     * @param idSala
     */
    public void setIDSala(int idSala) {
        this.idSala = idSala;
    }

    /**
     *
     * @param descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     *
     * @param totalFileiras
     */
    public void setTotalFileira(int totalFileiras) {
        this.totalFileira = totalFileiras;
    }

    /**
     *
     * @param totalAssentos
     */
    public void setTotalAssentos(int totalAssentos) {
        this.totalAssentos = totalAssentos;
    }

    /**
     *
     * @param assentosComprados
     */
    public void setAssentosComprados(LinkedList<Integer> assentosComprados) {
        this.assentosComprados.addAll(assentosComprados);
    }

    /**
     *
     * @param assentosComprados
     */
    public void setAssentosComprados(int assentosComprados) {
        this.assentosComprados.add(assentosComprados);
    }

    /**
     *
     * @param fk_apresentacao
     */
    public void setFk_Apresentacao(Apresentacao fk_apresentacao) {
        this.fk_apresentacao = fk_apresentacao;
    }

    /**
     *
     * @param codigo
     * @return
     */
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
                            sala.setDescricao(dados[2]);
                            sala.setTotalAssentos(Integer.parseInt(dados[3]));
                            sala.setAssentosComprados(Compra.totalAssentosComprados(id));
                            sala.setTotalFileira(Integer.parseInt(dados[4]));

                            return sala;
                        }
                    }
                    linha = br.readLine();
                }
            }

        } catch (IOException e) {
            System.out.println("Não foi possível alterar o arquivo");
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Não foi possível alterar o arquivo");
            }
        }
        return null;
    }

    private static String removeUTF8BOM(String s) {
        if (s.startsWith(UTF8_BOM)) {
            s = s.substring(1);
        }
        return s;
    }

    /**
     *
     */
    public void exibirVagas() {
        for (int i = 0; i < (this.totalAssentos / this.totalFileira); i++) {
            for (int j = 0; j < this.totalFileira; j++) {
                if (this.assentosComprados.contains(i)) {
                    System.out.println("X\t");
                } else {
                    System.out.println(i + "\t");
                }
            }
            System.out.print("\n");
        }
    }

    /**
     *
     * @param assento
     * @return
     */
    public boolean HaVaga(int assento) {
        return this.assentosComprados.contains(assento);
    }

    /**
     *
     * @param sala
     * @return
     */
    public static String TransformarEmLinha(Sala sala) {
        String linha = Integer.toString(sala.getIdSala())
                + ";"
                + sala.getIdSala()
                + ";"
                + sala.getFk_Apresentacao().getIdApresentacao()
                + ";"
                + sala.getDescricao()
                + ";"
                + sala.getTotalAssentos()
                + ";"
                + sala.getTotalFileira()
                + ";";
        return linha;

    }
}
