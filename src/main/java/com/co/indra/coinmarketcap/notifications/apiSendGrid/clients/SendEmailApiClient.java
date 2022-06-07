package com.co.indra.coinmarketcap.notifications.apiSendGrid.clients;


import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import org.springframework.stereotype.Component;
import com.sendgrid.helpers.mail.objects.Email;

import java.io.IOException;

@Component
public class SendEmailApiClient {

    public void sendEmail(String subject, String body, String to){
        Email from = new Email("desarrolloenequipoeam@gmail.com");
        Email para = new Email(to.toString());
        Content content = new Content("text/plain",body);
        Mail mail = new Mail(from, subject, para, content);

        SendGrid sg = new SendGrid(System.getenv("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"));
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
