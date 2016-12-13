package sistemateatro;
import java.io.*;
import java.util.Date;
import java.util.LinkedList;

public class Artista {

    static Artista buscaID(int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	private int idArtista;
	private static int genID = 0;
	private String nome;
	private Date dataNasc;
	private String CPF;
	private String RG;
	private String celular;
	private String email;
	public LinkedList<Espetaculo> fk_Espetaculo = new LinkedList<Espetaculo>();
}