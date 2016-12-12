package sistemateatro;
import java.io.*;
import java.util.Date;
import java.util.LinkedList;
public class Preferencia {
	private int idPreferencia;
	public TipoEspetaculo fk_TipoDeEspetaculo;
	public LinkedList<Pessoa> fk_Pessoa;
}