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

public class EspetaculoDao implements Dao{

    Espetaculo espetaculo = new Espetaculo();
    public static final String UTF8_BOM = "\uFEFF";

    @Override
    public void Incluir() {
        Scanner leia = new Scanner(System.in);
        System.out.println("Forneça os dados: \n");
        System.out.println("Informe o nome do Espetaculo: ");
        String nome = leia.nextLine();
        System.out.println("Informe a descrição do espetaculo: ");
        String descricao = leia.nextLine();
        System.out.println("Informe a faixa etária: ");
        int faixaEtaria = leia.nextLine();
        System.out.println("Informe a duração do espetaculo em minutos: ");
        int duracaoMinutos = leia.nextLine();
        System.out.println("informe a quantidade de artistas: ");
        int artistas = leia.nextLine();
        for (int i = 0; i < artistas; i++) {
            System.out.println("Informe o codigo do " + i + "º artista: ");
            int codArtista = leia.nextLine();
            Artista artista = buscaID(Integer.parseInt(codArtista));
            if (artista != null) {
                espetaculo.setArtista(artista);
            } else {
                System.out.println("Artista não encontrado. Informe novamente!");
                i--;
            }
        }
    }
    System.out.println ("Informe a data de início: ");
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
    System.out.println ("Informe a data de término: ");
    String data1 = leia.nextLine();
        valido = false;
        Date dt1 = null;
        while (!valido) {

            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            df.setLenient(false);
            if (dt.compareTo(dt1)<0 && dt.compareTo(dt1)!=0){
                try {
                    dt = df.parse(data1);
                    valido = true;
                } catch (ParseException ex) {
                    System.out.println("Data Inválida! Digite Novamente: ");
                    data1 = leia.nextLine();
                }
            }else{
                System.out.println("Data Inválida! Digite Novamente: ");
                data1 = leia.nextLine();
            }
        }

    @Override
    public void Alterar() {

    }
    @Override
    public void Excluir() {

    }

};
