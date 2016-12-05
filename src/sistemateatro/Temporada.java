package sistemateatro;
import java.io.*;
import java.util.Date;
import java.util.LinkedList;

public class Temporada {
	private int _idTemporada;
	private static int _genID = 0;
	private Date _dataInicio;
	private Date _dataFim;
	public LinkedList<Espetaculo> _espetaculo = new LinkedList<Espetaculo>();
}