package sistemateatro;

import java.io.*;
import java.util.Date;
import java.util.LinkedList;

public class Artista implements Contavel {

    private int idArtista;
    private String nome;
    private Date dataNasc;
    private String CPF;
    private String RG;
    private String celular;
    private String email;
    private static final File arq = new File("Dados", "Artista.txt");
    public static final String UTF8_BOM = "\uFEFF";

    public int getIDArtista() {
        return idArtista;
    }

    public String getNome() {
        return nome;
    }

    public Long getDataNasc() {
        return this.dataNasc.getTime();
    }

    public String getCPF() {
        return CPF;
    }

    public String getRG() {
        return RG;
    }

    public String getCelular() {
        return celular;
    }

    public String getEmail() {
        return email;
    }

    public File getArq() {
        return arq;
    }

    public void setIDArtista(int idArtista) {
        this.idArtista = idArtista;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataNasc(Long dataNasc) {
        this.dataNasc = new Date(dataNasc);
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static Artista buscaID(int codigo) {
        Reader fileReader = null;
        boolean existe = arq.exists();
        Artista artista = null;
        try {
            if (existe) {
                fileReader = new FileReader(arq.getAbsolutePath());
                BufferedReader br = new BufferedReader(fileReader);
                String linha = br.readLine();
                while (linha != null) {
                    linha = Artista.removeUTF8BOM(linha);
                    if (!linha.equals("")) {
                        String[] dados = linha.split(";");

                        int id = Integer.parseInt(dados[0]);

                        if (id == codigo) {
                            artista = new Artista();
                            artista.setIDArtista(id);
                            artista.setNome(dados[1]);
                            artista.setDataNasc(Long.parseLong(dados[2]));
                            artista.setCPF(dados[3]);
                            artista.setRG(dados[4]);
                            artista.setCelular(dados[5]);
                            artista.setEmail(dados[6]);

                            return artista;
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
    
    public static String TransformarEmLinha(Artista artista) {
        String linha = Integer.toString(artista.getIDArtista())
                + ";"
                + artista.getNome()
                + ";"
                + artista.getDataNasc()
                + ";"
                + artista.getCPF()
                + ";"
                + artista.getRG()
                + ";"
                + artista.getCelular()
                + ";"
                + artista.getEmail()
                + ";";
        return linha;

    }

   private static String removeUTF8BOM(String s) {
        if (s.startsWith(UTF8_BOM)) {
            s = s.substring(1);
        }
        return s;
    }
}
