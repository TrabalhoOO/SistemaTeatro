package sistemateatro;

import java.util.Scanner;

public class Tela {

    protected Pessoa pessoa;
    private TelaMantenedor telamantenedor = null;

    public void RealizarLogin() {
        Scanner leia = new Scanner(System.in);
        System.out.println("Sistema Teatro - versão 1.0 \n");
        System.out.println("Login: ");
        String login = leia.nextLine();
        System.out.println(" \nSenha: ");
        String senha = leia.nextLine();
        Pessoa logon = null;
        while (logon == null) {
            logon = Pessoa.Login(login, senha);
            if (logon != null) {
                this.pessoa = logon;
                if(pessoa.getNivelAcesso()==0){
                telamantenedor = new TelaMantenedor(pessoa);
                telamantenedor.ConstruirTelaGeral();
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
