package com.co.indra.coinmarketcap.notifications.servicesExternal.services;
import com.co.indra.coinmarketcap.notifications.repositories.UserNotificationDataRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SmsSenderService {
    @Value("${sms.acc.sid}")
    private String ACCOUNT_SID;
    @Value("${sms.auth.token}")
    private String AUTH_TOKEN;

    @Autowired
    private UserNotificationDataRepository userNotificationDataRepository;

    public void sendSMS(String username, String messageBody) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber(userNotificationDataRepository.getPhoneNumberByUsername(username).get(0).getPhoneNumber()),
                        new com.twilio.type.PhoneNumber("+16066032607"),
                        messageBody)
                .create();
    }
}
