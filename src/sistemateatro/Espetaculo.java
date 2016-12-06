package sistemateatro;
import java.io.*;
import java.util.Date;
import java.util.LinkedList;
public class Espetaculo {
	private int idEspetaculo;
	private String nome;
	private String descricao;
	private int faixaEtaria;
	private int duracaoMinutos;
	private static int _genID = 0;
	public Temporada fk_Temporada;
	public TipoEspetaculo fk_TipoDeEspetaculo;
	public LinkedList<Artista> fk_Artista = new LinkedList<Artista>();
	public LinkedList<Apresentacao> fk_apresentacao = new LinkedList<Apresentacao>();
}