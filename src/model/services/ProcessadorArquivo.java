package model.services;

import model.entities.Emprestimo;
import model.entities.ItemBiblioteca;

import java.util.List;

public interface ProcessadorArquivo {

    List<ItemBiblioteca> carregarItens(String caminhoArquivo);
    void salvarEmprestimos(List<Emprestimo> emprestimos, String caminhoArquivo);

}
