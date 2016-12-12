package sistemateatro;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

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
                    System.out.println("Valor Total a ser Pago: " + compra.getValorTotal());
                    for (int i = 0; i < quantidade; i++) {
                        Sala.ExibirVagas();
                        System.out.println("Informe o número do " + i + "º assento");
                        String numAssento = leia.nextLine();
                        int Assento = Integer.parseInt(numAssento);
                        if (Sala.HaVaga(Assento)) {
                            compra.setAssentos(Assento);
                            
                        }
                        
                    }
                    this.finalizarCompra();
                    break;
                }
            }
            
        } else {
            System.out.println("Nâo há Espetáculos Disponíveis");
            
        }
        
    }

    private void finalizarCompra() {
        Scanner leia = new Scanner(System.in);
        LinkedList<FormaPagamento> lista = FormaPagamento.buscaTodos();
        System.out.println("Escolha a Forma de Pagamento e informe o código Escolhido: \n");
        if (lista != null) {
            for (FormaPagamento forma : lista) {
                  System.out.println(forma.getIdForma() + "-" + forma.getDescricao());
            }
            String opcao;
            opcao = leia.nextLine();
            for (FormaPagamento forma : lista) {
                int id = Integer.parseInt(opcao);
                if (forma.getIdForma() == id) {
                    this.compra.setFk_FormaPagamento(forma);
                }
            }
            
        }
}
}
