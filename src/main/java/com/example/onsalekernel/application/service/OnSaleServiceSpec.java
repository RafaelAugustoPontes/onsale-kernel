package com.example.onsalekernel.application.service;

import com.example.onsalekernel.application.domain.Promotion;

public interface OnSaleServiceSpec {
    OnsaleResponse<Promotion> insert(Promotion promotion);
}
