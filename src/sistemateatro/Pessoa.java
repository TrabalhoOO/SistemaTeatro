package sistemateatro;
import java.io.*;
import java.util.Date;
import java.util.LinkedList;
public class Pessoa {
	private int idPessoa;
	private static int genID = 0;
	private String nome;
	private String endereco;
	private String telefone;
	private String email;
	private String localTrabalho;
	private String enderecoComercial;
	private Date dataNasc;
	private String CPF;
	private String RG;
	private String login;
	private String senha;
	private String nivelAcesso;
	public LinkedList<Preferencia> preferencia = new LinkedList<Preferencia>();
	public LinkedList <Compra> compra = new LinkedList<Compra>();
}