package br.com.wpb.tdd.service;

import br.com.wpb.tdd.modelo.Desempenho;
import br.com.wpb.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {

    @Test
    public void deveReajustarTresPorcentoDoSalarioSeDesempenhoForADesejar() {
        var service = new ReajusteService();
        var funcionario = new Funcionario("José", LocalDate.now(), new BigDecimal("1000"));

        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);

        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    public void deveReajustarQuinzePorcentoDoSalarioSeDesempenhoForBom() {
        var service = new ReajusteService();
        var funcionario = new Funcionario("Josué", LocalDate.now(), new BigDecimal("1000"));

        service.concederReajuste(funcionario, Desempenho.BOM);

        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    public void deveReajustarVintePorcentoDoSalarioSeDesempenhoForBom() {
        var service = new ReajusteService();
        var funcionario = new Funcionario("Rose", LocalDate.now(), new BigDecimal("1000"));

        service.concederReajuste(funcionario, Desempenho.OTIMO);

        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
}
