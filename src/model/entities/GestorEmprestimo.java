package model.entities;

import model.services.BuscadorArquivo;
import model.services.ProcessadorArquivo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GestorEmprestimo {

    private List<Emprestimo> emprestimos = new ArrayList<>();
    private Inventario<ItemBiblioteca> inventario;
    private ProcessadorArquivo processadorArquivo;
    private BuscadorArquivo buscadorArquivo;

    public GestorEmprestimo(Inventario<ItemBiblioteca> inventario, ProcessadorArquivo processadorArquivo, BuscadorArquivo buscadorArquivo) {
        if(inventario == null || processadorArquivo == null || buscadorArquivo == null){
            throw new IllegalArgumentException("Inventário, processadorArquivo e buscadorArquivo não podem ser nulos.");
        }

        this.inventario = inventario;
        this.processadorArquivo = processadorArquivo;
        this.buscadorArquivo = buscadorArquivo;

        inventario.getItens().addAll(processadorArquivo.carregarItens(buscadorArquivo.getFilesInventario()));
        emprestimos.addAll(processadorArquivo.carregarEmprestimos(buscadorArquivo.getFilesEmprestimos(), this));
    }

    public List<Emprestimo> getEmprestimos() {
        return Collections.unmodifiableList(emprestimos);
    }

    public Inventario<ItemBiblioteca> getInventario() {
        return inventario;
    }

    public void setInventario(Inventario<ItemBiblioteca> inventario) {
        this.inventario = inventario;
    }

    public ProcessadorArquivo getProcessadorArquivo() {
        return processadorArquivo;
    }

    public void setProcessadorArquivo(ProcessadorArquivo processadorArquivo) {
        this.processadorArquivo = processadorArquivo;
    }

    public BuscadorArquivo getBuscadorArquivo() {
        return buscadorArquivo;
    }

    public void setBuscadorArquivo(BuscadorArquivo buscadorArquivo) {
        this.buscadorArquivo = buscadorArquivo;
    }
}
