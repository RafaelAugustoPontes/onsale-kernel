package com.example.onsalekernel.application.domain.validation;

import com.example.onsalekernel.application.domain.Promotion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

class URLValidationTest {

    private URLValidation validation;

    @BeforeEach
    void setUp() {
        validation = new URLValidation();
    }

    @Test
    void validate_invalidURL() {
        var promotion = Promotion.builder().url("asdadasd").build();
        var message = new ValidationMessage(promotion);
        final var result = validation.validate(message);
        assertFalse(result.isSucess());
    }

    @Test
    void validate_validURL() {
        var promotion = Promotion.builder().url("http://google.com.br").build();
        var message = new ValidationMessage(promotion);
        final var result = validation.validate(message);
        assertNull(result);
    }

}