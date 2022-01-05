package com.example.onsalekernel.application.domain.validation;

import org.apache.commons.lang3.StringUtils;

public class DescriptionValidation extends BaseHandler {

    public static final int MAX_SIZE = 100;

    @Override
    protected ValidationResult validate(ValidationMessage message) {
        final var promotion = message.getPromotion();
        if (promotion == null || StringUtils.isBlank(promotion.getDescription()) || promotion.getDescription().length() > MAX_SIZE)
            return ValidationResult.getErrorResult("MSG_KERNEL_01", "Descrição inválida");
        return null;
    }
}
