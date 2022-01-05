package com.example.onsalekernel.adapters.inbound.rest;

import com.example.onsalekernel.application.domain.Promotion;
import com.example.onsalekernel.application.service.OnsaleResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    public ResponseEntity<Promotion> resolve(OnsaleResponse<Promotion> response) {
        if (response.isInternalError())
            return ResponseEntity.internalServerError().build();
        if (response.isValidationError())
            return ResponseEntity.unprocessableEntity().build();
        if (response.isSucess())
            return ResponseEntity.ok(response.getObject());

        throw new IllegalArgumentException("Unknown response");
    }

}
