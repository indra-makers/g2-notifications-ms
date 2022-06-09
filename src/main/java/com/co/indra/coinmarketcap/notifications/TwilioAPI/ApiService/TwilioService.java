package com.co.indra.coinmarketcap.notifications.TwilioAPI.ApiService;

import com.co.indra.coinmarketcap.notifications.TwilioAPI.ApiClient.SmsSender;
import com.co.indra.coinmarketcap.notifications.config.ErrorCodes;
import com.co.indra.coinmarketcap.notifications.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TwilioService {

    @Autowired
    private SmsSender smsSender;

    public void twilioService(String to, String message){
        smsSender.sendSMS(to, message);
    }
}
