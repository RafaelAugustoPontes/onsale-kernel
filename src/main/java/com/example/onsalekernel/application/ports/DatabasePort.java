package com.example.onsalekernel.application.ports;

import com.example.onsalekernel.application.domain.Promotion;

public interface DatabasePort {
    Promotion insert(Promotion promotion);
}
