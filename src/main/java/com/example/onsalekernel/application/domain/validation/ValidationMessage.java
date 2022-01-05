package com.example.onsalekernel.application.domain.validation;

import com.example.onsalekernel.application.domain.Promotion;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ValidationMessage {
    private Promotion promotion;
}
