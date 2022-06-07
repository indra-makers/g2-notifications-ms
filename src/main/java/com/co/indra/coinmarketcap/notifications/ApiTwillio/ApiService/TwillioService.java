package com.co.indra.coinmarketcap.notifications.ApiTwillio.ApiService;

import com.co.indra.coinmarketcap.notifications.ApiTwillio.ApiClient.SmsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TwillioService {

    @Autowired
    private SmsSender smsSender;

    public void twillioService(String to, String message){
        smsSender.sendSMS(to, message);
    }
}
