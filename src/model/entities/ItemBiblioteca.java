package model.entities;

import model.entities.enums.TipoItem;

public abstract class ItemBiblioteca {

    private Integer id;
    private String titulo;
    private Integer numeroDePaginas;
    private Boolean disponivel;
    private TipoItem tipoItem;

    // CONSTRUTORES DA CLASSE

    public ItemBiblioteca(){
    }

    public ItemBiblioteca(Integer id, String titulo, Integer numeroDePaginas, Boolean disponivel, TipoItem tipoItem){
        this.id = id;
        this.titulo = titulo;
        this.numeroDePaginas = numeroDePaginas;
        this.disponivel = disponivel;
        this.tipoItem = tipoItem;
    }

    // GETTERS E SETTERS


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Integer getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public TipoItem getTipoItem() {
        return tipoItem;
    }

    @Override
    public String toString(){
        return id + "," + titulo + "," + numeroDePaginas + "," + disponivel + "," + tipoItem;
    }

}
