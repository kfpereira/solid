package com.solid.dip;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PasswordRetrieverTest {

    @Test
    void shouldBeMySql() {
        PasswordRetriever passwordRetriever = new PasswordRetriever();
        assertNotNull(passwordRetriever.getMySqlConnection());
    }

}
