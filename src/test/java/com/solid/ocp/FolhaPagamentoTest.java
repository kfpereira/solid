package com.solid.ocp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FolhaPagamentoTest {

    @Test
    void shouldCalculateClt() {
        assertEquals(2000, new FolhaPagamento().calculate(new ContratoClt()), "Sal�rio Inicial");
    }

    @Test
    void shouldCalculateEstagiario() {
        assertEquals(1200, new FolhaPagamento().calculate(new Estagio()), "Bolsa Aux�lio");
    }

    @Test
    void shouldReturnZero() {
        assertEquals(0, new FolhaPagamento().calculate(null), "Nada");
    }

}
