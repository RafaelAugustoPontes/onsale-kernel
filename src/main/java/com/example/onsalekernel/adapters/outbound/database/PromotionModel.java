package com.example.onsalekernel.adapters.outbound.database;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "promotion")
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class PromotionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String description;
    private String url;
    private BigDecimal price;

}
