/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemateatro;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author jpdia
 */
public class ApresentacaoDao implements Dao {

    Apresentacao apresentacao = new Apresentacao();

    /**
     *
     */
    public static final String UTF8_BOM = "\uFEFF";

    /**
     *
     */
    @Override
    public void Incluir() {
        Scanner leia = new Scanner(System.in);
        System.out.println("Forneça os dados: \n");
        System.out.println("Informe o número da Sala: ");
        String sala;
        boolean valido = false;
        while (!valido) {
            sala = leia.nextLine();
            Sala s = Sala.buscaID(Integer.parseInt(sala));
            if (s != null) {
                this.apresentacao.setFk_Sala(s);
                valido = true;
            } else {
                System.out.println("Sala não Encontrada. Informe novamente: ");

            }

        }
        System.out.println("Informe o código do Espetáculo: ");
        String espetaculo;
        valido = false;
        while (!valido) {
            espetaculo = leia.nextLine();
            Espetaculo e = Espetaculo.buscaID(Integer.parseInt(espetaculo));
            if (e != null) {
                this.apresentacao.setFk_Espetaculo(e);
                valido = true;
            } else {
                System.out.println("Espetáculo não Encontrada. Informe novamente: ");

            }

        }
        System.out.println("Informe a data do Espetáculo: ");
        String data = leia.nextLine();
        valido = false;
        Date dt = null;
        while (!valido) {

            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            df.setLenient(false);
            try {
                dt = df.parse(data);
                valido = true;
            } catch (ParseException ex) {
                System.out.println("Data Inválida! Digite Novamente: ");
                data = leia.nextLine();
            }
        }
        System.out.println("Informe a hora do Espetáculo: ");
        String hora = leia.nextLine();
        valido = false;
        Date horario = null;
        while (!valido) {

            DateFormat hf = new SimpleDateFormat("HH:mm");
            hf.setLenient(false);
            try {
                horario = hf.parse(hora);
                valido = true;
            } catch (ParseException ex) {
                System.out.println("Hora Inválida! Digite Novamente: ");
                hora = leia.nextLine();
            }
        }
        System.out.println("Informe o valor do Espetáculo: ");
        double valor = Double.parseDouble(leia.nextLine());
        GeradorID gerador = new GeradorID();
        int id = gerador.genID(this.apresentacao);
        if (id > 0) {
            apresentacao.setIdApresentacao(id);
        } else {
            System.out.println("Erro na inserção");
        }
        this.apresentacao.setData(dt.getTime());
        this.apresentacao.setHorario(horario.getTime());
        this.apresentacao.setValorIngresso(valor);
        ApresentacaoDao.escrever(apresentacao);

    }

