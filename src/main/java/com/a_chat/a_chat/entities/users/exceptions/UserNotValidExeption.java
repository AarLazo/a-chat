package com.a_chat.a_chat.entities.users.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserNotValidExeption extends RuntimeException{
    public UserNotValidExeption(String message){
        super(message);
    }
}
