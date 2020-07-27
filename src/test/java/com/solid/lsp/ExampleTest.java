package com.solid.lsp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExampleTest {

    @Test
    void example() {
        assertEquals("Meu nome é A", imprimeNome(new A()));
        assertEquals("My name is B", imprimeNome(new B()));
    }

    private String imprimeNome(A objeto) {
        return objeto.printNome();
    }
}
