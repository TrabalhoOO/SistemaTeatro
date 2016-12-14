package sistemateatro;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TipoEspetaculoDao implements Dao {

    private static void escrever(TipoEspetaculo tipoEspetaculo) {
        File arq = tipoEspetaculo.getArq();
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

            bufferedWriter.write(Integer.toString(tipoEspetaculo.getIdTipoEspetaculo()));
            bufferedWriter.write(";");
            bufferedWriter.write(tipoEspetaculo.getNome());
            bufferedWriter.write(";");
            bufferedWriter.write(tipoEspetaculo.getDescricao());
            bufferedWriter.write(";");
            bufferedWriter.newLine();

            //o método flush libera a escrita no arquivo
            fileWriter.flush();
            bufferedWriter.flush();

        } catch (IOException e) {
            System.out.println("Não foi possível escrever no arquivo");
        } finally {
            try {
                fileWriter.close();
                bufferedWriter.close();
                System.out.println("Cadastro realizado com sucesso");
            } catch (IOException e) {
                System.out.println("Não foi possível alterar o arquivo");
            }
        }
    }

    TipoEspetaculo tipoEspetaculo = new TipoEspetaculo();
    public static final String UTF8_BOM = "\uFEFF";

    @Override
    public void Incluir() {
        Scanner leia = new Scanner(System.in);
        System.out.println("Forneça os dados: \n");
        System.out.println("Informe o Tipo do Espetáculo: ");
        String nome = leia.nextLine();
        System.out.println("Informe uma Descrição: ");
        String descricao = leia.nextLine();

        GeradorID gerador = new GeradorID();
        int id = gerador.genID(this.tipoEspetaculo);
        if (id > 0) {
            tipoEspetaculo.setIdTipoEspetaculo(id);
        } else {
            System.out.println("Erro na inserção");
        }
        this.tipoEspetaculo.setNome(nome);
        this.tipoEspetaculo.setDescricao(descricao);
        TipoEspetaculoDao.escrever(tipoEspetaculo);
    }

    @Override
    public void Alterar() {
        System.out.println("Informe o Código do Tipo do Espetáculo\n");
        Scanner leia = new Scanner(System.in);
        int codigo = 0;
        try {
            codigo = Integer.parseInt(leia.nextLine());
        } catch (InputMismatchException e) {
            boolean valido = false;
            while (!valido) {
                System.out.println("Valor Inválido");
                codigo = Integer.parseInt(leia.nextLine());
            }
        }
        TipoEspetaculo tipoEspetaculo = TipoEspetaculo.buscaID(codigo);
        TipoEspetaculo newTipoEspetaculo = new TipoEspetaculo();
        System.out.println("Qual campo deseja alterar?\n");
        this.FinalizaAlteracao(tipoEspetaculo, newTipoEspetaculo);

    }

    @Override
    public void Excluir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void FinalizaAlteracao(TipoEspetaculo tipoEspetaculo, TipoEspetaculo newTipoEspetaculo) {
        newTipoEspetaculo.setIdTipoEspetaculo(tipoEspetaculo.getIdTipoEspetaculo());
        newTipoEspetaculo.setNome(tipoEspetaculo.getNome());
        newTipoEspetaculo.setDescricao(tipoEspetaculo.getDescricao());
        newTipoEspetaculo.setPreferencia(tipoEspetaculo.getPreferencia());
        System.out.println(
                "1-Tipo do Espetáculo\n"
                + "2-Descrição do Tipo do Espetáculo\n"
        );
        Scanner leia = new Scanner(System.in);
        System.out.println("Informe a opção selecionada");
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
        while (opcao != 6) {

            switch (opcao) {
                case 1:
                    System.out.println("Tipo de Espetáculo: " + tipoEspetaculo.getNome());
                    System.out.println("Novo Tipo de Espetáculo : ");
                    String nome = leia.nextLine();
                    newTipoEspetaculo.setNome(nome);
                    break;
                case 2:
                    System.out.println("Descrição do Tipo de Espetáculo: " + tipoEspetaculo.getDescricao());
                    System.out.println("Nova Descrição do Tipo de Espetáculo : ");
                    String descricao = leia.nextLine();
                    newTipoEspetaculo.setDescricao(descricao);
                    break;
            }

        }
        this.Copia(tipoEspetaculo, newTipoEspetaculo);
    }

    private void Copia(TipoEspetaculo tipoEspetaculo, TipoEspetaculo newTipoEspetaculo) {
        String linhaAlterar = TipoEspetaculo.TransformarEmLinha(tipoEspetaculo);
        String linhaAlterada = TipoEspetaculo.TransformarEmLinha(newTipoEspetaculo);
        File file = tipoEspetaculo.getArq();
        File nf = new File("Dados", "temporario.tmp");
        FileWriter fw = null;
        Scanner s = null;
        BufferedWriter bufferedWriter = null;
        try {
            fw = new FileWriter(nf);
            s = new Scanner(file);
            bufferedWriter = new BufferedWriter(fw);
            while (s.hasNextLine()) {
                String linha = s.nextLine();
                if (linha.equals(linhaAlterar)) {
                    linha = linha.replace(linhaAlterar, linhaAlterada);
                }

                bufferedWriter.write(linha);
                bufferedWriter.newLine();

                fw.flush();
                bufferedWriter.flush();
                fw.close();
                bufferedWriter.close();

            }
            fw = new FileWriter(file, false);
            s = new Scanner(nf);
            bufferedWriter = new BufferedWriter(fw);
            while (s.hasNextLine()) {
                String linha = s.nextLine();
                bufferedWriter.write(linha);
                bufferedWriter.newLine();

                fw.flush();
                bufferedWriter.flush();
                System.out.println("Alteração realizada com sucesso");

            }
        } catch (IOException e) {
            System.out.println("Não foi possível escrever no arquivo");
        } finally {
            try {
                fw.close();
                bufferedWriter.close();

            } catch (IOException e) {
                System.out.println("Não foi possível alterar o arquivo");
            }
        }

    }

    private void Copia(TipoEspetaculo tipoEspetaculo) {
        String linhaExcluir = TipoEspetaculo.TransformarEmLinha(tipoEspetaculo);
        File file = tipoEspetaculo.getArq();
        File nf = new File("Dados", "temporario.tmp");
        FileWriter fw = null;
        Scanner s = null;
        BufferedWriter bufferedWriter = null;
        try {
            fw = new FileWriter(nf, false);
            s = new Scanner(file);
            bufferedWriter = new BufferedWriter(fw);
            while (s.hasNextLine()) {
                String linha = s.nextLine();
                if (!(linha.equals(linhaExcluir))) {
                    bufferedWriter.write(linha);
                    bufferedWriter.newLine();
                    fw.flush();
                    bufferedWriter.flush();
                    fw.close();
                    bufferedWriter.close();
                }

            }
            fw = new FileWriter(file, false);
            s = new Scanner(nf);
            bufferedWriter = new BufferedWriter(fw);
            while (s.hasNextLine()) {
                String linha = s.nextLine();
                bufferedWriter.write(linha);
                bufferedWriter.newLine();

                fw.flush();
                bufferedWriter.flush();
                System.out.println("Exclusão realizada com sucesso");

            }
        } catch (IOException e) {
            System.out.println("Não foi possível escrever no arquivo");
        } finally {
            try {
                fw.close();
                bufferedWriter.close();

            } catch (IOException e) {
                System.out.println("Não foi possível alterar o arquivo");
            }
        }

    }
}
