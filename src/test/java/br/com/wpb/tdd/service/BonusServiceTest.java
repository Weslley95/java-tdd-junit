package br.com.wpb.tdd.service;

import br.com.wpb.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void bonusDeveSerZeroParaFuncionarioComSalarioAlto() {
        var service = new BonusService();
        BigDecimal bonus = service.calcularBonus(
                new Funcionario(
                        "Rodrigo",
                        LocalDate.now(),
                        new BigDecimal("25000")
                )
        );

        assertEquals(new BigDecimal("0.00"), bonus);
    }

    @Test
    void bonusDeveSer10PorcentoDoSalario() {
        var service = new BonusService();
        BigDecimal bonus = service.calcularBonus(
                new Funcionario(
                        "Rodrigo",
                        LocalDate.now(),
                        new BigDecimal("2500")
                )
        );

        assertEquals(new BigDecimal("250.00"), bonus);
    }
}