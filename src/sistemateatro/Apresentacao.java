package sistemateatro;

import java.io.*;
import java.util.Date;
import java.util.LinkedList;

public class Apresentacao implements Contavel {

    private int idApresentacao;
    private Date data;
    private Date horario;
    private double valorIngresso;
    private Espetaculo fk_Espetaculo;
    private Sala fk_Sala;
    public LinkedList<Compra> compras = new LinkedList<Compra>();
    private static final File arq = new File("Dados", "Apresentacao.txt");
    private static final File arqEspetaculo = new File("Dados", "Espetaculo.txt");
    private static final File arqSala = new File("Dados", "Sala.txt");
    public static final String UTF8_BOM = "\uFEFF";

    @Override
    public File getArq() {
        return arq;

    }

    public int getIdApresentacao() {
        return idApresentacao;
    }

    public void setIdApresentacao(int idApresentacao) {
        this.idApresentacao = idApresentacao;
    }

    public Long getData() {
        return this.data.getTime();
    }

    public void setData(Long tempo) {
        this.data = new Date(tempo);
    }

    public Long getHorario() {
        return this.horario.getTime();
    }

    public void setHorario(Long tempo) {
        this.horario = new Date(tempo);
    }

    public double getValorIngresso() {
        return valorIngresso;
    }

    public void setValorIngresso(double valorIngresso) {
        this.valorIngresso = valorIngresso;
    }

    public Espetaculo getFk_Espetaculo() {
        return fk_Espetaculo;
    }

    public void setFk_Espetaculo(Espetaculo fk_Espetaculo) {
        this.fk_Espetaculo = fk_Espetaculo;
    }

    public Sala getFk_Sala() {
        return fk_Sala;
    }

    public void setFk_Sala(Sala fk_Sala) {
        this.fk_Sala = fk_Sala;
    }

    public LinkedList<Compra> getCompras() {
        return compras;
    }

    public void setCompras(LinkedList<Compra> compras) {
        this.compras = compras;
    }

    public static String TransformarEmLinha(Apresentacao apresentacao) {
        String linha = Integer.toString(apresentacao.getIdApresentacao())
                + ";"
                + apresentacao.getIdApresentacao()
                + ";"
                + apresentacao.getFk_Sala().getIdSala()
                + ";"
                + apresentacao.getFk_Espetaculo().getIdEspetaculo()
                + ";"
                + apresentacao.getData()
                + ";"
                + apresentacao.getHorario()
                + ";"
                + apresentacao.getValorIngresso()
                + ";";
        return linha;

    }

    public static Apresentacao buscaID(int codigo) {
        Reader fileReader = null;
        boolean existe = arq.exists();
        Apresentacao apresentacao = null;
        try {
            if (existe) {
                fileReader = new FileReader(arq.getAbsolutePath());
                BufferedReader br = new BufferedReader(fileReader);
                String linha = br.readLine();
                while (linha != null) {
                    linha = Apresentacao.removeUTF8BOM(linha);
                    if (!(linha.equals(""))) {
                        String[] dados = linha.split(";");
                        int id = Integer.parseInt(dados[0]);

                        if (id == codigo) {
                            apresentacao.setIdApresentacao(id);
                            Sala sala = Sala.buscaID(dados[1]);
                            if (sala != null) {
                                apresentacao.setFk_Sala(sala);
                            }
                            Espetaculo espetaculo = Espetaculo.buscaID(dados[2]);
                            if (espetaculo != null) {
                                apresentacao.setFk_Espetaculo(espetaculo);
                            }
                            apresentacao.setData(Long.parseLong(dados[3]));
                            apresentacao.setHorario(Long.parseLong(dados[4]));
                            apresentacao.setValorIngresso(Double.parseDouble(dados[5]));

                            return apresentacao;
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
}
