package com.co.indra.coinmarketcap.notifications.config;

public enum ErrorCodes {
    DESTINATION_USER_DOESNTEXISTS("Can't proceed due to user associated by its ID does not exists",1),
    USER_ADDITION_EXISTS("Can't proceed with user addition due to that user already exists",2),
    USER_ADDITION_ID_EMPTY("Can't proceed with user addition due to empty input in user id",3),
    TYPEOF_NOTIFICATION_NOTVALID("Notification type isn't allowed",4),
    USER_ADDRESS_PHONE_INVALID_INPUT("User email address or phone number has invalid content or is empty.", 5),
    SUBJECT_INVALID_SETTING("Mail notification requires a subject and it has invalid content or is empty",6),
    MESSAGE_CONTENT_INVALID("Notification message has invalid content or is empty",7),
    MESSAGE_CONTENT_SMS_OVERLOAD("SMS Notification content exceeds the text length allowed (160 chars)",8),
    PERFORMSEND_MAIL_SERVER_NOTAVAILABLE("Notification mail server isn't giving an answer. Maybe the server is down.",9),
    PERFORMSEND_SMS_SERVER_NOTAVAILABLE("Notification SMS server isn't giving an answer. Maybe the server is down.",10),
    NOT_FOUND("RESOURCE NOT FOUND",404),
    BAD_REQUEST("BAD REQUEST",400),
    INTERNAL_SERVER_ERROR("INTERNAL SERVER ERROR",500)
    ;

    String message ;
    int code ;

    ErrorCodes(String message, int code){
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

}
