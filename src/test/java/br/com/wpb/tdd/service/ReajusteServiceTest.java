package br.com.wpb.tdd.service;

import br.com.wpb.tdd.modelo.Desempenho;
import br.com.wpb.tdd.modelo.Funcionario;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {

    private ReajusteService service;

    private Funcionario funcionario;

    @BeforeEach
    public void init() {
        System.out.println("Testando...");
        this.service = new ReajusteService();
        this.funcionario = new Funcionario("José", LocalDate.now(), new BigDecimal("1000"));
    }

    @BeforeAll
    public static void iniciado() {
        System.out.println("Iniciado testes");
    }

    @AfterAll
    public static void finalizado() {
        System.out.println("Finalizado testes");
    }

    @Test
    public void deveReajustarTresPorcentoDoSalarioSeDesempenhoForADesejar() {
        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    public void deveReajustarQuinzePorcentoDoSalarioSeDesempenhoForBom() {
        service.concederReajuste(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    public void deveReajustarVintePorcentoDoSalarioSeDesempenhoForBom() {
        service.concederReajuste(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
}
