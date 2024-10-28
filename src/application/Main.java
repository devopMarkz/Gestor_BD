package application;

import model.entities.Emprestimo;
import model.entities.GestorEmprestimo;
import model.entities.Inventario;
import model.services.BuscadorArquivoTxt;
import model.services.ProcessadorArquivoTxt;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        GestorEmprestimo g = new GestorEmprestimo(new Inventario(), new ProcessadorArquivoTxt(), new BuscadorArquivoTxt());

        g.getInventario().getItens().forEach(System.out::println);

        g.getEmprestimos().forEach(System.out::println);

    }
}