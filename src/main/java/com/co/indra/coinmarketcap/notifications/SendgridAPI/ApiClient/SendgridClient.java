package com.co.indra.coinmarketcap.notifications.SendgridAPI.ApiClient;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SendgridClient {

    @Value("${api.mail.key}")
    private String sendGridApiKey;
    @Value("${api.mail.source}")
    private String sendGridFrom;

    public void sendMail(String subject, String body, String to) throws IOException{
        Content content = new Content("text/plain", body);
        Mail mail = new Mail( new Email(sendGridFrom), subject, new Email(to), content);
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
        }catch(IOException e){

        }
    }

}
