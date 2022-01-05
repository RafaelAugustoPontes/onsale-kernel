package com.example.onsalekernel.adapters.inbound.consumers;

import br.com.example.consumer.ConsumerFunction;
import br.com.example.consumer.CustomKafkaConsumer;
import com.example.onsalekernel.adapters.configuration.Config;
import com.example.onsalekernel.application.domain.Promotion;
import com.example.onsalekernel.application.service.OnSaleServiceSpec;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumer implements MessageBrokerConsumer {

    private Config config;
    private OnSaleServiceSpec service;

    @Autowired
    public KafkaConsumer(final Config config, OnSaleServiceSpec service) {
        this.config = config;
        this.service = service;
    }

    @Override
    public void consume() {
        ConsumerFunction<Promotion> consumerFunction = this::parse;
        CustomKafkaConsumer<Promotion> consumer = new CustomKafkaConsumer<>(consumerFunction, Promotion.class, config);
        consumer.run();
        log.info("Kafka consumer started");
    }

    private void parse(ConsumerRecord<String, Promotion> record) {
        log.info("Message recieved");
        log.info("------------------------------------------");
        log.info("Key: " + record.key());
        log.info("Value: " + record.value());
        log.info("Partition: " + record.partition());
        log.info("Offset: " + record.offset());
        final var promotion = record.value();
        //TODO tradamento erro
        service.insert(promotion);
    }

}
