package br.com.wpb.tdd.service;

import br.com.wpb.tdd.modelo.Desempenho;
import br.com.wpb.tdd.modelo.Funcionario;

import java.math.BigDecimal;

public class ReajusteService {

    public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {
        BigDecimal percentual = desempenho.percentualReajuste();
        funcionario.reajustarSalario(funcionario.getSalario().multiply(percentual));
    }
}
