package br.com.wpb.tdd.service;

import br.com.wpb.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void bonusDeveSerZeroParaFuncionarioComSalarioAlto() {
        var service = new BonusService();

        assertThrows(IllegalArgumentException.class, () -> service.calcularBonus(
                new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000"))));

        try {
            service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000")));
        } catch (IllegalArgumentException e) {
            assertEquals("Funcionário com salário maior que R$ 10000.00 não recebe bonus", e.getMessage());
        }
    }

    @Test
    void bonusDeveSer10PorcentoDoSalario() {
        var service = new BonusService();
        BigDecimal bonus = service.calcularBonus(
                new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("2500")));

        assertEquals(new BigDecimal("250.00"), bonus);
    }
}