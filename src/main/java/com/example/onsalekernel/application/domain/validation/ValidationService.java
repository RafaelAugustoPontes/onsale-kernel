package com.example.onsalekernel.application.domain.validation;


import org.springframework.stereotype.Service;

@Service
public class ValidationService implements ValidationSpec {

    public ValidationResult run(ValidationMessage message) {

        var descriptionValidation = new DescriptionValidation();
        var priceValidation = new PriceValidation();

        return descriptionValidation.withNext(priceValidation).handle(message);

    }

}
