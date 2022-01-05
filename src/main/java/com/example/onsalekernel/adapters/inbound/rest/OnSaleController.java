package com.example.onsalekernel.adapters.inbound.rest;

import com.example.onsalekernel.application.domain.Promotion;
import com.example.onsalekernel.application.service.OnSaleServiceSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/promotions")
public class OnSaleController extends BaseController {

    private final OnSaleServiceSpec service;

    @Autowired
    public OnSaleController(OnSaleServiceSpec service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Promotion> save(@RequestBody Promotion promotion) {
        final var result = service.insert(promotion);
        return resolve(result);
    }

}
