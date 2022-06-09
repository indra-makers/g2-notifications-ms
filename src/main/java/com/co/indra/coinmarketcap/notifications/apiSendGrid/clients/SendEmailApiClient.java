package com.co.indra.coinmarketcap.notifications.apiSendGrid.clients;


import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.sendgrid.helpers.mail.objects.Email;

import java.io.IOException;

@Component
public class SendEmailApiClient {

    @Value("${api.sendgrid.apikey}")
    private String sendGridApiKey;

    @Value("${api.sendgrid.from}")
    private String sendGridFrom;

    public void sendEmail(String subject, String body, String to){
        Email from = new Email(sendGridFrom);
        Email para = new Email(to);
        Content content = new Content("text/plain",body);
        Mail mail = new Mail(from, subject, para, content);

        SendGrid sg = new SendGrid(sendGridApiKey);
        Request request = new Request();
        try{
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
