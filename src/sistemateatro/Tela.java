package sistemateatro;

import java.util.Scanner;

/**
 *
 * @author jpdia
 */
public class Tela {

    private Pessoa pessoa;
    private TelaMantenedor telamantenedor = null;
    private TelaEspectador telaespectador = null;

    /**
     *
     */
    public void TelaInicial() {
        System.out.println("Sistema Teatro - versão 1.0 \n");
        System.out.println("1 - Realizar Login\n");
        System.out.println("2 - Criar nova Conta\n");
        System.out.println("3 - Sair\n");
        Scanner leia = new Scanner(System.in);
        System.out.println("Informe a opção selecionada: ");
        boolean valido = false;
        int opcao = 0;
        while (!valido) {

            try {
                opcao = Integer.parseInt(leia.nextLine());
                valido = true;
            } catch (NumberFormatException e) {
                {
                    System.out.println("Valor inválido! Digite Novamente: ");
                    opcao = Integer.parseInt(leia.nextLine());
                }

            }
        }
        while (opcao != 3) {
            switch (opcao) {
                case 1:
                    this.RealizarLogin();
                    break;
                case 2:
                    Dao pessoa = new PessoaDao();
                    pessoa.Incluir();
                    this.RealizarLogin();
                    break;
                default:
                    System.out.println("Opção inválida! Finalizando Sistema");
                    System.exit(0);
                    break;
            }
            System.out.println("Sistema Teatro - versão 1.0 \n");
            System.out.println("1 - Realizar Login\n");
            System.out.println("2 - Criar nova Conta\n");
            System.out.println("3 - Sair\n");
            System.out.println("Informe a opção selecionada: ");
            valido=false;
            while (!valido) {

                try {
                    opcao = Integer.parseInt(leia.nextLine());
                    valido = true;
                } catch (NumberFormatException e) {
                    {
                        System.out.println("Valor inválido! Digite Novamente: ");
                        opcao = Integer.parseInt(leia.nextLine());
                    }

                }
            }
        }
    }

    /**
     *
     */
    public void RealizarLogin() {
        Scanner leia = new Scanner(System.in);

        System.out.println("Login: ");
        String login = leia.nextLine();
        System.out.println(" \nSenha: ");
        String senha = leia.nextLine();
        Pessoa logon = null;
        while (logon == null) {
            logon = Pessoa.Login(login, senha);
            if (logon != null) {
                this.pessoa = logon;
                if (this.pessoa.getNivelAcesso() == 0) {
                    this.telamantenedor = new TelaMantenedor(pessoa);
                    this.telamantenedor.ConstruirTelaGeral();
                }
                else if(pessoa.getNivelAcesso()==1){
                    this.telaespectador = new TelaEspectador(this.pessoa);
                    this.telaespectador.ConstruirTela();
                }
            } else {
                System.out.println("Login: ");
                login = leia.nextLine();
                System.out.println(" \nSenha: ");
                senha = leia.nextLine();
            }

        }

    }
}
