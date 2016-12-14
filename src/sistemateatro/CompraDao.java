package sistemateatro;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CompraDao {

    private Compra compra = new Compra();

    public void Incluir() {
        Scanner leia = new Scanner(System.in);
        System.out.println("Escolha o Espetáculo e informe o código Escolhido: \n");
        LinkedList<Apresentacao> lista = Apresentacao.buscaTodos();
        Date data = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date hora = new Date();
        SimpleDateFormat formathora = new SimpleDateFormat("HH:mm");
        if (lista != null) {
            for (Apresentacao a : lista) {
                data.setTime(a.getData());
                hora.setTime(a.getHorario());
                System.out.println(a.getIdApresentacao() + "-" + a.getFk_Espetaculo().getNome() + "\tData da Apresentação: " + format.format(data) + "\tHorário: " + formathora.format(hora));
            }
            String opcao;
            opcao = leia.nextLine();
            for (Apresentacao a : lista) {
                int id = Integer.parseInt(opcao);
                if (a.getIdApresentacao() == id) {
                    compra.setFk_Apresentacao(a);
                    System.out.println("Informe a quantidade de assentos a serem comprados: \n");
                    String quant = leia.nextLine();
                    int quantidade = Integer.parseInt(quant);
                    compra.setValorTotal(quantidade * a.getValorIngresso());

                    for (int i = 0; i < quantidade; i++) {
                        compra.getFk_Apresentacao().getFk_Sala().ExibirVagas();
                        System.out.println("Informe o número do " + i + "º assento");
                        String numAssento = leia.nextLine();
                        int Assento = Integer.parseInt(numAssento);
                        if (compra.getFk_Apresentacao().getFk_Sala().HaVaga(Assento)) {
                            compra.setAssentos(Assento);

                        }

                    }
                    System.out.println("Valor Total a ser Pago: " + compra.getValorTotal());
                    try {
                        this.finalizarCompra();
                    } catch (DataEspetaculoMenorQue3 e) {
                        e.getMessage();

                    }
                    break;
                }
            }

        } else {
            System.out.println("Nâo há Espetáculos Disponíveis");

        }

    }

    private void finalizarCompra() throws DataEspetaculoMenorQue3 {
        Scanner leia = new Scanner(System.in);
        System.out.println("Escolha a Forma de Pagamento e informe o código Escolhido: \n");
        System.out.println("1 - Cartão de Crédito\n"
                + "2 - Ficha Compensatória\n"
        );

        int opcao;
        opcao = Integer.parseInt(leia.nextLine());
        switch (opcao) {
            case 1:
                compra.setFormaPagamento("Cartão de Crédito");
                System.out.println("Digite a Bandeira do Cartão");
                this.compra.setBandeiraCartao(leia.nextLine());
                System.out.println("Digite o número do Cartão");
                this.compra.setNumeroCartao(leia.nextLine());
                System.out.println("Digite a Data de Validade do Cartão no formato Mês/Ano");
                this.compra.setDatavalidade(leia.nextLine());

            case 2:
                compra.setFormaPagamento("Ficha Compensatória");

                Long diferencaDias = (compra.getFk_Apresentacao().getData() - this.getDataAtual().getTime()) / (1000 * 60 * 60 * 24);
                double diferenca = Math.ceil(diferencaDias.doubleValue());
                if (diferenca > 3) {
                    String boleto = "34712.3653" + compra.getNumeroReserva();
                    System.out.println("Cliente: " + compra.getFk_Pessoa().getNome());
                    System.out.println("Valor Total " + compra.getValorTotal());
                    Calendar calendarData = Calendar.getInstance();
                    Date dataEspetaculo = new Date(compra.getFk_Apresentacao().getData());
                    calendarData.setTime(dataEspetaculo);
                    int numeroDiasParaSubtrair = 1;
                    // achar data de início
                    calendarData.add(Calendar.DATE, numeroDiasParaSubtrair);
                    Date dataVencimento = calendarData.getTime();
                    compra.setDataVencimento(dataVencimento.getTime());
                    System.out.println("Data de Vencimento: " + dataVencimento);
                } else {
                    throw new DataEspetaculoMenorQue3("O espetáculo acontecerá há 3 dias ou menos. Impossibilidade de Gerar Boleto");

                }

        }
        this.escrever(compra);

    }

    private void escrever(Compra compra) {
        File arq = compra.getArq();
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
            for (int i = 0; i < compra.getAssentos().size(); i++) {
                bufferedWriter.write(Integer.toString(compra.getNumeroReserva()));
                bufferedWriter.write(";");
                bufferedWriter.write(Integer.toString(compra.getAssentos().get(i)));
                bufferedWriter.write(";");
                bufferedWriter.write(Double.toString(compra.getValorTotal()));
                bufferedWriter.write(";");
                bufferedWriter.write(Long.toString(compra.getFk_Apresentacao().getIdApresentacao()));
                bufferedWriter.write(";");
                bufferedWriter.write(Long.toString(compra.getFk_Pessoa().getIdPessoa()));
                bufferedWriter.write(";");
                if (compra.getFormaPagamento().equals("Cartão de Crédito")) {
                    bufferedWriter.write((compra.getNumeroCartao()));
                    bufferedWriter.write(";");
                    bufferedWriter.write((compra.getBandeiraCartao()));
                    bufferedWriter.write(";");
                    bufferedWriter.write((compra.getDatavalidade()));
                    bufferedWriter.write(";");
                } else {
                    bufferedWriter.write(compra.getNumBoleto());
                    bufferedWriter.write(";");
                    bufferedWriter.write(Long.toString(compra.getDataVencimento()));
                    bufferedWriter.write(";");

                }
                bufferedWriter.newLine();
            }
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

    public Date getDataAtual() {
        Date date = new Date();
        return date;
    }

    public void VisulizarCompra(int idPessoa) {
        LinkedList<Compra> compras = Compra.ComprasporPessoa(idPessoa);
        for (Compra compra : compras) {
            System.out.println("Número da Reserva: " + compra.getNumeroReserva() + "\n");
            for (int i = 0; i < compra.getAssentos().size(); i++) {
                System.out.println("Assentos Comprados: " + compra.getAssentos().get(i) + ",");

            }
            System.out.println("\n");
            System.out.println("Valor Total: " + compra.getValorTotal() + "\n");
            System.out.println("Nome do Espetáculo: " + compra.getFk_Apresentacao().getFk_Espetaculo().getDescricao());
            System.out.println("Nome do Cliente: " + compra.getFk_Pessoa().getNome());
            if (compra.getFormaPagamento().equals("Cartão de Crédito")) {
                System.out.println("Forma de Pagamento: " + compra.getFormaPagamento());
                System.out.println("Número do Cartão: " + compra.getNumeroCartao());
                System.out.println("Bandeira do Cartão: " + compra.getBandeiraCartao());
                System.out.println("Data de Validade: " + compra.getDatavalidade());
            } else {
                compra.setNumeroCartao(dados[6]);
                compra.setBandeiraCartao(dados[7]);
                
            }

            System.out.println("Número da Reserva: " + compra.getNumeroReserva());

        }

    }
}
