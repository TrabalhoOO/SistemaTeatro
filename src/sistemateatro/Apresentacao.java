package sistemateatro;
import java.io.*;
import java.util.Date;
import java.util.LinkedList;
public class Apresentacao {
	private int idApresentacao;
	private Date data;
	private Date horario;
	private double valorIngresso;
	private static int genID = 0;
	public Espetaculo fk_Espetaculo;
	public Sala fk_Sala;
	public LinkedList<Compra> compras = new LinkedList<Compra>();
}