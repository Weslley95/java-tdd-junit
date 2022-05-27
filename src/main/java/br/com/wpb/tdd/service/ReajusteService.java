package br.com.wpb.tdd.service;

import br.com.wpb.tdd.modelo.Desempenho;
import br.com.wpb.tdd.modelo.Funcionario;

import java.math.BigDecimal;

public class ReajusteService {

    public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {
        BigDecimal reajuste = funcionario.getSalario().multiply(porcentagemReajuste(desempenho));
        funcionario.reajustarSalario(reajuste);
    }

    public BigDecimal porcentagemReajuste(Desempenho desempenho) {
        BigDecimal porcentagem = new BigDecimal("0.00");
        switch (desempenho) {
            case A_DESEJAR:
                porcentagem = new BigDecimal("0.03");
                break;

            case BOM:
                porcentagem = new BigDecimal("0.15");
                break;

            case OTIMO:
                porcentagem = new BigDecimal("0.20");
                break;
        }
        return porcentagem;
    }
}
