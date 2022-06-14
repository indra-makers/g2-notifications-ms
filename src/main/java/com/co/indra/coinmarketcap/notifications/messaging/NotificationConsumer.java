package com.co.indra.coinmarketcap.notifications.messaging;

import com.co.indra.coinmarketcap.notifications.model.entities.Notification;
import com.co.indra.coinmarketcap.notifications.repositories.NotificationsRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationConsumer {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private NotificationsRepository notificationsRepository;

    @RabbitListener(queues = "alerts")
    public void listenerTestQueue(String massage) {
        System.out.println(massage);
        try {
            Notification notification = objectMapper.readValue(massage, Notification.class);
            notificationsRepository.sendNotification(notification);
        } catch (JsonProcessingException exc) {
            exc.printStackTrace();
        }
    }
}