    private static void escrever(Apresentacao apresentacao) {
        File arq = apresentacao.getArq();
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

            bufferedWriter.write(Integer.toString(apresentacao.getIdApresentacao()));
            bufferedWriter.write(";");
            bufferedWriter.write(Integer.toString(apresentacao.getFk_Sala().getIdSala()));
            bufferedWriter.write(";");
            bufferedWriter.write(Integer.toString(apresentacao.getFk_Espetaculo().getIdEspetaculo()));
            bufferedWriter.write(";");
            bufferedWriter.write(Long.toString(apresentacao.getData()));
            bufferedWriter.write(";");
            bufferedWriter.write(Long.toString(apresentacao.getHorario()));
            bufferedWriter.write(";");
            bufferedWriter.write(Double.toString(apresentacao.getValorIngresso()));
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

    /**
     *
     */
    @Override
    public void Alterar() {
        System.out.println("Informe o Código da Apresentação\n");
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
        Apresentacao apresentacao = Apresentacao.buscaID(codigo);
        Apresentacao newapresentacao = new Apresentacao();
        System.out.println("Qual campo deseja alterar?\n");
        this.FinalizaAlteracao(apresentacao, newapresentacao);

    }

    /**
     *
     */
    @Override
    public void Excluir() {
        System.out.println("Informe o Código da Apresentação que deseja excluir\n");
        Scanner leia = new Scanner(System.in);
        int codigo = 0;
        try {
            codigo = leia.nextInt();
        } catch (InputMismatchException e) {
            boolean valido = false;
            while (!valido) {
                System.out.println("Valor Inválido");
                codigo = leia.nextInt();
            }
        }
        Apresentacao apresentacao = Apresentacao.buscaID(codigo);
        if (apresentacao != null) {
            this.Copia(apresentacao);

        } else {
            System.out.println("Apresentação não encontrada! Exclusão Cancelada");

        }

    }

    private void FinalizaAlteracao(Apresentacao apresentacao, Apresentacao newapresentacao) {
        newapresentacao.setIdApresentacao(apresentacao.getIdApresentacao());
        newapresentacao.setFk_Sala(apresentacao.getFk_Sala());
        newapresentacao.setFk_Espetaculo(apresentacao.getFk_Espetaculo());
        newapresentacao.setData(apresentacao.getData());
        newapresentacao.setHorario(apresentacao.getHorario());
        newapresentacao.setValorIngresso(apresentacao.getValorIngresso());
        System.out.println("1-Código do Espetaculo\n"
                + "2-Data da Apresentação\n"
                + "3-Horário da Apresentação\n"
                + "4-Valor Do ingresso\n"
                + "5-Sair\n");
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

        while (opcao != 5) {

            switch (opcao) {
                case 1:
                    System.out.println("Número da Sala: " + newapresentacao.getFk_Sala().getIdSala());
                    System.out.println("Nova Sala: ");
                    valido = false;
                    while (!valido) {
                        int id = Integer.parseInt(leia.nextLine());
                        Sala s = Sala.buscaID(id);
                        if (s != null) {
                            newapresentacao.setFk_Sala(s);
                            valido = true;
                            break;
                        } else {
                            System.out.println("Sala não Encontrada. Informe novamente: ");

                        }

                    }
                    break;
                case 2:
                    System.out.println("Código do Espetáculo: " + newapresentacao.getFk_Espetaculo().getIdEspetaculo());
                    System.out.println("Novo Espetáculo: ");
                    String espetaculo;
                    valido = false;
                    while (!valido) {
                        espetaculo = leia.nextLine();
                        Espetaculo e = Espetaculo.buscaID(Integer.parseInt(espetaculo));
                        if (e != null) {
                            newapresentacao.setFk_Espetaculo(e);
                            valido = true;
                        } else {
                            System.out.println("Espetáculo não Encontrada. Informe novamente: ");

                        }

                    }
                    break;
                case 3:
                    Date data = new Date();
                    data.setTime(newapresentacao.getData());
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    System.out.println("Data da Apresentação: " + format.format(data));
                    System.out.println("Nova Data da Apresentação: ");
                    String novadata = leia.nextLine();

                    valido = false;
                    while (!valido) {

                        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                        df.setLenient(false);
                        try {
                            data = df.parse(novadata);
                            newapresentacao.setData(data.getTime());
                            valido = true;
                        } catch (ParseException ex) {
                            System.out.println("Data Inválida! Digite Novamente: ");
                            novadata = leia.nextLine();
                        }
                    }
                    break;
                case 4:
                    Date hora = new Date();
                    hora.setTime(newapresentacao.getHorario());
                    SimpleDateFormat formatHora = new SimpleDateFormat("HH:mm");
                    System.out.println("Hora da Apresentação: " + formatHora.format(hora));
                    System.out.println("Nova Data da Apresentação: ");
                    String novahora = leia.nextLine();
                    valido = false;
                    while (!valido) {

                        DateFormat hf = new SimpleDateFormat("HH:mm");
                        hf.setLenient(false);
                        try {
                            hora = hf.parse(novahora);
                            newapresentacao.setHorario(hora.getTime());
                            valido = true;
                        } catch (ParseException ex) {
                            System.out.println("Hora Inválida! Digite Novamente: ");
                            novahora = leia.nextLine();
                        }
                    }
                    break;
                case 5:
                    System.out.println("Valor da Apresentação: " + newapresentacao.getValorIngresso());
                    System.out.println("Novo Valor: ");
                    double valor = Double.parseDouble(leia.nextLine());
                    newapresentacao.setValorIngresso(valor);
                    break;

            }

        }
        this.Copia(apresentacao, newapresentacao);
    }

    private void Copia(Apresentacao apresentacao, Apresentacao newapresentacao) {
        String linhaAlterar = Apresentacao.TransformarEmLinha(apresentacao);
        String linhaAlterada = Apresentacao.TransformarEmLinha(newapresentacao);
        File file = apresentacao.getArq();
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

    private void Copia(Apresentacao apresentacao) {
        String linhaExcluir = Apresentacao.TransformarEmLinha(apresentacao);
        File file = apresentacao.getArq();
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
