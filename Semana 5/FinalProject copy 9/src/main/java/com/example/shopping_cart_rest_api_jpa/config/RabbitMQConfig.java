package com.example.shopping_cart_rest_api_jpa.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitMQConfig {

    public static final String CART_NOTIFICATION_QUEUE = "cartNotificationQueue";

    @Bean
    public Queue cartNotificationQueue() {
        return new Queue(CART_NOTIFICATION_QUEUE, false);
    }
}