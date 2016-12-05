package sistemateatro;
import java.io.*;
import java.util.Date;
import java.util.LinkedList;
public class Preferencia {
	private int idPreferencia;
	private static int genID = 0;
	public TipoEspetaculo fk_TipoDeEspetaculo;
	public Pessoa fk_Pessoa;
}