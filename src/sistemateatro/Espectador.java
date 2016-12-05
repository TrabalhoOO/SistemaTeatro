
package sistemateatro;
import java.io.*;
import java.util.*;

public class Espectador implements Comparable<Espectador> {

    private int id;
    private static int genID=0;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private String local;
    private String enderecocomercial;
    private Date data;
    private String cpf;
    private String rg;
    private String login;
    private String senha;
    private static final File dir = new File("C:\\Users\\Ricardo Alves\\Desktop\\Desenvolvimento\\Projetos\\Backup\\SistemaTeatro");
    private static final File arq = new File(dir, "Espectador.txt");
	public static final String UTF8_BOM = "\uFEFF";

    public Espectador(String nome, String endereco, String telefone, String email, String local, String enderecocomercial, Date data, String cpf, String rg, String login, String senha) {
        Espectador.genID =++Espectador.genID;
        this.id = Espectador.genID;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.local = local;
        this.enderecocomercial = enderecocomercial;
        this.data = data; //tratar quando for ler
        this.cpf = cpf;
        this.rg = rg;
        this.login = login;
        this.senha = senha;
        Espectador.escrever(this);
    }
    public Espectador()
    {
    }

    public static void escrever (Espectador espectador) {
        PrintWriter printWriter = null;
        try {
            arq.createNewFile();
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
            FileWriter fileWriter = new FileWriter(arq, true);

            //Agora vamos usar a classe PrintWriter para escrever
            //fisicamente no arquivo.
            //Precisamos passar o objeto FileReader em seu construtor
            printWriter = new PrintWriter(fileWriter);

            //Agora vamos escrever no arquivo com o método  println(),
            // que nos permite escrever linha a linha no arquivo

                printWriter.println("");

            printWriter.print(espectador.getId());
            printWriter.print(";");
            printWriter.print(espectador.getNome());
            printWriter.print(";");
            printWriter.print(espectador.getEndereco());
            printWriter.print(";");
            printWriter.print(espectador.getTelefone());
            printWriter.print(";");
            printWriter.print(espectador.getEmail());
            printWriter.print(";");
            printWriter.print(espectador.getLocal());
            printWriter.print(";");
            printWriter.print(espectador.getEnderecocomercial());
            printWriter.print(";");
            printWriter.print(espectador.getData());
            printWriter.print(";");
            printWriter.print(espectador.getCpf());
            printWriter.print(";");
            printWriter.print(espectador.getRg());
            printWriter.print(";");
            printWriter.print(espectador.getLogin());
            printWriter.print(";");
            printWriter.print(espectador.getSenha());
            printWriter.print(";");


            //o método flush libera a escrita no arquivo
            printWriter.flush();
        } catch (IOException e) {
            System.out.println("Não foi possível escrever no arquivo");
        } finally {
            printWriter.close();
        }
    }

    public static void ler( int id) {
        Reader fileReader = null;
        boolean existe = arq.exists();
        Espectador espectador=null;
        try {
            if (existe) {
                fileReader = new InputStreamReader(new FileInputStream(arq), "UTF8");
                BufferedReader br = new BufferedReader(fileReader);
                String linha = br.readLine();
                while (linha!=null)
                {
                    if(!(linha.equals(""))) {
					linha = Espectador.removeUTF8BOM(linha);
                    String[] dados = linha.split(";");
                    //System.out.println(dados[0]);
                    int t= Integer.parseInt(dados[0]);
                    

                    if (t == id) {
						espectador = new Espectador();
                        espectador.setId(t);
                        espectador.setNome(dados[1]);
                        espectador.setEndereco(dados[2]);
                        espectador.setTelefone(dados[3]);
                        espectador.setEmail(dados[4]);
                        espectador.setLocal(dados[5]);
                        espectador.setEnderecocomercial(dados[6]);
                        espectador.setData(Long.parseLong(dados[7]));
                        espectador.setCpf(dados[8]);
                        espectador.setRg(dados[9]);
                        espectador.setLogin(dados[10]);
                        espectador.setSenha(dados[11]);
                    }
                }
                   linha = br.readLine();
                }

                }

            }
        catch (IOException e) {
            System.out.println("Não foi possível alterar o arquivo");
        }

        finally {
            try {
                fileReader.close();
            }
            catch (IOException e)
            {
                System.out.println("Não foi possível alterar o arquivo");
            }

        }
		
			if(espectador!=null)
			{
			espectador.imprimeDados();
			}
			else
				System.out.println("Registro Não encontrado");

    }
	public static void RelEspectadores() {
		 Reader fileReader = null;
        boolean existe = arq.exists();
        Espectador espectador;
		LinkedList<Espectador> listaTodos = new LinkedList<Espectador>();
        try {
            if (existe) {
                fileReader = new InputStreamReader(new FileInputStream(arq), "UTF8");
                BufferedReader br = new BufferedReader(fileReader);
                String linha = br.readLine();
				
                while (linha!=null)
                {
                    if(!(linha.equals(""))) {
					linha = Espectador.removeUTF8BOM(linha);
                    String[] dados = linha.split(";");
                    //System.out.println(dados[0]);
                    int t= Integer.parseInt(dados[0]);
                    espectador = new Espectador();

                    
                        espectador.setId(t);
                        espectador.setNome(dados[1]);
                        espectador.setEndereco(dados[2]);
                        espectador.setTelefone(dados[3]);
                        espectador.setEmail(dados[4]);
                        espectador.setLocal(dados[5]);
                        espectador.setEnderecocomercial(dados[6]);
                        espectador.setData(Long.parseLong(dados[7]));
                        espectador.setCpf(dados[8]);
                        espectador.setRg(dados[9]);
                        espectador.setLogin(dados[10]);
                        espectador.setSenha(dados[11]);
						listaTodos.add(espectador);
                    
                }
                   linha = br.readLine();				   
                }
				
                }

            }
        catch (IOException e) {
            System.out.println("Não foi possível alterar o arquivo");
        }
		
        finally {
            try {
                fileReader.close();
            }
            catch (IOException e)
            {
                System.out.println("Não foi possível alterar o arquivo");
            }
			

        }
		if(listaTodos!=null)
		{
			Collections.sort(listaTodos);
			for(Espectador e : listaTodos)
			{
				e.imprimeDados();
			}
			
		}
		
	}

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getLocal() {
        return local;
    }

    public String getEnderecocomercial() {
        return enderecocomercial;
    }

    public Long getData() {
        return this.data.getTime();
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public void setEnderecocomercial(String enderecocomercial) {
        this.enderecocomercial = enderecocomercial;
    }

    public void setData(Long tempo) {
        this.data = new Date(tempo);
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
	private static String removeUTF8BOM(String s) {
        if (s.startsWith(UTF8_BOM)) {
            s = s.substring(1);
        }
        return s;
    }
	
	public void imprimeDados()
	{
			System.out.println("\nId:"+ this.getId());
            System.out.println("Nome:" + this.getNome());
            System.out.println("Endereço: " + this.getEndereco());
            System.out.println("Telefone: "+this.getTelefone());
            System.out.println("E-mail: " +this.getEmail());
            System.out.println("Local de Trabalho: " +this.getLocal());
            System.out.println("Endereço Comercial: " +this.getEnderecocomercial());
            System.out.println("Data de Nascimento: "+this.getData());
            System.out.println("CPF: " + this.getCpf());
            System.out.println("RG: " +this.getRg());
            System.out.println("Login: "+this.getLogin());
	}
	
	public int compareTo(Espectador outro)
	{
		return this.getNome().compareTo(outro.getNome());
	}

}

