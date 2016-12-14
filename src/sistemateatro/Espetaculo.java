package sistemateatro;

import java.io.*;
import java.util.Date;
import java.util.LinkedList;

/**
 *
 * @author jpdia
 */
public class Espetaculo implements Contavel {

    private int idEspetaculo;
    private String nome;
    private Date dataInicio;
    private Date dataFim;
    private String descricao;
    private int faixaEtaria;
    private int duracaoMinutos;
    private TipoEspetaculo fk_TipoDeEspetaculo;
    private LinkedList<Artista> fk_Artista = new LinkedList<Artista>();
    private static final File arq = new File("Dados", "Espetaculo.txt");
    private static final String UTF8_BOM = "\uFEFF";

    /**
     *
     * @return
     */
    public LinkedList<Artista> getFk_Artista() {
        return fk_Artista;
    }

    /**
     *
     * @param artista
     */
    public void setFk_Artista(Artista artista) {
        this.fk_Artista.add(artista);
    }

    /**
     *
     * @return
     */
    public Long getDataInicio() {
        return dataInicio.getTime();
    }

    /**
     *
     * @param dataInicio
     */
    public void setDataInicio(Long dataInicio) {
        this.dataInicio.setTime(dataInicio);
    }

    /**
     *
     * @return
     */
    public Long getDataFim() {
        return dataFim.getTime();
    }

    /**
     *
     * @param dataFim
     */
    public void setDataFim(Long dataFim) {
        this.dataFim.setTime(dataFim);
    }

    /**
     *
     * @return
     */
    public int getIdEspetaculo() {
        return idEspetaculo;
    }

    /**
     *
     * @param idEspetaculo
     */
    public void setIdEspetaculo(int idEspetaculo) {
        this.idEspetaculo = idEspetaculo;
    }

    /**
     *
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
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
     * @param descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     *
     * @return
     */
    public int getFaixaEtaria() {
        return faixaEtaria;
    }

    /**
     *
     * @param faixaEtaria
     */
    public void setFaixaEtaria(int faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }

    /**
     *
     * @return
     */
    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    /**
     *
     * @param duracaoMinutos
     */
    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }

    /**
     *
     * @return
     */
    public TipoEspetaculo getFk_TipoDeEspetaculo() {
        return fk_TipoDeEspetaculo;
    }

    /**
     *
     * @param fk_TipoDeEspetaculo
     */
    public void setFk_TipoDeEspetaculo(TipoEspetaculo fk_TipoDeEspetaculo) {
        this.fk_TipoDeEspetaculo = fk_TipoDeEspetaculo;
    }

    /**
     *
     * @return
     */
    @Override
    public File getArq() {
        return arq;

    }

    private static String removeUTF8BOM(String s) {
        if (s.startsWith(UTF8_BOM)) {
            s = s.substring(1);
        }
        return s;
    }

    /**
     *
     * @param codigo
     * @return
     */
    public static Espetaculo buscaID(int codigo) {
        Reader fileReader = null;
        boolean existe = arq.exists();
        Espetaculo espetaculo = null;
        try {
            if (existe) {
                fileReader = new FileReader(arq.getAbsolutePath());
                BufferedReader br = new BufferedReader(fileReader);
                String linha = br.readLine();
                espetaculo = new Espetaculo();
                while (linha != null) {
                    linha = Espetaculo.removeUTF8BOM(linha);
                    if (!(linha.equals(""))) {
                        String[] dados = linha.split(";");

                        int id = Integer.parseInt(dados[0]);

                        if (id == codigo) {
                            espetaculo.setIdEspetaculo(id);
                            espetaculo.setNome(dados[1]);
                            espetaculo.setDataInicio(Long.parseLong(dados[2]));
                            espetaculo.setDataFim(Long.parseLong(dados[3]));
                            espetaculo.setFaixaEtaria(Integer.parseInt(dados[4]));
                            espetaculo.setDuracaoMinutos(Integer.parseInt(dados[5]));
                            TipoEspetaculo tipoespetaculo = TipoEspetaculo.buscaID(Integer.parseInt(dados[6]));
                            if (tipoespetaculo != null) {
                                espetaculo.setFk_TipoDeEspetaculo(tipoespetaculo);
                            }
                            Artista artista = Artista.buscaID(Integer.parseInt(dados[7]));
                            espetaculo.setFk_Artista(artista);
                        }
                    }

                    linha = br.readLine();
                }
                return espetaculo;

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

    /**
     *
     * @return
     */
    public static LinkedList<Espetaculo> buscaTodos() {
        Reader fileReader = null;
        boolean existe = arq.exists();
        Espetaculo espetaculo = null;
        try {
            if (existe) {
                fileReader = new FileReader(arq.getAbsolutePath());
                BufferedReader br = new BufferedReader(fileReader);
                String linha = br.readLine();
                espetaculo = new Espetaculo();
                LinkedList<Espetaculo> lista =  new LinkedList<>();
                while (linha != null) {
                    linha = Espetaculo.removeUTF8BOM(linha);
                    if (!(linha.equals(""))) {
                        String[] dados = linha.split(";");

                        int id = Integer.parseInt(dados[0]);
                        espetaculo.setIdEspetaculo(id);
                        espetaculo.setNome(dados[1]);
                        espetaculo.setDataInicio(Long.parseLong(dados[2]));
                        espetaculo.setDataFim(Long.parseLong(dados[3]));
                        espetaculo.setFaixaEtaria(Integer.parseInt(dados[4]));
                        espetaculo.setDuracaoMinutos(Integer.parseInt(dados[5]));
                        TipoEspetaculo tipoespetaculo = TipoEspetaculo.buscaID(Integer.parseInt(dados[6]));
                        if (tipoespetaculo != null) {
                            espetaculo.setFk_TipoDeEspetaculo(tipoespetaculo);
                        }
                        Artista artista = Artista.buscaID(Integer.parseInt(dados[7]));
                        espetaculo.setFk_Artista(artista);
                        lista.add(espetaculo);
                    }
                    linha = br.readLine();
                }
                
                
             return lista;   
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
}
