
package sistemateatro;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PessoaDao implements Dao {
     Pessoa pessoa = new Pessoa();
     public void Incluir() {
        Scanner leia = new Scanner(System.in);
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
        boolean valido = false;
        Date dt = null;
        while (!valido) {

            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            df.setLenient(false);
            try {
                dt = df.parse(data);
                valido = true;
            } catch (ParseException ex) {
                data = leia.nextLine();
            }
        }
        System.out.println(dt);
        System.out.println("\nCPF: ");
        String cpf = leia.nextLine();
        System.out.println("\nRG: ");
        String rg = leia.nextLine();
        System.out.println("\nLogin: ");
        String login = leia.nextLine();
        valido = Pessoa.buscaLogin(login);
        while (valido) {
            login = leia.nextLine();
            valido = Pessoa.buscaLogin(login);
        }
        System.out.println("\nSenha: ");
        String senha = leia.nextLine();
        GeradorID gerador = new GeradorID();

        if (gerador.genID(pessoa) > 0) {
            pessoa.setIdPessoa(gerador.genID(pessoa));
        } else {
            System.out.println("Erro na inserção");
        }
        pessoa.setNome(nome);
        pessoa.setEndereco(endereco);
        pessoa.setTelefone(telefone);
        pessoa.setEmail(email);
        pessoa.setLocalTrabalho(local);
        pessoa.setEnderecoComercial(enderecocomercial);
        pessoa.setDataNasc(dt.getTime());
        pessoa.setCPF(cpf);
        pessoa.setRG(rg);
        pessoa.setLogin(login);
        pessoa.setSenha(senha);
        pessoa.setNivelAcesso(1);
        PessoaDao.escrever(pessoa);
    }
      private static void escrever(Pessoa pessoa) {
        File arq = pessoa.getArq();
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            if (!arq.exists()) {
                arq.createNewFile();
            }
            //Devemos passar no construtor do FileWriter qual arquivo
            // vamos manipular.
            // Esse construtor aceita dois tipos de parâmetros,
            // File ou String.
            //O parâmetro true indica que reescrevemos no arquivo
            // sem apagar o que já existe.
            // O false apagaria o conteúdo do arquivo e escreveria
            // o novo conteúdo.
            // Se não usar o 2° parâmetro, ele por padrão será false.
            //O mais importante, essa linha abre o fluxo do arquivo
            //FileWriter fileWriter = new FileWriter(arq, true);

            //Agora vamos usar a classe PrintWriter para escrever
            //fisicamente no arquivo.
            //Precisamos passar o objeto FileReader em seu construtor
            fileWriter = new FileWriter(arq.getAbsolutePath(), true);
            bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.newLine();

            bufferedWriter.write(Integer.toString(pessoa.getIdPessoa()));
            bufferedWriter.write(";");
            bufferedWriter.write(pessoa.getNome());
            bufferedWriter.write(";");
            bufferedWriter.write(pessoa.getEndereco());
            bufferedWriter.write(";");
            bufferedWriter.write(pessoa.getTelefone());
            bufferedWriter.write(";");
            bufferedWriter.write(pessoa.getEmail());
            bufferedWriter.write(";");
            bufferedWriter.write(pessoa.getLocalTrabalho());
            bufferedWriter.write(";");
            bufferedWriter.write(pessoa.getEnderecoComercial());
            bufferedWriter.write(";");
            bufferedWriter.write(pessoa.getDataNasc().toString());
            bufferedWriter.write(";");
            bufferedWriter.write(pessoa.getCPF());
            bufferedWriter.write(";");
            bufferedWriter.write(pessoa.getRG());
            bufferedWriter.write(";");
            bufferedWriter.write(pessoa.getLogin());
            bufferedWriter.write(";");
            bufferedWriter.write(pessoa.getSenha());
            bufferedWriter.write(";");
            bufferedWriter.write(Integer.toString(pessoa.getNivelAcesso()));
            bufferedWriter.write(";");

            //o método flush libera a escrita no arquivo
            fileWriter.flush();
            bufferedWriter.flush();

        } catch (IOException e) {
            System.out.println("Não foi possível escrever no arquivo");
        } finally {
            try {
                fileWriter.close();
                bufferedWriter.close();
            } catch (IOException e) {
                System.out.println("Não foi possível alterar o arquivo");
            }
        }
    }

    
    


}
