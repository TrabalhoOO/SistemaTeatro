package sistemateatro;
import java.io.*;
import java.util.Date;
import java.util.LinkedList;
public class Compra {
	private int numeroReserva;
	private int assentoAdquiridos;
	private double valorTotal;
	private static int genID = 0;
	public Apresentacao fk_Apresentacao;
	public Pessoa fk_Pessoa;
	public FormadePagamentoCompra formadePagamentoCompra;
}