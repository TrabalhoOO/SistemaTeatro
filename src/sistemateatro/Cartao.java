package sistemateatro;
import java.io.*;
import java.util.Date;
import java.util.LinkedList;
public class Cartao {
	private int idDetalheCartao;
	private String numeroCartao;
	private Date dataValidade;
	private static int genID = 0;
	public Compra fk_Compra;
}