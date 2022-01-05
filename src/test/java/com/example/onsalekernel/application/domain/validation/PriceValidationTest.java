package com.example.onsalekernel.application.domain.validation;

import com.example.onsalekernel.application.domain.Promotion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class PriceValidationTest {

    private PriceValidation validation;

    @BeforeEach
    void setUp() {
        validation = new PriceValidation();
    }

    @Test
    void validate_nullPrice() {
        var promotion = Promotion.builder().price(null).build();
        var message = new ValidationMessage(promotion);
        final var result = validation.validate(message);
        Assertions.assertFalse(result.isSucess());
        Assertions.assertEquals("MSG_KERNEL_02", result.getId());
        Assertions.assertEquals("Preço inválido", result.getDescription());
        Assertions.assertFalse(result.isSucess());
    }

    @Test
    void validate_zeroPrice() {
        var promotion = Promotion.builder().price(null).build();
        var message = new ValidationMessage(promotion);
        final var result = validation.validate(message);
        Assertions.assertFalse(result.isSucess());
        Assertions.assertEquals("MSG_KERNEL_02", result.getId());
        Assertions.assertEquals("Preço inválido", result.getDescription());
        Assertions.assertFalse(result.isSucess());
    }

    @Test
    void validate_negativePrice() {
        var promotion = Promotion.builder().price(new BigDecimal("-1")).build();
        var message = new ValidationMessage(promotion);
        final var result = validation.validate(message);
        Assertions.assertFalse(result.isSucess());
        Assertions.assertEquals("MSG_KERNEL_02", result.getId());
        Assertions.assertEquals("Preço inválido", result.getDescription());
        Assertions.assertFalse(result.isSucess());
    }

    @Test
    void validate_validPrice() {
        var promotion = Promotion.builder().price(new BigDecimal("99.90")).build();
        var message = new ValidationMessage(promotion);
        final var result = validation.validate(message);
        Assertions.assertNull(result);
    }


}