package com.co.indra.coinmarketcap.notifications.model.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Notification implements Serializable {
    private String id_notification ;
    private String typeof ;
    private String message ;
    private Timestamp sent_at ;
    private String mailUser ;
    private String subject ;
    private String phonenumber;

    public Notification(){}

    public Notification(String id_notification, String typeof, String message, Timestamp sent_at, String mailUser, String subject, String phonenumber){
        this.id_notification = id_notification;
        this.typeof = typeof;
        this.message = message;
        this.sent_at = sent_at;
        this.mailUser = mailUser;
        this.subject = subject;
        this.phonenumber = phonenumber;
    }

    public String get_id_notification() {
        return id_notification;
    }

    public void set_id_notification(String id_notification) {
        this.id_notification = id_notification;
    }

    public String getTypeof() {
        return typeof;
    }

    public void setTypeof(String typeof) {
        this.typeof = typeof;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getSent_at() {
        return sent_at;
    }

    public void setSent_at(Timestamp sent_at) {
        this.sent_at = sent_at;
    }

    public String getMailUser() {
        return mailUser;
    }

    public void setMailUser(String mailUser) {
        this.mailUser = mailUser;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}
