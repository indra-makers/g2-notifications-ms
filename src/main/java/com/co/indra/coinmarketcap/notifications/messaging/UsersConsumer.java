package com.co.indra.coinmarketcap.notifications.messaging;

import com.co.indra.coinmarketcap.notifications.model.entities.Users;
import com.co.indra.coinmarketcap.notifications.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsersConsumer {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserService userService;

    @RabbitListener(queues = "test_users")

    public void listenerTestQueue(String massage) {
        System.out.println(massage);
        try {
            Users user = objectMapper.readValue(massage, Users.class);
            userService.saveUser(user.getUserId(), user.getMailUser(), user.getPhoneNumber());
            System.out.println(user.getMailUser());
        } catch (JsonProcessingException exc) {
            exc.printStackTrace();
        }

    }
}
