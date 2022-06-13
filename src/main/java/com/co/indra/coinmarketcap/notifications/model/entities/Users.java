package com.co.indra.coinmarketcap.notifications.model.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class Users implements Serializable {

    private String userId ;
    private String mailUser ;
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
