package com.co.indra.coinmarketcap.notifications.model.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

public class Notification implements Serializable {
    private String idNotification ;
    private String typeOf ;
    private String message ;
    private Date sentAt ;
    private String mailUser ;
    private String subject ;
    private String phoneNumber;

    public Notification(){}

    public Notification(String idNotification, String typeOf, String message, Timestamp sentAt, String mailUser, String subject, String phoneNumber){
        this.idNotification = idNotification;
        this.typeOf = typeOf;
        this.message = message;
        this.sentAt = sentAt;
        this.mailUser = mailUser;
        this.subject = subject;
        this.phoneNumber = phoneNumber;
    }

    public String get_idNotification() {
        return idNotification;
    }

    public void set_idNotification(String idNotification) {
        this.idNotification = idNotification;
    }

    public String gettypeOf() {
        return typeOf;
    }

    public void settypeOf(String typeOf) {
        this.typeOf = typeOf;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getSent_at() {
        return sentAt;
    }

    public void setSent_at(Timestamp sent_at) {
        this.sentAt = sent_at;
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

    public String getphoneNumber() {
        return phoneNumber;
    }

    public void setphoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
