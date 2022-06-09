package com.co.indra.coinmarketcap.notifications.SendgridAPI.ApiService;

import com.co.indra.coinmarketcap.notifications.SendgridAPI.ApiClient.SendgridClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SendgridService {

    @Autowired
    SendgridClient sendGridClient;

    public void sendMail(String subject, String body, String to) throws IOException {
        sendGridClient.sendMail(subject, body, to);
    }
}
