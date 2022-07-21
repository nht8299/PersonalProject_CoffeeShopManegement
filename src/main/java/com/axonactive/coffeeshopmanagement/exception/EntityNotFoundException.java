package com.axonactive.coffeeshopmanagement.exception;

import lombok.Getter;

import javax.swing.text.html.parser.Entity;

@Getter
public class EntityNotFoundException extends Exception {

    private final String errorKey;

    public EntityNotFoundException(String errorkey){this.errorKey = errorkey;}

    public EntityNotFoundException(String message,String errorKey){
        super(message);
        this.errorKey = errorKey;
    }

    public EntityNotFoundException(String message,Throwable cause,String errorKey){
        super(message,cause);
        this.errorKey = errorKey;
    }

    public EntityNotFoundException(Throwable cause, String errorKey){
        super(cause);
        this.errorKey =errorKey;
    }
}
