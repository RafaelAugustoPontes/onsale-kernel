package com.example.onsalekernel.application.domain.validation;

import java.net.MalformedURLException;
import java.net.URL;

public class URLValidation extends BaseHandler {

    @Override
    protected ValidationResult validate(ValidationMessage message) {
        final var promotion = message.getPromotion();
        try {
            new URL(promotion.getUrl());
            return null;
        } catch (MalformedURLException e) {
            return ValidationResult.getErrorResult("MSG_KERNEL_03", "URL inválida");
        }
    }
}
