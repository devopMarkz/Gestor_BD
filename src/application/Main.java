package application;

import model.entities.Emprestimo;
import model.entities.GestorEmprestimo;
import model.entities.Inventario;
import model.entities.ItemBiblioteca;
import model.services.BuscadorArquivoTxt;
import model.services.ProcessadorArquivoTxt;

import java.time.LocalDate;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        Inventario<ItemBiblioteca> inv = new Inventario<>();

        GestorEmprestimo g = new GestorEmprestimo(inv, new ProcessadorArquivoTxt(), new BuscadorArquivoTxt());

        Predicate<ItemBiblioteca> p = itemBiblioteca -> itemBiblioteca.getTitulo().equals("A noiva cadáver");

        System.out.println(g.getInventario().buscarItem(p));

    }
}