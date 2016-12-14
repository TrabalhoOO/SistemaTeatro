package sistemateatro;

import java.io.*;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;

/**
 *
 * @author jpdia
 */
public class Pessoa implements Comparable<Pessoa>, Contavel {

    private int idPessoa;
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
    private static final File arq = new File("Dados", "Pessoa.txt");

    /**
     *
     */
    public static final String UTF8_BOM = "\uFEFF";

    /**
     *
     */
    public Pessoa() {
    }

    /**
     *
     * @return
     */
    public LinkedList<Preferencia> getPreferencia() {
        return preferencia;
    }

    /**
     *
     * @param preferencia
     */
    public void setPreferencia(LinkedList<Preferencia> preferencia) {
        this.preferencia = preferencia;
    }

    /**
     *
     * @return
     */
    public LinkedList<Compra> getCompra() {
        return compra;
    }

    /**
     *
     * @param compra
     */
    public void setCompra(LinkedList<Compra> compra) {
        this.compra = compra;
    }

    /**
     *
     * @return
     */
    public int getIdPessoa() {
        return idPessoa;
    }

    /**
     *
     * @param idPessoa
     */
    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    /**
     *
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @return
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     *
     * @param endereco
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     *
     * @return
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     *
     * @param telefone
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public String getLocalTrabalho() {
        return localTrabalho;
    }

    /**
     *
     * @param localTrabalho
     */
    public void setLocalTrabalho(String localTrabalho) {
        this.localTrabalho = localTrabalho;
    }

    /**
     *
     * @return
     */
    public String getEnderecoComercial() {
        return enderecoComercial;
    }

    /**
     *
     * @param enderecoComercial
     */
    public void setEnderecoComercial(String enderecoComercial) {
        this.enderecoComercial = enderecoComercial;
    }

    /**
     *
     * @return
     */
    public Long getDataNasc() {
        return this.dataNasc.getTime();
    }

    /**
     *
     * @param tempo
     */
    public void setDataNasc(Long tempo) {
        this.dataNasc = new Date(tempo);
    }

    /**
     *
     * @return
     */
    public String getCPF() {
        return CPF;
    }

    /**
     *
     * @param CPF
     */
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    /**
     *
     * @return
     */
    public String getRG() {
        return RG;
    }

    /**
     *
     * @param RG
     */
    public void setRG(String RG) {
        this.RG = RG;
    }

    /**
     *
     * @return
     */
    public String getLogin() {
        return login;
    }

    /**
     *
     * @param login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     *
     * @return
     */
    public String getSenha() {
        return senha;
    }

    /**
     *
     * @param senha
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     *
     * @return
     */
    public int getNivelAcesso() {
        return nivelAcesso;
    }

