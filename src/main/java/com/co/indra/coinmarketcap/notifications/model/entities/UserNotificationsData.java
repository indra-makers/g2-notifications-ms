package com.co.indra.coinmarketcap.notifications.model.entities;

import java.io.Serializable;

public class UserNotificationsData implements Serializable {

    private String username;

    private String mailUser;

    private String phoneNumber;

    public UserNotificationsData() {
    }

    public UserNotificationsData(String username, String mailUser, String phoneNumber) {
        this.username = username;
        this.mailUser = mailUser;
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMailUser() {
        return mailUser;
    }

    public void setMailUser(String mailUser) {
        this.mailUser = mailUser;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
