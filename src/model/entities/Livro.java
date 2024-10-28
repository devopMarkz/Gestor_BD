package model.entities;

import model.entities.enums.TipoItem;

public class Livro extends ItemBiblioteca{

    private String autor;

    public Livro(String titulo, Integer numeroDePaginas, Boolean disponivel, TipoItem tipoItem, String autor){
        super(titulo, numeroDePaginas, disponivel, tipoItem);
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }
}