    /**
     *
     * @param nivelAcesso
     */
    public void setNivelAcesso(int nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    @Override
    public int compareTo(Pessoa outro) {
        return this.getNome().compareTo(outro.getNome());
    }

    /**
     *
     * @return
     */
    @Override
    public File getArq() {
        return arq;
    }

    /**
     *
     * @param codigo
     * @return
     */
    public static Pessoa buscaID(int codigo) {
        Reader fileReader = null;
        boolean existe = arq.exists();
        Pessoa pessoa = null;
        try {
            if (existe) {
                fileReader = new FileReader(arq.getAbsolutePath());
                BufferedReader br = new BufferedReader(fileReader);
                String linha = br.readLine();
                while (linha != null) {
                    linha = Pessoa.removeUTF8BOM(linha);
                    if (!(linha.equals(""))) {
                        String[] dados = linha.split(";");
                        int id = Integer.parseInt(dados[0]);

                        if (id == codigo) {
                            pessoa = new Pessoa();
                            pessoa.setIdPessoa(id);
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
                            pessoa.setNivelAcesso(Integer.parseInt(dados[12]));
                            return pessoa;
                        }
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
        return null;
    }

    /**
     *
     * @param login
     * @return
     */
    public static boolean buscaLogin(String login) {
        Reader fileReader = null;
        boolean existe = arq.exists();
        try {
            if (existe) {
                fileReader = new FileReader(arq.getAbsolutePath());
                BufferedReader br = new BufferedReader(fileReader);
                String linha = br.readLine();
                while (linha != null) {
                    linha = Pessoa.removeUTF8BOM(linha);
                    if (!(linha.equals(""))) {
                        String[] dados = linha.split(";");
                        if (login.equals(dados[10])) {
                            System.out.println("Login já existente. Digite novamente: ");
                            return true;
                        }
                    }
                    linha = br.readLine();
                }
                return false;
            }

        } catch (IOException e) {
            System.out.println("Não foi possível alterar o arquivo");
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    System.out.println("Não foi possível fechar o arquivo");
                }
            } else {
                return false;
            }

        }

        return false;
    }

    /**
     *
     * @param login
     * @param senha
     * @return
     */
    public static Pessoa Login(String login, String senha) {
        Reader fileReader = null;
        boolean existe = arq.exists();
        try {
            if (existe) {
                fileReader = new FileReader(arq.getAbsolutePath());
                BufferedReader br = new BufferedReader(fileReader);
                String linha = br.readLine();
                Pessoa pessoa;
                while (linha != null) {
                    linha = Pessoa.removeUTF8BOM(linha);
                    if (!(linha.equals(""))) {
                        String[] dados = linha.split(";");
                        System.out.println(dados[10]);
                        if (login.equals(dados[10])) {
                            if (senha.equals(dados[11])) {
                                pessoa = new Pessoa();
                                pessoa.setIdPessoa(Integer.parseInt(dados[0]));
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
                                pessoa.setNivelAcesso(Integer.parseInt(dados[12]));
                                return pessoa;
                            } else {
                                System.out.println("Senha Incorreta");
                                return null;
                            }
                        }
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
                System.out.println("Não foi possível fechar o arquivo");
            }

        }
        System.out.println("Login inexistente");
        return null;
    }

    /**
     *
     */
    public static void RelPessoas() {
        FileReader fileReader = null;
        boolean existe = arq.exists();
        Pessoa pessoa;
        LinkedList<Pessoa> listaTodos = null;
        if (existe) {
            try {

                fileReader = new FileReader(arq.getAbsolutePath());
                BufferedReader br = new BufferedReader(fileReader);
                String linha = br.readLine();
                listaTodos = new LinkedList<>();
                while (linha != null) {
                    linha = Pessoa.removeUTF8BOM(linha);
                    if (!(linha.equals(""))) {

                        String[] dados = linha.split(";");
                        pessoa = new Pessoa();
                        pessoa.setIdPessoa(Integer.parseInt(dados[0]));
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
                        pessoa.setNivelAcesso(Integer.parseInt(dados[12]));
                        listaTodos.add(pessoa);

                    }
                    linha = br.readLine();
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
        }

        if (listaTodos != null) {
            Collections.sort(listaTodos);
            for (Pessoa e : listaTodos) {
                e.imprimeDados();
            }

        }

    }

    /**
     *
     */
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
        if (this.getNivelAcesso() == 0) {
            System.out.println("Nível de Acesso: ADMINISTRADOR");
        } else {
            System.out.println("Nível de Acesso: ESPECTADOR");
        }
    }

    private static String removeUTF8BOM(String s) {
        if (s.startsWith(UTF8_BOM)) {
            s = s.substring(1);
        }
        return s;
    }
    
    /**
     *
     * @param pessoa
     * @return
     */
    public static String TransformarEmLinha(Pessoa pessoa)
    {
        String linha = Integer.toString(pessoa.getIdPessoa())
            +";"
            +pessoa.getNome()
            +";"
            +pessoa.getEndereco()
            +";"
            +pessoa.getTelefone()
            +";"
            +pessoa.getEmail()
            +";"
            +pessoa.getLocalTrabalho()
            +";"
            +pessoa.getEnderecoComercial()
            +";"
            +pessoa.getDataNasc().toString()
            +";"
            +pessoa.getCPF()
            +";"
            +pessoa.getRG()
            +";"
            +pessoa.getLogin()
            +";"
            +pessoa.getSenha()
            +";"
            +Integer.toString(pessoa.getNivelAcesso())
            +";";
        return linha;
    
    
    }
}
