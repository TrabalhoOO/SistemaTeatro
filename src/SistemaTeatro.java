/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import sistemateatro.Espectador;

public class SistemaTeatro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leia = null;
        try {
            /*leia = new Scanner(System.in);
            System.out.println("Forneça os dados: \n");
            System.out.println("Nome do Espectador: ");
            String nome = leia.nextLine();
            System.out.println(" \nEndereço Completo: ");
            String endereco = leia.nextLine();
            System.out.println("\nTelefone de contato: ");
            String telefone = leia.nextLine();
            System.out.println("\nEmail: ");
            String email = leia.nextLine();
            System.out.println("\nLocal de Trabalho: ");
            String local = leia.nextLine();
            System.out.println("\nEndereço Comercial Completo: ");
            String enderecocomercial = leia.nextLine();
            System.out.println("\nData de Nascimento: ");
            String data = leia.nextLine();
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Date dt = df.parse(data);
            System.out.println(dt);
            System.out.println("\nCPF: ");
            String cpf = leia.nextLine();
            System.out.println("\nRG: ");
            String rg = leia.nextLine();
            System.out.println("\nLogin: ");
            String login = leia.nextLine();
            System.out.println("\nSenha: ");
            String senha = leia.nextLine();
            Espectador espectador = new Espectador(nome, endereco, telefone, email, local, enderecocomercial, dt, cpf, rg, login, senha);*/
            String data = "07/04/1997";
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Date dt = df.parse(data);
            Espectador espectador = new Espectador("Roberto Fernandes", "Rua Teste", "24992064485", "teste@teste.com.br", "Teste", "Teste",dt , "16148567709", "123", "123","123");
            Espectador.ler(9);
			Espectador.RelEspectadores();			

        } catch (ParseException e) {
            System.out.println("Data Inválida! Digite a novamente: ");
            leia.nextLine();

        } catch (InputMismatchException e) {
            System.out.println("Valor Inválido");
        }
    }
    
}
