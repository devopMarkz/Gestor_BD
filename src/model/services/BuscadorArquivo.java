package model.services;

import java.io.File;

public interface BuscadorArquivo {

    File getFilesInventario(String caminhoArquivoInventario);
    File getFilesEmprestimos(String caminhoArquivoEmprestimos);

}
