package com.co.indra.coinmarketcap.notifications.controllers;

import com.co.indra.coinmarketcap.notifications.config.Routes;
import com.co.indra.coinmarketcap.notifications.model.entities.Notification;
import com.co.indra.coinmarketcap.notifications.model.entities.Users;
import com.co.indra.coinmarketcap.notifications.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Routes.NOTIFICATION_PATH)
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping
    public void registerNotification(@RequestBody Notification notification) {
        notificationService.registerNotification(notification);
    }

    @GetMapping(Routes.NOTIFICATION_VIEWLOG_BY_USERID)
    public List<Notification> getNotificationsByUserid(
            @PathVariable("userId") String userId) {
        return notificationService.getNotificationByUser(userId);
    }

    @GetMapping(Routes.NOTIFICATION_GET_ALL)
    public List<Notification> getAllNotifications(){
        return notificationService.getAllNotifications();
    }

}
