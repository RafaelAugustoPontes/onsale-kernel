package com.example.onsalekernel.application.domain.validation;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ValidationResult {

    private String id;
    private boolean sucess;
    private String description;

    public static ValidationResult getSucessResult() {
        return ValidationResult.builder().sucess(true).id("0").description("Operaçâo executada com sucesso").build();
    }

    public static ValidationResult getErrorResult(final String id, final String description) {
        return ValidationResult.builder().sucess(false).id(id).description(description).build();
    }

}
