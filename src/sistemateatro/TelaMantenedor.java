package sistemateatro;

import java.util.Scanner;

public class TelaMantenedor {

    private Pessoa pessoa;

    public TelaMantenedor(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public void ConstruirTelaGeral() {
        System.out.println("Usuario:" + this.getPessoa().getNome() + "\t\t\tMenu\n");
        System.out.println("Escolha sua opção: \n");
        System.out.println("1-Pessoas\n");
        System.out.println("2-Espetáculos\n");
        System.out.println("3-Salas do Teatro\n");
        System.out.println("4-Artistas\n");
        System.out.println("5-Apresentações\n");
        System.out.println("6-Relatórios\n");
        System.out.println("7-Sair\n");
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
        while (opcao != 7) {
            switch (opcao) {
                case 1:
                    this.ConstruirTelaPessoa();
                    break;
                    
                case 5:
                    this.ConstruirTelaApresentacao();
                    break;
                default:
                    break;
            }
            System.out.println("Usuario:" + this.getPessoa().getNome() + "\t\t\tMenu\n");
            System.out.println("Escolha sua opção: \n");
            System.out.println("1-Pessoas\n");
            System.out.println("2-Espetáculos\n");
            System.out.println("3-Salas do Teatro\n");
            System.out.println("4-Artistas\n");
            System.out.println("5-Apresentações\n");
            System.out.println("6-Relatórios\n");
            System.out.println("7-Sair\n");
            System.out.println("Informe a opção selecionada: ");
            valido = false;
            opcao = 0;
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

    public void ConstruirTelaPessoa() {
        System.out.println("Escolha sua opção: \n");
        System.out.println("1-Incluir\n");
        System.out.println("2-Alterar\n");
        System.out.println("3-Excluir\n");
        System.out.println("4-Sair\n");
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
        Dao pessoa = new PessoaDao();
        while (opcao != 4) {
            switch (opcao) {
                case 1:
                    pessoa.Incluir();
                    break;
                case 2:
                    pessoa.Alterar();
                    break;
                case 3:
                    pessoa.Excluir();
                    break;
                default:
                    break;
            }
            System.out.println("Escolha sua opção: \n");
            System.out.println("1-Incluir\n");
            System.out.println("2-Alterar\n");
            System.out.println("3-Excluir\n");
            System.out.println("4-Sair\n");
            valido = false;
            opcao = 0;
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

    public void ConstruirTelaApresentacao() {
        System.out.println("Escolha sua opção: \n");
        System.out.println("1-Incluir\n");
        System.out.println("2-Alterar\n");
        System.out.println("3-Excluir\n");
        System.out.println("4-Sair\n");
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
        Dao apresentacao = new ApresentacaoDao();
        while (opcao != 4) {
            switch (opcao) {
                case 1:
                    apresentacao.Incluir();
                    break;
                case 2:
                    apresentacao.Alterar();
                    break;
                case 3:
                    apresentacao.Excluir();
                    break;
                default:
                    break;
            }
            System.out.println("Escolha sua opção: \n");
            System.out.println("1-Incluir\n");
            System.out.println("2-Alterar\n");
            System.out.println("3-Excluir\n");
            System.out.println("4-Sair\n");
            valido = false;
            opcao = 0;
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

    public Pessoa getPessoa() {
        return pessoa;
    }

}
