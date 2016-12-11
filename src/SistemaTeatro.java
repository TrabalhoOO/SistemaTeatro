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
import sistemateatro.Dao;
import sistemateatro.Espectador;
import sistemateatro.Pessoa;
import sistemateatro.PessoaDao;
import sistemateatro.Tela;

public class SistemaTeatro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            Pessoa pessoa = new Pessoa();
            if(!pessoa.getArq().exists())
            {
                PessoaDao mantenedor = new PessoaDao();
                mantenedor.IncluirMantenedor();
            
            }
            Tela tela = new Tela();
            tela.RealizarLogin();
            
            Pessoa.RelPessoas();
    }
}
