package com.example.onsalekernel;

import com.example.onsalekernel.adapters.inbound.consumers.MessageBrokerConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OnsaleKernelApplication {

    @Autowired
    private MessageBrokerConsumer consumer;

    public static void main(String[] args) {
        SpringApplication.run(OnsaleKernelApplication.class, args);
    }

    @Bean
    public void startConsumer() {
        consumer.consume();
    }

}
