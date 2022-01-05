package com.example.onsalekernel.application.domain.validation;

public interface ValidationSpec {
    ValidationResult run(ValidationMessage message);
}
