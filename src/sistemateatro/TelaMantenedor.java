package sistemateatro;

import java.util.Scanner;

public class TelaMantenedor {

    private Pessoa pessoa;

    public TelaMantenedor(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public void ConstruirTelaGeral() {

        System.out.println("--------------------------------------------------------------------------------\n");
        System.out.println("\t\t\t\tM   E   N   U   \n");
        System.out.println("--------------------------------------------------------------------------------\n");
        System.out.println("\t-->PARA O CADASTRO DE PESSOAS TECLE                                      [1]\n\n");
        System.out.println("\t-->PARA O CADASTRO DE ESPETÁCULOS TECLE                                  [2]\n\n");
        System.out.println("\t-->PARA O CADASTRO DE SALAS DE TEATRO TECLE                              [3]\n\n");
        System.out.println("\t-->PARA O CADASTRO DE ARTISTAS TECLE                                     [4]\n\n");
        System.out.println("\t-->PARA O CADASTRO DE APRESENTAÇÕES TECLE                                [5]\n\n");
        System.out.println("\t-->PARA VISUALIZAR RELATÓRIOS TECLE                                      [6]\n\n");
        System.out.println("\t-->PARA SAIR TECLE                                                       [7]\n");
        System.out.println("--------------------------------------------------------------------------------\n");
        Scanner leia = new Scanner(System.in);
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

                case 2:
                    this.ConstruirTelaEspetaculo();
                    break;

                case 3:
                    this.ConstruirTelaSala();
                    break;
                case 4:
                    this.ConstruirTelaArtista();
                case 5:
                    this.ConstruirTelaApresentacao();
                    break;
                case 6:
                    this.ConstruirTelaRelatorio();
                    break;
                default:
                    break;
            }
            System.out.println("--------------------------------------------------------------------------------------\n");
            System.out.println("\t\t\t\tM   E   N   U   \n");
            System.out.println("----------------------------------------------------------------------------------\n");
            System.out.println("ESCOLHA UMA OPÇÃO: \n\n");
            System.out.println("\t-->PARA O CADASTRO DE PESSOAS TECLE                                        [1]\n\n");
            System.out.println("\t-->PARA O CADASTRO DE ESPETÁCULOS TECLE                                    [2]\n\n");
            System.out.println("\t-->PARA O CADASTRO DE SALAS DE TEATRO TECLE                                [3]\n\n");
            System.out.println("\t-->PARA O CADASTRO DE ARTISTAS TECLE                                       [4]\n\n");
            System.out.println("\t-->PARA O CADASTRO DE APRESENTAÇÕES TECLE                                  [5]\n\n");
            System.out.println("\t-->PARA VISUALIZAR RELATÓRIOS TECLE                                        [6]\n\n");
            System.out.println("\t-->PARA SAIR TECLE                                                         [7]\n");
            System.out.println("--------------------------------------------------------------------------------\n");
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
        System.out.println("----------------------------------------------------------------------------------------\n");
        System.out.println("\t\t\t\tM   E   N   U   \n");
        System.out.println("--------------------------------------------------------------------------------\n");
        System.out.println("ESCOLHA UMA OPÇÃO: \n\n");
        System.out.println("\t-->PARA O INCLUSÃO DE UM ESPECTADOR TECLE                                [1]\n\n");
        System.out.println("\t-->PARA O ALTERAÇÃO DE UM ESPECTADOR TECLE                               [2]\n\n");
        System.out.println("\t-->PARA O EXCLUSÃO DE UM ESPECTADOR TECLE                                [3]\n\n");
        System.out.println("\t-->PARA SAIR  TECLE                                                      [4]\n\n");
        System.out.println("--------------------------------------------------------------------------------\n");
        Scanner leia = new Scanner(System.in);
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

            System.out.println("----------------------------------------------------------------------------------------\n");
            System.out.println("\t\t\t\tM   E   N   U   \n");
            System.out.println("--------------------------------------------------------------------------------\n");
            System.out.println("ESCOLHA UMA OPÇÃO: \n\n");
            System.out.println("\t-->PARA O INCLUSÃO DE UM ESPECTADOR TECLE                                [1]\n\n");
            System.out.println("\t-->PARA O ALTERAÇÃO DE UM ESPECTADOR TECLE                               [2]\n\n");
            System.out.println("\t-->PARA O EXCLUSÃO DE UM ESPECTADOR TECLE                                [3]\n\n");
            System.out.println("\t-->PARA SAIR  TECLE                                                      [4]\n\n");
            System.out.println("--------------------------------------------------------------------------------\n");
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

    public void ConstruirTelaSala() {
        System.out.println("----------------------------------------------------------------------------------------\n");
        System.out.println("\t\t\t\tM   E   N   U   \n");
        System.out.println("--------------------------------------------------------------------------------\n");
        System.out.println("ESCOLHA UMA OPÇÃO: \n\n");
        System.out.println("\t-->PARA O INCLUSÃO DE UM SALA TECLE                                      [1]\n\n");
        System.out.println("\t-->PARA O ALTERAÇÃO DE UM SALA TECLE                                     [2]\n\n");
        System.out.println("\t-->PARA O EXCLUSÃO DE UM SALA TECLE                            	       [3]\n\n");
        System.out.println("\t-->PARA SAIR  TECLE                                                      [4]\n\n");
        System.out.println("--------------------------------------------------------------------------------\n");
        Scanner leia = new Scanner(System.in);
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
        Dao sala = new SalaDao();
        while (opcao != 4) {
            switch (opcao) {
                case 1:
                    sala.Incluir();
                    break;
                case 2:
                    sala.Alterar();
                    break;
                case 3:
                    sala.Excluir();
                    break;
                default:
                    break;
            }

            System.out.println("----------------------------------------------------------------------------------------\n");
            System.out.println("\t\t\t\tM   E   N   U   \n");
            System.out.println("--------------------------------------------------------------------------------\n");
            System.out.println("ESCOLHA UMA OPÇÃO: \n\n");
            System.out.println("\t-->PARA O INCLUSÃO DE UM SALA TECLE                                      [1]\n\n");
            System.out.println("\t-->PARA O ALTERAÇÃO DE UM SALA TECLE                                     [2]\n\n");
            System.out.println("\t-->PARA O EXCLUSÃO DE UM SALA TECLE                            	   [3]\n\n");
            System.out.println("\t-->PARA SAIR  TECLE                                                      [4]\n\n");
            System.out.println("--------------------------------------------------------------------------------\n");
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

    public void ConstruirTelaEspetaculo() {
        System.out.println("----------------------------------------------------------------------------------------\n");
        System.out.println("\t\t\t\tM   E   N   U   \n");
        System.out.println("--------------------------------------------------------------------------------\n");
        System.out.println("ESCOLHA UMA OPÇÃO: \n\n");
        System.out.println("\t-->PARA O INCLUSÃO DE UM ESPETÁCULO TECLE                                [1]\n\n");
        System.out.println("\t-->PARA O ALTERAÇÃO DE UM ESPETÁCULO TECLE                               [2]\n\n");
        System.out.println("\t-->PARA O EXCLUSÃO DE UM ESPETÁCULO TECLE                                [3]\n\n");
        System.out.println("\t-->PARA SAIR  TECLE                                                      [4]\n\n");
        System.out.println("--------------------------------------------------------------------------------\n");
        Scanner leia = new Scanner(System.in);
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
        Dao espetaculo = new EspetaculoDao();
        while (opcao != 4) {
            switch (opcao) {
                case 1:
                    espetaculo.Incluir();
                    break;
                case 2:
                    espetaculo.Alterar();
                    break;
                case 3:
                    espetaculo.Excluir();
                    break;
                default:
                    break;
            }

            System.out.println("----------------------------------------------------------------------------------------\n");
            System.out.println("\t\t\t\tM   E   N   U   \n");
            System.out.println("--------------------------------------------------------------------------------\n");
            System.out.println("ESCOLHA UMA OPÇÃO: \n\n");
            System.out.println("\t-->PARA O INCLUSÃO DE UM ESPETÁCULO TECLE                                [1]\n\n");
            System.out.println("\t-->PARA O ALTERAÇÃO DE UM ESPETÁCULO TECLE                               [2]\n\n");
            System.out.println("\t-->PARA O EXCLUSÃO DE UM ESPETÁCULO TECLE                                [3]\n\n");
            System.out.println("\t-->PARA SAIR  TECLE                                                      [4]\n\n");
            System.out.println("--------------------------------------------------------------------------------\n");
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
        System.out.println("--------------------------------------------------------------------------------\n");
        System.out.println("\t\t\t\tM   E   N   U   \n");
        System.out.println("--------------------------------------------------------------------------------\n");
        System.out.println("ESCOLHA UMA OPÇÃO: \n\n");
        System.out.println("\t-->PARA O INCLUSÃO DE UMA APRESENTAÇÃO TECLE                            [1]\n\n");
        System.out.println("\t-->PARA O ALTERAÇÃO DE UMA APRESENTAÇÃO TECLE                           [2]\n\n");
        System.out.println("\t-->PARA O EXCLUSÃO DE UMA APRESENTAÇÃO  TECLE                           [3]\n\n");
        System.out.println("\t-->PARA SAIR  TECLE                                                     [4]\n\n");
        System.out.println("--------------------------------------------------------------------------------\n");
        Scanner leia = new Scanner(System.in);
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
            System.out.println("--------------------------------------------------------------------------------\n");
            System.out.println("\t\t\t\tM   E   N   U   \n");
            System.out.println("--------------------------------------------------------------------------------\n");
            System.out.println("ESCOLHA UMA OPÇÃO: \n\n");
            System.out.println("\t-->PARA O INCLUSÃO DE UMA APRESENTAÇÃO TECLE                            [1]\n\n");
            System.out.println("\t-->PARA O ALTERAÇÃO DE UMA APRESENTAÇÃO TECLE                           [2]\n\n");
            System.out.println("\t-->PARA O EXCLUSÃO DE UMA APRESENTAÇÃO  TECLE                           [3]\n\n");
            System.out.println("\t-->PARA SAIR  TECLE                                                     [4]\n\n");
            System.out.println("--------------------------------------------------------------------------------\n");
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

    public void ConstruirTelaArtista() {
        System.out.println("--------------------------------------------------------------------------------\n");
        System.out.println("\t\t\t\tM   E   N   U   \n");
        System.out.println("--------------------------------------------------------------------------------\n");
        System.out.println("ESCOLHA UMA OPÇÃO: \n\n");
        System.out.println("\t-->PARA O INCLUSÃO DE UMA ARTISTA TECLE                            [1]\n\n");
        System.out.println("\t-->PARA O ALTERAÇÃO DE UMA ARTISTA TECLE                           [2]\n\n");
        System.out.println("\t-->PARA O EXCLUSÃO DE UMA ARTISTA  TECLE                           [3]\n\n");
        System.out.println("\t-->PARA SAIR  TECLE                                                [4]\n\n");
        System.out.println("--------------------------------------------------------------------------------\n");
        Scanner leia = new Scanner(System.in);
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
        Dao artista = new ArtistaDao();
        while (opcao != 4) {
            switch (opcao) {
                case 1:
                    artista.Incluir();
                    break;
                case 2:
                    artista.Alterar();
                    break;
                case 3:
                    artista.Excluir();
                    break;
                default:
                    break;
            }
            System.out.println("--------------------------------------------------------------------------------\n");
            System.out.println("\t\t\t\tM   E   N   U   \n");
            System.out.println("--------------------------------------------------------------------------------\n");
            System.out.println("ESCOLHA UMA OPÇÃO: \n\n");
            System.out.println("\t-->PARA O INCLUSÃO DE UMA ARTISTA TECLE                                 [1]\n\n");
            System.out.println("\t-->PARA O ALTERAÇÃO DE UMA ARTISTA TECLE                                [2]\n\n");
            System.out.println("\t-->PARA O EXCLUSÃO DE UMA ARTISTA  TECLE                                [3]\n\n");
            System.out.println("\t-->PARA SAIR  TECLE                                                     [4]\n\n");
            System.out.println("--------------------------------------------------------------------------------\n");
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

    public void ConstruirTelaRelatorio() {
        System.out.println("\t\t\t\tM   E   N   U   \n");
        System.out.println("---------------------------------------------------------------------------------------------------\n");
        System.out.println("ESCOLHA UMA OPÇÃO: \n\n");
        System.out.println("\t-->VISUALIZAR RELATÓRIO DE TOTAL ARRECADADO POR ESPETÁCULO TECLE                            [1]\n\n");
        System.out.println("\t-->VISUALIZAR RELATÓRIO DE % TOTAL DE ASSENTOS OCUPADOS EM TODAS AS SALAS TECLE             [2]\n\n");
        System.out.println("\t-->VISUALIZAR RELATÓRIO DE COMPRAS POR PESSOA                                               [3]\n\n");
        System.out.println("\t-->PARA SAIR  TECLE                                                                         [4]\n\n");
        System.out.println("---------------------------------------------------------------------------------------------------\n");
        Scanner leia = new Scanner(System.in);
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
        while (opcao != 4) {
            switch (opcao) {
                case 1:
                    Compra.TotalporEspetaculo();
                    break;
                case 2:
                    Sala.Ocupacao();
                    break;
                case 3:
                    Pessoa.RelPessoas();
                    break;
                default:
                    break;
            }
            System.out.println("\t\t\t\tM   E   N   U   \n");
            System.out.println("---------------------------------------------------------------------------------------------------\n");
            System.out.println("ESCOLHA UMA OPÇÃO: \n\n");
            System.out.println("\t-->VISUALIZAR RELATÓRIO DE TOTAL ARRECADADO POR ESPETÁCULO TECLE                            [1]\n\n");
            System.out.println("\t-->VISUALIZAR RELATÓRIO DE % TOTAL DE ASSENTOS OCUPADOS EM TODAS AS SALAS TECLE             [2]\n\n");
            System.out.println("\t-->VISUALIZAR RELATÓRIO DE PESSOAS                                                          [3]\n\n");
            System.out.println("\t-->PARA SAIR  TECLE                                                                         [4]\n\n");
            System.out.println("---------------------------------------------------------------------------------------------------\n");
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
