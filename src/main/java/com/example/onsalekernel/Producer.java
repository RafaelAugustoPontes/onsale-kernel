package com.example.onsalekernel;

import br.com.example.producer.CustomKafkaProducer;
import com.example.onsalekernel.adapters.configuration.Config;
import com.example.onsalekernel.application.domain.Promotion;

import java.math.BigDecimal;
import java.util.UUID;

public class Producer {

    public static void main(String[] args) {
        Config configs = new Config("127.0.0.1:29092", "", "ONSALE_NEW_PROMOTION");
        try (var producer = new CustomKafkaProducer<Promotion>(configs)) {
            var prom = new Promotion(null, "PS5","http://amazon.com.br", new BigDecimal("4399.00"));
            producer.send(UUID.randomUUID().toString(), prom);
        }
    }

}
