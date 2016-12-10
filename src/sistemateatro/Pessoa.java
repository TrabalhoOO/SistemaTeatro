package sistemateatro;

import java.io.*;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;

public class Pessoa implements Comparable<Pessoa>, Contavel {

    private int idPessoa;
    private static int genID = 0;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private String localTrabalho;
    private String enderecoComercial;
    private Date dataNasc;
    private String CPF;
    private String RG;
    private String login;
    private String senha;
    private int nivelAcesso;
    private LinkedList<Preferencia> preferencia = new LinkedList<>();
    private LinkedList<Compra> compra = new LinkedList<>();
    private static final File arq = new File("", "Pessoa.txt");
    public static final String UTF8_BOM = "\uFEFF";

    public Pessoa() {
    }

    public Pessoa(String nome, String endereco, String telefone, String email, String local, String enderecocomercial, Date data, String cpf, String rg, String login, String senha, int nivel) {
        GeradorID gerador = new GeradorID();
        if (gerador.genID(this) > 0) {
            this.idPessoa = gerador.genID(this);
        } else {
            System.out.println("Erro na inserção");
        }
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.localTrabalho = local;
        this.enderecoComercial = enderecocomercial;
        this.dataNasc = data; //tratar quando for ler
        this.CPF = cpf;
        this.RG = rg;
        this.login = login;
        this.senha = senha;
        this.nivelAcesso = nivel;
        Pessoa.escrever(this);
    }

    public LinkedList<Preferencia> getPreferencia() {
        return preferencia;
    }

    public void setPreferencia(LinkedList<Preferencia> preferencia) {
        this.preferencia = preferencia;
    }

    public LinkedList<Compra> getCompra() {
        return compra;
    }

    public void setCompra(LinkedList<Compra> compra) {
        this.compra = compra;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocalTrabalho() {
        return localTrabalho;
    }

    public void setLocalTrabalho(String localTrabalho) {
        this.localTrabalho = localTrabalho;
    }

    public String getEnderecoComercial() {
        return enderecoComercial;
    }

    public void setEnderecoComercial(String enderecoComercial) {
        this.enderecoComercial = enderecoComercial;
    }

    public Long getDataNasc() {
        return this.dataNasc.getTime();
    }

    public void setDataNasc(Long tempo) {
        this.dataNasc = new Date(tempo);
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(int nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }
    
    @Override
     public int compareTo(Pessoa outro) {
        return this.getNome().compareTo(outro.getNome());
    }

    private static String removeUTF8BOM(String s) {
        if (s.startsWith(UTF8_BOM)) {
            s = s.substring(1);
        }
        return s;
    }
    @Override
    public File getArq() {
        return arq;
    }

    public static void escrever(Pessoa pessoa) {
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

            printWriter.print(pessoa.getIdPessoa());
            printWriter.print(";");
            printWriter.print(pessoa.getNome());
            printWriter.print(";");
            printWriter.print(pessoa.getEndereco());
            printWriter.print(";");
            printWriter.print(pessoa.getTelefone());
            printWriter.print(";");
            printWriter.print(pessoa.getEmail());
            printWriter.print(";");
            printWriter.print(pessoa.getLocalTrabalho());
            printWriter.print(";");
            printWriter.print(pessoa.getEnderecoComercial());
            printWriter.print(";");
            printWriter.print(pessoa.getDataNasc());
            printWriter.print(";");
            printWriter.print(pessoa.getCPF());
            printWriter.print(";");
            printWriter.print(pessoa.getRG());
            printWriter.print(";");
            printWriter.print(pessoa.getLogin());
            printWriter.print(";");
            printWriter.print(pessoa.getSenha());
            printWriter.print(";");

            //o método flush libera a escrita no arquivo
            printWriter.flush();
        } catch (IOException e) {
            System.out.println("Não foi possível escrever no arquivo");
        } finally {
            printWriter.close();
        }
    }

    

    public static void RelPessoas() {
        Reader fileReader = null;
        boolean existe = arq.exists();
        Pessoa pessoa;
        LinkedList<Pessoa> listaTodos = null;
        try {
            if (existe) {
                fileReader = new InputStreamReader(new FileInputStream(arq), "UTF8");
                BufferedReader br = new BufferedReader(fileReader);
                String linha = br.readLine();
                listaTodos = new LinkedList<>();
                while (linha != null) {
                    if (!(linha.equals(""))) {
                        linha = Pessoa.removeUTF8BOM(linha);
                        String[] dados = linha.split(";");
                        //System.out.println(dados[0]);
                        int t = Integer.parseInt(dados[0]);
                        pessoa = new Pessoa();

                        pessoa.setIdPessoa(t);
                        pessoa.setNome(dados[1]);
                        pessoa.setEndereco(dados[2]);
                        pessoa.setTelefone(dados[3]);
                        pessoa.setEmail(dados[4]);
                        pessoa.setLocalTrabalho(dados[5]);
                        pessoa.setEnderecoComercial(dados[6]);
                        pessoa.setDataNasc(Long.parseLong(dados[7]));
                        pessoa.setCPF(dados[8]);
                        pessoa.setRG(dados[9]);
                        pessoa.setLogin(dados[10]);
                        pessoa.setSenha(dados[11]);

                        listaTodos.add(pessoa);

                    }
                    linha = br.readLine();
                }

            }

        } catch (IOException e) {
            System.out.println("Não foi possível alterar o arquivo");
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Não foi possível alterar o arquivo");
            }

        }
        if (listaTodos != null) {
            Collections.sort(listaTodos);
            for (Pessoa e : listaTodos) {
                e.imprimeDados();
            }

        }

    }

    public void imprimeDados() {
        System.out.println("\nId:" + this.getIdPessoa());
        System.out.println("Nome:" + this.getNome());
        System.out.println("Endereço: " + this.getEndereco());
        System.out.println("Telefone: " + this.getTelefone());
        System.out.println("E-mail: " + this.getEmail());
        System.out.println("Local de Trabalho: " + this.getLocalTrabalho());
        System.out.println("Endereço Comercial: " + this.getEnderecoComercial());
        System.out.println("Data de Nascimento: " + this.getDataNasc());
        System.out.println("CPF: " + this.getCPF());
        System.out.println("RG: " + this.getRG());
        System.out.println("Login: " + this.getLogin());
    }

   
}
