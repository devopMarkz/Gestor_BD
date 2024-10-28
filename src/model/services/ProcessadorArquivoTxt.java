package model.services;

import model.entities.Emprestimo;
import model.entities.ItemBiblioteca;
import model.entities.Livro;
import model.entities.Revista;
import model.entities.enums.TipoItem;

import java.io.*;
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

                String titulo = coluna[0];
                Integer numeroDePaginas = Integer.parseInt(coluna[1]);
                Boolean disponivel = Boolean.parseBoolean(coluna[2]);
                TipoItem tipoItem = TipoItem.valueOf(coluna[3]);

                if(coluna[3].equals(TipoItem.LIVRO.name())){
                    String autor = coluna[4];
                    itens.add(new Livro(titulo, numeroDePaginas, disponivel, tipoItem, autor));
                }
                else {
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

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoArquivo))){

            StringBuilder stb = new StringBuilder();
            emprestimos.forEach(emprestimo -> stb.append(emprestimo.toString() + "\n"));
            bw.write(stb.toString());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
