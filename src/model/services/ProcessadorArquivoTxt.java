package model.services;

import model.entities.Emprestimo;
import model.entities.ItemBiblioteca;
import model.entities.Livro;
import model.entities.Revista;
import model.entities.enums.TipoItem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProcessadorArquivoTxt implements ProcessadorArquivo{

    @Override
    public List<ItemBiblioteca> carregarItens(String caminhoArquivo) {
        List<ItemBiblioteca> itens = new ArrayList<>();

        try (Scanner sc = new Scanner(new BufferedReader(new FileReader(caminhoArquivo)))){

            while (sc.hasNextLine()){
                String[] coluna = sc.nextLine().split(",");
                if(coluna[3].equals(TipoItem.LIVRO.name())){
                    String titulo = coluna[0];
                    Integer numeroDePaginas = Integer.parseInt(coluna[1]);
                    Boolean disponivel = Boolean.parseBoolean(coluna[2]);
                    TipoItem tipoItem = TipoItem.valueOf(coluna[3]);
                    String autor = coluna[4];

                    itens.add(new Livro(titulo, numeroDePaginas, disponivel, tipoItem, autor));
                }
                else {
                    String titulo = coluna[0];
                    Integer numeroDePaginas = Integer.parseInt(coluna[1]);
                    Boolean disponivel = Boolean.parseBoolean(coluna[2]);
                    TipoItem tipoItem = TipoItem.valueOf(coluna[3]);
                    String edicao = coluna[4];

                    itens.add(new Revista(titulo, numeroDePaginas, disponivel, tipoItem, edicao));
                }
            }

        } catch (IOException e){
            e.printStackTrace();
        }

        return itens;
    }

    @Override
    public void salvarEmprestimos(List<Emprestimo> emprestimos, String caminhoArquivo) {



    }
}
