package model.services;

import java.io.File;

public class BuscadorArquivoTxt implements BuscadorArquivo{
    @Override
    public File getFilesInventario() {
        return new File("C:\\Users\\Marcos Andre\\Desktop\\javaArqs\\gerencia_BD\\Inventario.txt");
    }

    @Override
    public File getFilesEmprestimos() {
        return new File("C:\\Users\\Marcos Andre\\Desktop\\javaArqs\\gerencia_BD\\Emprestimos.txt");
    }
}
