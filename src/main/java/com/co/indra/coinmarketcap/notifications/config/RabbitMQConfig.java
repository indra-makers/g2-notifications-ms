package com.co.indra.coinmarketcap.notifications.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    @Bean
    public Queue testQueue() {
        return new Queue("users");
    }
}
