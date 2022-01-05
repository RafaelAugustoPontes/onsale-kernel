package com.example.onsalekernel.application.domain.validation;

public interface ValidationHandler {

    ValidationHandler withNext(ValidationHandler validation);
    ValidationResult handle(ValidationMessage message);

}
