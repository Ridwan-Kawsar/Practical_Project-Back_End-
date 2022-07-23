package com.qa.entity;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class PokemonIntegrationTest {
	@Test
    public void testEquals() {
        EqualsVerifier.simple().forClass(Pokemon.class).verify();
    }
}