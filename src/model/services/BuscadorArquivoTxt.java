package model.services;

import java.io.File;

public class BuscadorArquivoTxt implements BuscadorArquivo{
    @Override
    public File getFilesInventario(String caminhoArquivoInventario) {
        return new File(caminhoArquivoInventario);
    }

    @Override
    public File getFilesEmprestimos(String caminhoArquivoEmprestimos) {
        return new File(caminhoArquivoEmprestimos);
    }
}
