package com.example.onsalekernel.application.domain;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Builder
public class Promotion {

    private Integer id;
    private String description;
    private String url;
    private BigDecimal price;

}
