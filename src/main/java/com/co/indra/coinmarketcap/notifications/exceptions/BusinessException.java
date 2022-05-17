package com.co.indra.coinmarketcap.notifications.exceptions;

import com.co.indra.coinmarketcap.notifications.config.ErrorCodes;

public class BusinessException extends RuntimeException{
    private ErrorCodes code ;
    public BusinessException(String message){
        super(message);
    }
    public BusinessException(ErrorCodes code){
        super(code.getMessage());
        this.code = code ;
    }
    public int getCode(){
        return code.getCode();
    }
}
