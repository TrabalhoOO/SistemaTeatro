package sistemateatro;

import java.io.*;
import java.util.Date;
import java.util.LinkedList;

public class Preferencia implements Contavel {

    private int idPreferencia;
    public TipoEspetaculo fk_TipoDeEspetaculo;
    public Pessoa fk_Pessoa;
    private static final File arq = new File("Dados", "Preferencia.txt");
    public static final String UTF8_BOM = "\uFEFF";

    public int getIdPreferencia() {
        return idPreferencia;
    }

    public void setIdPreferencia(int id) {
        this.idPreferencia = id;
    }

    public TipoEspetaculo getFk_TipoDeEspetaculo() {
        return fk_TipoDeEspetaculo;
    }

    public void setFk_TipoDeEspetaculo(TipoEspetaculo fk_TipoDeEspetaculo) {
        this.fk_TipoDeEspetaculo = fk_TipoDeEspetaculo;
    }

    public Pessoa getFk_Pessoa() {
        return fk_Pessoa;
    }

    public void setFk_Pessoa(Pessoa fk_Pessoa) {
        this.fk_Pessoa = fk_Pessoa;
    }

    @Override
    public File getArq() {
        return arq;
    }

    public static String removeUTF8BOM(String s) {
        if (s.startsWith(UTF8_BOM)) {
            s = s.substring(1);
        }
        return s;
    }

}