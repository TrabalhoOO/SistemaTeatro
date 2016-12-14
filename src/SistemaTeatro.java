import sistemateatro.Pessoa;
import sistemateatro.PessoaDao;
import sistemateatro.Tela;

public class SistemaTeatro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            Pessoa pessoa = new Pessoa();
            if(!pessoa.getArq().exists())
            {
                PessoaDao mantenedor = new PessoaDao();
                mantenedor.IncluirMantenedor();
            
            }
            Tela tela = new Tela();
            tela.TelaInicial();
    }
}
