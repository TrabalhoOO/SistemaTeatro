package sistemateatro;
import java.io.*;
import java.util.Date;
import java.util.LinkedList;

/**
 *
 * @author jpdia
 */
public class TipoEspetaculo {

    static TipoEspetaculo buscaID(int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	private int idTipoEspetaculo;
	private static int genID = 0;
	private String descricao;

    /**
     *
     */
    public Preferencia preferencia;

    /**
     *
     */
    public LinkedList<Espetaculo> espetaculo = new LinkedList<Espetaculo>();
}