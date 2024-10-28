package model.entities;

import model.entities.enums.TipoItem;

public class Livro extends ItemBiblioteca{

    private String autor;

    public Livro(Integer id, String titulo, Integer numeroDePaginas, Boolean disponivel, TipoItem tipoItem, String autor){
        super(id, titulo, numeroDePaginas, disponivel, tipoItem);
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    @Override
    public String toString() {
        return super.toString() + "Livro{" +
                "autor='" + autor + '\'' +
                '}';
    }
}
