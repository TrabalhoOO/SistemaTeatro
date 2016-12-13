package sistemateatro;

import java.io.*;
import java.util.LinkedList;

public class Compra implements Contavel {

    private int numeroReserva;
    private LinkedList<Integer> assentos;
    private double valorTotal;
    private Apresentacao fk_Apresentacao;
    private Pessoa fk_Pessoa;
    private String numeroCartao;
    private String bandeiraCartao;
    private String datavalidade;
    private String numBoleto;
    
    private static final File arq = new File("Dados", "Compra.txt");
    public static final String UTF8_BOM = "\uFEFF";

    public int getNumeroReserva() {
        return numeroReserva;
    }

    public void setNumeroReserva(int numeroReserva) {
        this.numeroReserva = numeroReserva;
    }

    public LinkedList<Integer> getAssentos() {
        return assentos;
    }

    public void setAssentos(int assento) {
        this.assentos.add(assento);
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Apresentacao getFk_Apresentacao() {
        return fk_Apresentacao;
    }

    public void setFk_Apresentacao(Apresentacao fk_Apresentacao) {
        this.fk_Apresentacao = fk_Apresentacao;
    }

    public Pessoa getFk_Pessoa() {
        return fk_Pessoa;
    }

    public void setFk_Pessoa(Pessoa fk_Pessoa) {
        this.fk_Pessoa = fk_Pessoa;
    }

    
    
    public File getArq() {
        return arq;
    }

    public static LinkedList<Integer> totalAssentosComprados(int idSala) {
        Reader fileReader = null;
        boolean existe = arq.exists();
        Apresentacao apresentacao = null;
        LinkedList<Integer> listaAssento = new LinkedList<>();
        try {
            if (existe) {
                fileReader = new FileReader(arq.getAbsolutePath());
                BufferedReader br = new BufferedReader(fileReader);
                String linha = br.readLine();
                while (linha != null) {
                    linha = Compra.removeUTF8BOM(linha);
                    if (!(linha.equals(""))) {
                        String[] dados = linha.split(";");
                        int idApresentacao = Integer.parseInt(dados[3]);
                        apresentacao = Apresentacao.buscaID(idApresentacao);
                        int sala = apresentacao.getFk_Sala().getIdSala();
                        if (idSala == sala) {
                            listaAssento.add(Integer.parseInt(dados[1]));
                        }
                    }
                    linha = br.readLine();
                }
                return listaAssento;
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
