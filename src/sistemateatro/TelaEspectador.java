package sistemateatro;

import java.util.Scanner;

public class TelaEspectador {

    private Pessoa pessoa;

    public TelaEspectador(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    void ConstruirTela() {
        System.out.println("---------------------------------------------------------------------------------\n");
        System.out.println("\t\t\t\tM   E   N   U   \n");
        System.out.println("---------------------------------------------------------------------------------\n");
        System.out.println("\t-->PARA O VISUALIZAR OU  REALIZAR COMPRAS TECLE                           [1]\n\n");
        System.out.println("\t-->PARA VISUALIZAR OU CADASTRAR PREFERÊNCIAS                              [2]\n\n");
        System.out.println("\t-->PARA CONSULTAR ESPETÁCULOS                                             [3]\n\n");
        System.out.println("\t-->PARA O SAIR TECLE                                                      [4]\n\n");
        System.out.println("---------------------------------------------------------------------------------\n");
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
                    this.ConstruirTelaCompra();
                    break;
                case 2:
                    this.ConstruirTelaPreferencia();
                    break;
                case 3:
                    this.ConstruirTelaConsulta();
                    break;
                default:
                    break;
            }
            System.out.println("---------------------------------------------------------------------------------\n");
            System.out.println("\t\t\t\tM   E   N   U   \n");
            System.out.println("---------------------------------------------------------------------------------\n");
            System.out.println("\t-->PARA O VISUALIZAR OU  REALIZAR COMPRAS TECLE                           [1]\n\n");
            System.out.println("\t-->PARA VISUALIZAR OU CADASTRAR PREFERÊNCIAS                              [2]\n\n");
            System.out.println("\t-->PARA CONSULTAR ESPETÁCULOS                                             [3]\n\n");
            System.out.println("\t-->PARA O SAIR TECLE                                                      [4]\n\n");
            System.out.println("---------------------------------------------------------------------------------\n");
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

    private void ConstruirTelaPreferencia() {
        System.out.println("-----------------------------------------------------------------------------------------\n");
        System.out.println("\t\t\t\tM   E   N   U   \n");
        System.out.println("-----------------------------------------------------------------------------------------\n");
        System.out.println("\t-->PARA INCLUIR PREFERÊNCIAS TECLE                           		        [1]\n\n");
        System.out.println("\t-->PARAO VISUALIZAR PREFERÊNCIAS TECLE                                            [2]\n\n");
        System.out.println("\t-->PARA O SAIR TECLE                                                              [3]\n\n");
        System.out.println("-----------------------------------------------------------------------------------------\n");
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
        Dao preferencia = new PreferenciaDao();
        while (opcao != 3) {
            switch (opcao) {
                case 1:
                    preferencia.Incluir();
                    break;
                case 2:
                    preferencia.VisulizarCompra(this.pessoa.getIdPessoa());
                    break;
                default:
                    break;
            }
            System.out.println("-----------------------------------------------------------------------------------------\n");
            System.out.println("\t\t\t\tM   E   N   U   \n");
            System.out.println("-----------------------------------------------------------------------------------------\n");
            System.out.println("\t-->PARA INCLUIR PREFERÊNCIAS TECLE                           		        [1]\n\n");
            System.out.println("\t-->PARAO VISUALIZAR PREFERÊNCIAS TECLE                                            [2]\n\n");
            System.out.println("\t-->PARA O SAIR TECLE                                                              [3]\n\n");
            System.out.println("-----------------------------------------------------------------------------------------\n");
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

    private void ConstruirTelaCompra() {
        System.out.println("-----------------------------------------------------------------------------------------\n");
        System.out.println("\t\t\t\tM   E   N   U   \n");
        System.out.println("-----------------------------------------------------------------------------------------\n");
        System.out.println("\t-->PARA REALIZAR COMPRAS TECLE                           		                [1]\n\n");
        System.out.println("\t-->PARAO VISUALIZAR COMPRAS TECLE                             			[2]\n\n");
        System.out.println("\t-->PARA O SAIR TECLE                                                              [3]\n\n");
        System.out.println("-----------------------------------------------------------------------------------------\n");
        Scanner leia = new Scanner(System.in);
        CompraDao compra = new CompraDao();
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
                    compra.Incluir();
                    break;
                case 2:
                    compra.VisulizarCompra(this.pessoa.getIdPessoa());
                    break;
                default:
                    break;
            }
            System.out.println("-----------------------------------------------------------------------------------------\n");
            System.out.println("\t\t\t\tM   E   N   U   \n");
            System.out.println("-----------------------------------------------------------------------------------------\n");
            System.out.println("\t-->PARA REALIZAR COMPRAS TECLE                           		            [1]\n\n");
            System.out.println("\t-->PARAO VISUALIZAR COMPRAS TECLE                                                 [2]\n\n");
            System.out.println("\t-->PARA O SAIR TECLE                                                              [3]\n\n");
            System.out.println("-----------------------------------------------------------------------------------------\n");
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

    private void ConstruirTelaConsulta() {
        System.out.println("-----------------------------------------------------------------------------------------\n");
        System.out.println("\t\t\t\tM   E   N   U   \n");
        System.out.println("-----------------------------------------------------------------------------------------\n");
        System.out.println("\t-->PARA REALIZAR CONSULTA DE ESPETÁCULO POR ARTISTA TECLE                             [1]\n\n");
        System.out.println("\t-->PARAO REALIZAR CONSULTA DE ESPETÁCULO POR FAIXA ETÁRIA TECLE                       [2]\n\n");
        System.out.println("\t-->PARAO REALIZAR CONSULTA DE ESPETÁCULO POR TIPO DE ESPETÁCULO TECLE                 [3]\n\n");
        System.out.println("\t-->PARA O SAIR TECLE                                                                  [4]\n\n");
        System.out.println("-----------------------------------------------------------------------------------------\n");
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
        while (opcao != 3) {
            switch (opcao) {
                case 1:
                    Pessoa.buscaArtista();
                    break;
                case 2:
                    Pessoa.buscaTipoEspetaculo();
                    break;
                case 3:
                    Pessoa.buscaFaixaEtaria();
                    break;
                default:
                    break;
            }
            System.out.println("-----------------------------------------------------------------------------------------\n");
            System.out.println("\t\t\t\tM   E   N   U   \n");
            System.out.println("---------------------------------------------------------------------------------------------\n");
            System.out.println("\t-->PARA REALIZAR CONSULTA DE ESPETÁCULO POR DATA TECLE                            [1]\n\n");
            System.out.println("\t-->PARAO REALIZAR CONSULTA DE ESPETÁCULO POR FAIXA ETÁRIA TECLE                  	[2]\n\n");
            System.out.println("\t-->PARAO REALIZAR CONSULTA DE ESPETÁCULO POR TIPO DE ESPETÁCULO TECLE             [3]\n\n");
            System.out.println("\t-->PARA O SAIR TECLE                                                              [4]\n\n");
            System.out.println("--------------------------------------------------------------------------------------------\n");
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

}
