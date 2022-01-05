package com.example.onsalekernel.application.service;

import com.example.onsalekernel.application.domain.Promotion;
import com.example.onsalekernel.application.domain.validation.ValidationMessage;
import com.example.onsalekernel.application.domain.validation.ValidationResult;
import com.example.onsalekernel.application.domain.validation.ValidationSpec;
import com.example.onsalekernel.application.ports.DatabasePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


class OnSaleServiceTest {

    private final DatabasePort databasePort = Mockito.mock(DatabasePort.class);

    private final ValidationSpec validation = Mockito.mock(ValidationSpec.class);

    private OnSaleServiceSpec service;

    @BeforeEach
    void setUp() {
        this.service = new OnSaleService(databasePort, validation);
    }

    @Test
    void insert_validationSucess_databaseInsert() {
        ValidationResult validationResult = ValidationResult.getSucessResult();
        when(validation.run(any(ValidationMessage.class))).thenReturn(validationResult);
        final var promotion = Promotion.builder().description("test").build();
        service.insert(promotion);
        verify(databasePort).insert(promotion);
    }

    @Test
    void insert_validationError_notDatabaseInsert() {
        ValidationResult validationResult = ValidationResult.getErrorResult("1", "Falha de validação");
        when(validation.run(any(ValidationMessage.class))).thenReturn(validationResult);
        final var promotion = Promotion.builder().description("test").build();
        service.insert(promotion);
        verifyNoInteractions(databasePort);
    }

}