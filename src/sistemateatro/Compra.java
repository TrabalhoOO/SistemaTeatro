package sistemateatro;
import java.io.*;
import java.util.Date;
import java.util.LinkedList;
public class Compra {
	private int numeroReserva;
	private int assentoAdquiridos;
	private double valorTotal;
	private Apresentacao fk_Apresentacao;
	private Pessoa fk_Pessoa;
	private FormaPagamento fk_FormaPagamento;
	private Cartao fk_Cartao;
}