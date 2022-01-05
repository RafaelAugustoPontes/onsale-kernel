package com.example.onsalekernel.adapters.outbound.database;

import com.example.onsalekernel.application.domain.Promotion;
import com.example.onsalekernel.application.ports.DatabasePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostgresDatabase implements DatabasePort {

    private PromotionRepository repository;

    @Autowired
    public PostgresDatabase(PromotionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Promotion insert(Promotion promotion) {
        PromotionModel model = PromotionModel.builder()
                .description(promotion.getDescription())
                .url(promotion.getUrl())
                .price(promotion.getPrice())
                .build();
        repository.save(model);
        promotion.setId(model.getId());
        return promotion;
    }

}
