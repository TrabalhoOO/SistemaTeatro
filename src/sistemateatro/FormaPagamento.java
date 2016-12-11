package sistemateatro;

import java.io.*;
import java.util.LinkedList;

public class FormaPagamento {

    private int idForma;
    private String descricao;
    private static final File arq = new File("Dados", "FormaPagamento.txt");
    public static final String UTF8_BOM = "\uFEFF";

    public static LinkedList<FormaPagamento> buscaTodos() {
        Reader fileReader = null;
        boolean existe = arq.exists();
        FormaPagamento formapagamento = null;
        LinkedList lista = new LinkedList();
        try {
            if (existe) {
                fileReader = new FileReader(arq.getAbsolutePath());
                BufferedReader br = new BufferedReader(fileReader);
                String linha = br.readLine();
                while (linha != null) {
                    linha = FormaPagamento.removeUTF8BOM(linha);
                    if (!(linha.equals(""))) {

                        String[] dados = linha.split(";");

                        formapagamento = new FormaPagamento();
                        formapagamento.setIdForma(Integer.parseInt(dados[0]));
                        formapagamento.setDescricao(dados[1]);
                        lista.add(formapagamento);
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
    private static String removeUTF8BOM(String s) {
        if (s.startsWith(UTF8_BOM)) {
            s = s.substring(1);
        }
        return s;
    }

    public int getIdForma() {
        return idForma;
    }

    public void setIdForma(int idForma) {
        this.idForma = idForma;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
