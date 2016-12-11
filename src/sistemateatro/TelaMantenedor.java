
package sistemateatro;

import java.util.Scanner;

public class TelaMantenedor extends Tela {
    
    public TelaMantenedor(Pessoa pessoa)
    {
        this.pessoa = pessoa;
    }
    public void ConstruirTelaGeral()
    {
        System.out.println("Usuario:"+this.getPessoa().getNome()+"\t\t\tMenu\n");
        System.out.println("Escolha sua opção: \n");
        System.out.println("1-Pessoas\n");
        System.out.println("2-Espetáculos\n");
        System.out.println("3-Salas do Teatro\n");
        System.out.println("4-Artistas\n");
        System.out.println("5-Apresentações\n");
        System.out.println("6-Relatórios\n");
        System.out.println("7-Sair\n");
        Scanner leia = new Scanner(System.in);
        int opcao = leia.nextInt();
        while(opcao!=7)
        {
        switch (opcao)
        {
            case 1:
                this.ConstruirTelaPessoa();
                break;
        }
    
    }
    }
    public void ConstruirTelaPessoa(){
        System.out.println("Escolha sua opção: \n");
        System.out.println("1-Incluir\n");
        System.out.println("2-Alterar\n");
        System.out.println("3-Excluir\n");
        
    }

    public Pessoa getPessoa() {
        return pessoa;
    }
    
            
            
    
    
}
