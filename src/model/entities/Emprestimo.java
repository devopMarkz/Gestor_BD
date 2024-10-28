package model.entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;

public class Emprestimo {

    private Integer id;
    private Usuario usuario;
    private ItemBiblioteca itemBiblioteca;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    // CONSTRUTORES DA CLASSE

    public Emprestimo(){
    }

    public Emprestimo(Integer id, Usuario usuario, ItemBiblioteca itemBiblioteca, LocalDate dataEmprestimo) {
        this.id = id;
        this.usuario = usuario;
        this.itemBiblioteca = itemBiblioteca;
        this.dataEmprestimo = dataEmprestimo;
    }

    public Emprestimo(Usuario usuario, ItemBiblioteca itemBiblioteca, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
        this.usuario = usuario;
        this.itemBiblioteca = itemBiblioteca;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    // GETTERS E SETTERS


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ItemBiblioteca getItemBiblioteca() {
        return itemBiblioteca;
    }

    public void setItemBiblioteca(ItemBiblioteca itemBiblioteca) {
        this.itemBiblioteca = itemBiblioteca;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    // MÉTODOS DA CLASSE

    public Long diasDeEmprestimo(){
        return Duration.between(dataEmprestimo.atStartOfDay(), dataDevolucao.atStartOfDay())
                .toDays();
    }

}
