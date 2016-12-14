
package sistemateatro;

import java.io.*;

public class TipoEspetaculo implements Contavel {

    static TipoEspetaculo buscaID(int codigo) {
        Reader fileReader = null;
        boolean existe = arq.exists();
        Espetaculo espetaculo = null;
        try {
            if (existe) {
                fileReader = new FileReader(arq.getAbsolutePath());
                BufferedReader br = new BufferedReader(fileReader);
                String linha = br.readLine();
                TipoEspetaculo tipoespetaculo = new TipoEspetaculo();
                while (linha != null) {
                    linha = TipoEspetaculo.removeUTF8BOM(linha);
                    if (!(linha.equals(""))) {
                        String[] dados = linha.split(";");

                        int id = Integer.parseInt(dados[0]);

                        if (id == codigo) {
                            tipoespetaculo.setIdTipoEspetaculo(Integer.parseInt(dados[0]));
                            tipoespetaculo.setNome(dados[1]);
                            tipoespetaculo.setNome(dados[0]);
                        }
                    }

                    linha = br.readLine();
                }
                return tipoespetaculo;

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
    

    
    private int idTipoEspetaculo;
    private String nome;
    private String descricao;
    private static final File arq = new File("Dados", "TipoEspetaculo.txt");
    public static final String UTF8_BOM = "\uFEFF";

    public int getIdTipoEspetaculo() {
        return idTipoEspetaculo;
    }

    public void setIdTipoEspetaculo(int idTipoEspetaculo) {
        this.idTipoEspetaculo = idTipoEspetaculo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    @Override
    public File getArq() {
        return arq;
    }
    
    static String TransformarEmLinha(TipoEspetaculo tipoEspetaculo) {
        String linha = Integer.toString(tipoEspetaculo.getIdTipoEspetaculo())
                + ";"
                + tipoEspetaculo.getNome()
                + ";"
                + tipoEspetaculo.getDescricao()
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
