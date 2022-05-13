package com.co.indra.coinmarketcap.notifications.config;

public enum ErrorCodes {
    TYPEOF_NOTIFICATION_NOTVALID("Notification type isn't allowed",1),
    MESSAGE_CONTENT_INVALID("Notification message has invalid content or is empty",2),
    SENT_AT_INVALID_SETTINGS("Notification date log has invalid content or is empty", 3),
    DESTINATION_INVALID_SETTINGS("Notification recipient has invalid content or is empty", 4),
    SUBJECT_INVALID_SETTING("Notification subject has invalid content or is empty",5),
    DESTINATION_SOURCE_ONDB_EMPTY("Can't verify user existence in system by the provided email address",6),
    PERFORMSEND_SERVER_NOTAVAILABLE("Can't send notification due to a mail server down",7),
    PERFORMSEND_SERVER_EXECUTIONERROR("Mail server fail, the notification may or may not have been sent",8),
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
