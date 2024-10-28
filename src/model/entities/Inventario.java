package model.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Inventario <T extends ItemBiblioteca>{

    private List<T> itens = new ArrayList<>();

    public Inventario(){
    }

    public List<T> getItens(){
        return itens;
    }

    public void adicionarItem(T item){
        itens.add(item);
    }

    public void removerItem(T item){
        itens.remove(item);
    }

    public T buscarItem(Predicate<T> criterio){
        return itens.stream()
                .filter(criterio)
                .findFirst()
                .orElseThrow();
    }

    public Integer calcularTotalPaginas(){
        return itens.stream()
                .map(ItemBiblioteca::getNumeroDePaginas)
                .reduce(0, Integer::sum);
    }

}
