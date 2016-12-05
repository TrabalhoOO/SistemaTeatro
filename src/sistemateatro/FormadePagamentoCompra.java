package sistemateatro;
import java.io.*;
import java.util.Date;
import java.util.LinkedList;
public class FormadePagamentoCompra {
	private int idFormaCompra;
	private double valorTotalPago;
	private static int genID = 0;
	public FormaPagamento fk_FormaPagamento;
	public Compra fk_Compra;
	public DetalhesCartao detalhesCartao;
}