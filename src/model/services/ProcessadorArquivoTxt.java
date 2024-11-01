package model.services;

import model.entities.*;
import model.entities.enums.TipoItem;
import model.entities.enums.TipoUsuario;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProcessadorArquivoTxt implements ProcessadorArquivo {

    @Override
    public List<ItemBiblioteca> carregarItens(File caminhoArquivo) {
        List<ItemBiblioteca> itens = new ArrayList<>();

        try (Scanner sc = new Scanner(new BufferedReader(new FileReader(caminhoArquivo)))) {

            while (sc.hasNextLine()) {
                String[] coluna = sc.nextLine().split(",");

                Integer id = Integer.parseInt(coluna[0]);
                String titulo = coluna[1];
                Integer numeroDePaginas = Integer.parseInt(coluna[2]);
                Boolean disponivel = Boolean.valueOf(coluna[3]);
                TipoItem tipoItem = TipoItem.valueOf(coluna[4]);

                if (coluna[4].equals(TipoItem.LIVRO.name())) {
                    String autor = coluna[5];
                    itens.add(new Livro(id, titulo, numeroDePaginas, disponivel, tipoItem, autor));
                } else {
                    String edicao = coluna[5];
                    itens.add(new Revista(id, titulo, numeroDePaginas, disponivel, tipoItem, edicao));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return itens;
    }

    @Override
    public List<Emprestimo> carregarEmprestimos(File caminhoArquivo, GestorEmprestimo gestorEmprestimo) {

        List<Emprestimo> emprestimos = new ArrayList<>();

        try (Scanner sc = new Scanner(new BufferedReader(new FileReader(caminhoArquivo)))) {

            while (sc.hasNextLine()) {
                String[] coluna = sc.nextLine().split(",");

                Integer id = Integer.parseInt(coluna[0]);
                Usuario usuario = new Usuario(coluna[1], TipoUsuario.valueOf(coluna[2]));
                ItemBiblioteca itemBiblioteca = (ItemBiblioteca) gestorEmprestimo.getInventario().getItens().get(Integer.valueOf(coluna[3]));
                LocalDate dataEmprestimo = LocalDate.parse(coluna[4]);
                LocalDate dataDevolucao = LocalDate.parse(coluna[5]);

                emprestimos.add(new Emprestimo(id, usuario, itemBiblioteca, dataEmprestimo, dataDevolucao));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return emprestimos;
    }

    @Override
    public void salvarItens(List<ItemBiblioteca> itens, File caminhoArquivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoArquivo))) {

            StringBuilder stb = new StringBuilder();
            itens.forEach(itemBiblioteca -> stb.append(itemBiblioteca.toString() + "\n"));
            bw.write(stb.toString());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void salvarEmprestimos(List<Emprestimo> emprestimos, File caminhoArquivo) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoArquivo))) {

            StringBuilder stb = new StringBuilder();
            emprestimos.forEach(emprestimo -> stb.append(emprestimo.toString() + "\n"));
            bw.write(stb.toString());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
