package com.example.onsalekernel.application.domain.validation;

import com.example.onsalekernel.application.domain.Promotion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DescriptionValidationTest {

    private DescriptionValidation validation;

    @BeforeEach
    void setUp() {
        validation = new DescriptionValidation();
    }

    @Test
    void validate_description_null() {
        var promotion = Promotion.builder().description(null).build();
        var message = new ValidationMessage(promotion);
        final var result = validation.validate(message);
        Assertions.assertFalse(result.isSucess());
    }

    @Test
    void validate_description_empty() {
        var promotion = Promotion.builder().description("").build();
        var message = new ValidationMessage(promotion);
        final var result = validation.validate(message);
        Assertions.assertFalse(result.isSucess());
    }

    @Test
    void validate_description_bigger_than_allowed() {
        var promotion = Promotion.builder()
                .description("kjsndkasndkjasndoasdjasodjasiodjaiosdjaskomasocmaopsdmoaspkdpaosdkasopdkasopckapcmaopsdmpaosdkpasodkasopdkasopdkasopdkoasdopkas")
                .build();
        var message = new ValidationMessage(promotion);
        final var result = validation.validate(message);
        Assertions.assertFalse(result.isSucess());
    }

    @Test
    void validate_description_valid() {
        var promotion = Promotion.builder().description("PS5 versão com leitor de discos").build();
        var message = new ValidationMessage(promotion);
        final var result = validation.validate(message);
        Assertions.assertNull(result);
    }

}