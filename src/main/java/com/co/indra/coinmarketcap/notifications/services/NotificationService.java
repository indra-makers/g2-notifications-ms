package com.co.indra.coinmarketcap.notifications.services;

import com.co.indra.coinmarketcap.notifications.SendgridAPI.ApiService.SendgridService;
import com.co.indra.coinmarketcap.notifications.TwilioAPI.ApiService.TwilioService;
import com.co.indra.coinmarketcap.notifications.config.ErrorCodes;
import com.co.indra.coinmarketcap.notifications.exceptions.BusinessException;
import com.co.indra.coinmarketcap.notifications.exceptions.CustomExceptionHandler;
import com.co.indra.coinmarketcap.notifications.exceptions.NotFoundException;
import com.co.indra.coinmarketcap.notifications.model.entities.Notification;
import com.co.indra.coinmarketcap.notifications.model.entities.Users;
import com.co.indra.coinmarketcap.notifications.repositories.NotificationsRepository;
import com.co.indra.coinmarketcap.notifications.repositories.UsersRepository;
import com.twilio.exception.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.EnumMap;
import java.util.List;

@Service
public class NotificationService {
    @Autowired
    private NotificationsRepository notificationsRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private TwilioService twilioService;

    @Autowired
    private SendgridService sendgridService;

    public void registerNotification(Notification notification) {
        List<Users> destination = usersRepository.listUserById(notification.getUserId());

        if(destination.size()==0){
            throw new NotFoundException(ErrorCodes.DESTINATION_USER_DOESNTEXISTS.getMessage());
        }

        if( !(notification.getTypeOf().equals("SMS") || notification.getTypeOf().equals("MAIL")) ){
            throw new BusinessException(ErrorCodes.TYPEOF_NOTIFICATION_NOTVALID);
        }

        if( (notification.getTypeOf().equals("MAIL")) && (notification.getSubject().isEmpty() || notification.getSubject().equals("N/A"))){
            throw new BusinessException(ErrorCodes.SUBJECT_INVALID_SETTING);
        }

        if( (notification.getTypeOf().equals("SMS")) ){
            notification.setSubject("N/A");
        }

        if(notification.getMessage().isEmpty()){
            throw new BusinessException(ErrorCodes.MESSAGE_CONTENT_INVALID);
        }

        if( (notification.getTypeOf().equals("SMS")) && (notification.getMessage().length()>160)){
            throw new BusinessException(ErrorCodes.MESSAGE_CONTENT_SMS_OVERLOAD);
        }

        if( notification.getTypeOf().equals("SMS") ){
            try {
                notificationsRepository.sendNotification(notification);
                twilioService.twilioService(destination.get(0).getPhoneNumber(),notification.getMessage());
            } catch (ApiException ae) {
                throw new BusinessException(ErrorCodes.PERFORMSEND_SMS_SERVER_NOTAVAILABLE);
            }
        }

        if( (notification.getTypeOf().equals("MAIL")) ){
            try {
                sendgridService.sendMail(notification.getSubject(),notification.getMessage(),destination.get(0).getMailUser());
            }catch(IOException e){
                throw new BusinessException(ErrorCodes.PERFORMSEND_MAIL_SERVER_NOTAVAILABLE);
            }
        }
    }

    public List<Notification> getNotificationByUser(String userId) {

        List<Users> destination = usersRepository.listUserById(userId);
        if(destination.size()!=0){
            return notificationsRepository.getNotificationsByUserId(userId);
        }else{
            throw new BusinessException(ErrorCodes.DESTINATION_USER_DOESNTEXISTS.getMessage());
        }
    }

    public List<Notification> getAllNotifications(){
        return notificationsRepository.getAllNotifications();
    }

}
