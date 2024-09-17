package com.example.shopping_cart_rest_api_jpa.services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shopping_cart_rest_api_jpa.config.RabbitMQConfig;

@Service
public class CartNotificationService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendCartNotification(String message) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.CART_NOTIFICATION_QUEUE, message);
        System.out.println("Sent notification to RabbitMQ: " + message);
    }
}