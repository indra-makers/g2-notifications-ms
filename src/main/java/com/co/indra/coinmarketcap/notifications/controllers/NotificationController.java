package com.co.indra.coinmarketcap.notifications.controllers;

import com.co.indra.coinmarketcap.notifications.config.Routes;
import com.co.indra.coinmarketcap.notifications.model.entities.Notification;
import com.co.indra.coinmarketcap.notifications.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(Routes.NOTIFICATION_SEND_PATH)
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping
    public void registerNotification(@RequestBody Notification notification) throws IOException {
        notificationService.registerNotification(notification);
    }

    @GetMapping(Routes.NOTIFICATION_VIEWLOG_BY_EMAIL)
    public List<Notification> getPortafoliosUserName(
            @PathVariable("mailuser") String mailuser) {
        return notificationService.getNotification(mailuser);
    }


}
