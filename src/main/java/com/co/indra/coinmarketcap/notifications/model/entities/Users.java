package com.co.indra.coinmarketcap.notifications.model.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class Users implements Serializable {
    @JsonProperty("username")
    private String userId ;
    @JsonProperty("mail")
    private String mailUser ;
    @JsonProperty("phone")
    private String phoneNumber ;

    public Users(){}

    public Users(String userid, String mailuser, String phonenumber){
        this.userId = userid;
        this.mailUser = mailuser;
        this.phoneNumber = phonenumber;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
