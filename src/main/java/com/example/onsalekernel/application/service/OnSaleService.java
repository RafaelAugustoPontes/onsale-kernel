package com.example.onsalekernel.application.service;


import com.example.onsalekernel.application.domain.Promotion;
import com.example.onsalekernel.application.domain.validation.ValidationMessage;
import com.example.onsalekernel.application.domain.validation.ValidationSpec;
import com.example.onsalekernel.application.ports.DatabasePort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OnSaleService implements OnSaleServiceSpec {

    private final DatabasePort databasePort;
    private final ValidationSpec validation;

    @Autowired
    public OnSaleService(final DatabasePort databasePort, final ValidationSpec validation) {
        this.databasePort = databasePort;
        this.validation = validation;
    }

    @Override
    public OnsaleResponse<Promotion> insert(final Promotion promotion) {
        log.info("Request recieved " + promotion);
        log.info("Starting validations engine");
        final var validationResult = validation.run(new ValidationMessage(promotion));
        log.info("Validation result " + validationResult.isSucess());

        if (!validationResult.isSucess()) {
            log.info("Erro de validação");
            return OnsaleResponse.<Promotion>builder()
                    .validationError(true)
                    .build();
        }

        try {
            Promotion savedPromotion = databasePort.insert(promotion);
            log.info("Gravação efetuada com sucesso");
            return OnsaleResponse.<Promotion>builder()
                    .sucess(true)
                    .object(savedPromotion)
                    .build();
        } catch (Exception e) {
            log.info("Erro ao gravar a promoção");
            e.printStackTrace();
            return OnsaleResponse.<Promotion>builder()
                    .internalError(true)
                    .build();
        }
    }

}
