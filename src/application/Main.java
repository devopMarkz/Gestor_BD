package application;

import model.entities.Emprestimo;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Emprestimo emp = new Emprestimo();

        emp.setDataEmprestimo(LocalDate.now());
        emp.setDataDevolucao(LocalDate.parse("2025-01-07"));

        System.out.print(emp.diasDeEmprestimo());
    }
}