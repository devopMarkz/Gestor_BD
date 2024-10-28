package model.entities;

import model.services.BuscadorArquivo;
import model.services.ProcessadorArquivo;

import java.util.ArrayList;
import java.util.List;

public class GestorEmprestimo {

    private List<Emprestimo> emprestimos = new ArrayList<>();
    private Inventario inventario;
    private ProcessadorArquivo processadorArquivo;
    private BuscadorArquivo buscadorArquivo;

    public GestorEmprestimo(){
    }

    public GestorEmprestimo(Inventario inventario, ProcessadorArquivo processadorArquivo, BuscadorArquivo buscadorArquivo) {
        this.inventario = inventario;
        this.processadorArquivo = processadorArquivo;
        this.buscadorArquivo = buscadorArquivo;

        inventario.getItens().addAll(processadorArquivo.carregarItens(buscadorArquivo.getFilesInventario()));
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public ProcessadorArquivo getProcessadorArquivo() {
        return processadorArquivo;
    }

    public void setProcessadorArquivo(ProcessadorArquivo processadorArquivo) {
        this.processadorArquivo = processadorArquivo;
    }


}
