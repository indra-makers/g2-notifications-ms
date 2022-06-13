package com.co.indra.coinmarketcap.notifications.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue Queue(){
        return new Queue("user_notifications");
    }

}
