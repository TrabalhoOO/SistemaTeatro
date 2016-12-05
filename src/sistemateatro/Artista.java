package sistemateatro;
import java.io.*;
import java.util.Date;
import java.util.LinkedList;

public class Artista {
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