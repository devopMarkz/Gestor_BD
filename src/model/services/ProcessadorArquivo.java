package model.services;

import model.entities.Emprestimo;
import model.entities.ItemBiblioteca;

import java.util.List;

public interface ProcessadorArquivo {

    List<ItemBiblioteca> carregarItens(String caminhoArquivo);

    List<Emprestimo> carregarEmprestimos(String caminhoArquivo);

    void salvarItens(List<ItemBiblioteca> itens, String caminhoArquivo);

    void salvarEmprestimos(List<Emprestimo> emprestimos, String caminhoArquivo);

}
