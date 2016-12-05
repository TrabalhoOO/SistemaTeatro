package sistemateatro;
import java.io.*;
import java.util.Date;
import java.util.LinkedList;
public class Espetaculo {
	private int _idEspetaculo;
	private String _nome;
	private String _descricao;
	private int _faixaEtaria;
	private int _duracaoMinutos;
	private static int _genID = 0;
	public Temporada _fk_Temporada;
	public TipoEspetaculo _fk_TipoDeEspetaculo;
	public LinkedList<Artista> _fk_Artista = new LinkedList<Artista>();
	public Apresentacao _apresentacao;
}