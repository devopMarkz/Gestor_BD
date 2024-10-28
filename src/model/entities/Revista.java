package model.entities;

import model.entities.enums.TipoItem;

public class Revista extends ItemBiblioteca{

    private String edicao;

    public Revista(Integer id, String titulo, Integer numeroDePaginas, Boolean disponivel, TipoItem tipoItem, String edicao){
        super(id, titulo, numeroDePaginas, disponivel, tipoItem);
        this.edicao = edicao;
    }

    public String getEdicao() {
        return edicao;
    }

    @Override
    public String toString(){
        return super.toString() + "," + edicao;
    }
}
