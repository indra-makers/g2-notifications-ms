package com.co.indra.coinmarketcap.notifications.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbiConfig {
    @Bean
    public Queue testQueue() {
        return new Queue("users");
    }
}
