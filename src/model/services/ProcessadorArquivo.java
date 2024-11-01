package model.services;

import model.entities.Emprestimo;
import model.entities.GestorEmprestimo;
import model.entities.ItemBiblioteca;

import java.io.File;
import java.util.List;

public interface ProcessadorArquivo {

    List<ItemBiblioteca> carregarItens(File caminhoArquivo);

    List<Emprestimo> carregarEmprestimos(File caminhoArquivo, GestorEmprestimo gestorEmprestimo);

    void salvarItens(List<ItemBiblioteca> itens, File caminhoArquivo);

    void salvarEmprestimos(List<Emprestimo> emprestimos, File caminhoArquivo);

}
