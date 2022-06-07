package com.co.indra.coinmarketcap.notifications.controllers;

import com.co.indra.coinmarketcap.notifications.config.Routes;
import com.co.indra.coinmarketcap.notifications.model.entities.Notification;
import com.co.indra.coinmarketcap.notifications.model.entities.UserNotificationsData;
import com.co.indra.coinmarketcap.notifications.services.NotificationService;
import com.co.indra.coinmarketcap.notifications.servicesExternal.models.SmsSender;
import com.co.indra.coinmarketcap.notifications.servicesExternal.services.SmsSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Routes.NOTIFICATION_SEND_PATH)
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private SmsSenderService smsSenderService;

    @PostMapping
    public void registerNotification(@RequestBody Notification notification) {
        notificationService.registerNotification(notification);
    }

    @GetMapping(Routes.NOTIFICATION_VIEWLOG_BY_EMAIL)
    public List<Notification> getPortafoliosUserName(
            @PathVariable("mailuser") String mailuser) {
        return notificationService.getNotification(mailuser);
    }

    @PostMapping(Routes.SMS_SEND_PATH)
    public void sendSMS(@RequestBody SmsSender smsSender){
        smsSenderService.sendSMS(smsSender.getUser_id(), smsSender.getMessage());
    }
}
