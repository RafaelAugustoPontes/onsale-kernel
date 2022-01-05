package com.example.onsalekernel.application.service;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class OnsaleResponse <T>{
    private boolean validationError;
    private boolean internalError;
    private boolean sucess;
    private T object;
}
