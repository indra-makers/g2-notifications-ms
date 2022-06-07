package com.co.indra.coinmarketcap.notifications.ApiTwillio.ApiClient;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SmsSender {

        @Value("${api.account}")
        public String ACCOUNT_SID;

        @Value("${api.auth}")
        public  String AUTH_TOKEN;

        public void sendSMS(String to, String message) {
            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
            Message messages = Message.creator(new PhoneNumber(to),new PhoneNumber("+16075249746"),message).create();

            System.out.println(messages.getSid());
        }



}
