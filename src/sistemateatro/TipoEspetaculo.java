
package sistemateatro;

public class TipoEspetaculo {

    static TipoEspetaculo buscaID(int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	private int idTipoEspetaculo;
	private static int genID = 0;
	private String descricao;
	public Preferencia preferencia;

    public int getIdTipoEspetaculo() {
        return idTipoEspetaculo;
    }

    public void setIdTipoEspetaculo(int idTipoEspetaculo) {
        this.idTipoEspetaculo = idTipoEspetaculo;
    }

    public static int getGenID() {
        return genID;
    }

    public static void setGenID(int genID) {
        TipoEspetaculo.genID = genID;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Preferencia getPreferencia() {
        return preferencia;
    }

    public void setPreferencia(Preferencia preferencia) {
        this.preferencia = preferencia;
    }
	
}