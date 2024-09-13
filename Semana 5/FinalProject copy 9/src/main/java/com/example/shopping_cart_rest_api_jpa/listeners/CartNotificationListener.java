package com.example.shopping_cart_rest_api_jpa.listeners;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.shopping_cart_rest_api_jpa.config.RabbitMQConfig;

@Component
public class CartNotificationListener {

    @RabbitListener(queues = RabbitMQConfig.CART_NOTIFICATION_QUEUE)
    public void receiveMessage(String message) {
        System.out.println("Received notification: " + message);
        // Here you could add further logic, like sending an email, updating a log, etc.
    }
}
