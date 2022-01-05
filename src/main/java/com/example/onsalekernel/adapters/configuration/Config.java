package com.example.onsalekernel.adapters.configuration;

import br.com.example.KafkaConfigSpec;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.Map;

@Configuration
public class Config implements KafkaConfigSpec {

    private final String bootstrapServer;
    private final String groupId;
    private final String topic;

    public Config(@Value("${module.messagebroker.consumer.bootstrapServer}") final String bootstrapServer,
                  @Value("${module.messagebroker.consumer.groupID}") final String groupId,
                  @Value("${module.messagebroker.consumer.topic}") final String topic) {
        this.bootstrapServer = bootstrapServer;
        this.groupId = groupId;
        this.topic = topic;
    }

    @Override
    public String getBootstrapServers() {
        return bootstrapServer;
    }

    @Override
    public String getGroupId() {
        return groupId;
    }

    @Override
    public String getTopic() {
        return topic;
    }

    @Override
    public Map<String, String> getAditionalProperties() {
        return Collections.emptyMap();
    }
}
