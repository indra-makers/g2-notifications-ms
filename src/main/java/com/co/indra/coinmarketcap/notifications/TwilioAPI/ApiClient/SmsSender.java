package com.co.indra.coinmarketcap.notifications.TwilioAPI.ApiClient;

import com.twilio.Twilio;
import com.twilio.exception.ApiException;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SmsSender {

    @Value("${api.account}")
    private String ACCOUNT_SID;

    @Value("${api.auth}")
    private String AUTH_TOKEN;

    public void sendSMS(String to, String message){
        Twilio.init(ACCOUNT_SID,AUTH_TOKEN);
        Message mssg = Message.creator(new PhoneNumber(to), new PhoneNumber("+19895677952"), message).create();
        System.out.println(mssg.getSid());

    }
}
