package sistemateatro;

import java.util.Scanner;

public class TelaEspectador {

    private Pessoa pessoa;

    public TelaEspectador(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    void ConstruirTela() {
        System.out.println("Usuario:" + this.getPessoa().getNome() + "\nMenu\n");
        System.out.println("Escolha sua opção: \n");
        System.out.println("1 - Compras \n");
        System.out.println("2 - Preferências \n");
        System.out.println("3 - Sair \n");
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
                    this.ConstruirTelaCompra();
                    break;
                case 2:
                    this.ConstruirTelaPreferencia();
                    break;
                default:
                    break;
            }
            System.out.println("Usuario:" + this.getPessoa().getNome() + "\t\t\tMenu\n");
            System.out.println("Escolha sua opção: \n");
            System.out.println("1 - Compras \n");
            System.out.println("2 - Preferências \n");
            System.out.println("3 - Sair \n");
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

    public Pessoa getPessoa() {
        return pessoa;
    }

    private void ConstruirTelaPreferencia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void ConstruirTelaCompra() {
        System.out.println("Escolha sua opção: \n");
        System.out.println("1-Realizar Compra\n");
        System.out.println("2-Visualizar Compras\n");
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
    }

}
