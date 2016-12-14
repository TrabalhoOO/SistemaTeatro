package sistemateatro;

import java.io.*;
import java.util.Date;
import java.util.LinkedList;

public class TipoEspetaculo implements Contavel {

    static TipoEspetaculo buscaID(int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    private int idTipoEspetaculo;
    private String nome;
    private String descricao;
    public Preferencia preferencia;
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

    public Preferencia getPreferencia() {
        return preferencia;
    }

    public void setPreferencia(Preferencia preferencia) {
        this.preferencia = preferencia;
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
                + ";"
                + tipoEspetaculo.getPreferencia()                
                + ";";
        return linha;

    }

}
