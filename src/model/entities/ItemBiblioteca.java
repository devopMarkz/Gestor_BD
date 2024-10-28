package model.entities;

import model.entities.enums.TipoItem;

public abstract class ItemBiblioteca {

    private String titulo;
    private Integer numeroDePaginas;
    private Boolean disponivel;
    private TipoItem tipoItem;

    // CONSTRUTORES DA CLASSE

    public ItemBiblioteca(){
    }

    public ItemBiblioteca(String titulo, Integer numeroDePaginas, Boolean disponivel, TipoItem tipoItem){
        this.titulo = titulo;
        this.numeroDePaginas = numeroDePaginas;
        this.tipoItem = tipoItem;
    }

    // GETTERS E SETTERS

    public String getTitulo() {
        return titulo;
    }

    public Integer getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public TipoItem getTipoItem() {
        return tipoItem;
    }



}
