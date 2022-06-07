package com.co.indra.coinmarketcap.notifications.sendgrid.service;

import com.co.indra.coinmarketcap.notifications.sendgrid.client.SendGridClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SendGridService {

    @Autowired
    SendGridClient sendGridClient;

    public void sendMail(String subject, String body, String to) throws IOException{
        sendGridClient.sendMail(subject, body, to);
    }

}
