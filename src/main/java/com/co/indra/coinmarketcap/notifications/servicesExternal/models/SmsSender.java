package com.co.indra.coinmarketcap.notifications.servicesExternal.models;

public class SmsSender {

    private String user_id;

    private String message;

    public SmsSender() {
    }

    public SmsSender(String user_id, String message) {
        this.user_id = user_id;
        this.message = message;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
