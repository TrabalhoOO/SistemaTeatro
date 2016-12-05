package sistemateatro;
import java.io.*;
import java.util.Date;
import java.util.LinkedList;

public class TipoEspetaculo {
	private int idTipoEspetaculo;
	private static int genID = 0;
	private String descricao;
	public Preferencia preferencia;
	public LinkedList<Espetaculo> espetaculo = new LinkedList<Espetaculo>();
}