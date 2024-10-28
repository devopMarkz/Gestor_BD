package model.entities;

import model.entities.enums.TipoUsuario;

public class Usuario {

    private String nome;
    private TipoUsuario tipoUsuario;

    public Usuario(String nome, TipoUsuario tipoUsuario) {;
        this.nome = nome;
        this.tipoUsuario = tipoUsuario;
    }

    public String getNome() {
        return nome;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", tipoUsuario=" + tipoUsuario +
                '}';
    }
}
