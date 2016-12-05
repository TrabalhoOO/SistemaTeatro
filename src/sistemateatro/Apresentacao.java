package sistemateatro;
import java.io.*;
import java.util.Date;
public class Apresentacao {
	private int _idApresentacao;
	private Date _data;
	private Date _horario;
	private double _valorIngresso;
	private static int _genID = 0;
	public Espetaculo _fk_Espetaculo;
	public Sala _fk_Sala;
	public Compra _compra;
}