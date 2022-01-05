package com.example.onsalekernel.application.domain.validation;

import java.math.BigDecimal;

public class PriceValidation extends BaseHandler {

    @Override
    public ValidationResult validate(ValidationMessage message) {
        final var promotion = message.getPromotion();

        if (promotion.getPrice() == null || promotion.getPrice().compareTo(BigDecimal.ZERO) <= 0)
            return ValidationResult.getErrorResult("MSG_KERNEL_02", "Preço inválido");

        return null;
    }
}
