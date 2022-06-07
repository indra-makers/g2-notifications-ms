package com.co.indra.coinmarketcap.notifications.services;

import com.co.indra.coinmarketcap.notifications.model.entities.Notification;
import com.co.indra.coinmarketcap.notifications.repositories.NotificationsRepository;
import com.co.indra.coinmarketcap.notifications.sendgrid.service.SendGridService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.IOException;
import java.util.List;

@Service
public class NotificationService {
    @Autowired
    private NotificationsRepository notificationsRepository;
    @Autowired
    private SendGridService sendGridService;

    public void registerNotification(Notification notification) throws IOException {
        sendGridService.sendMail(notification.getSubject(), notification.getMessage(), notification.getMailUser());
        notificationsRepository.sendNotification(notification);
    }

    public List<Notification> getNotification(String mailuser) {
        return notificationsRepository.logNotificationsByEmail(mailuser);
    }

}
