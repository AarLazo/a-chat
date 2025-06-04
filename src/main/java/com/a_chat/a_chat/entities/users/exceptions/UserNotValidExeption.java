package com.a_chat.a_chat.entities.users.exceptions;

public class UserNotValidExeption extends RuntimeException{
    public UserNotValidExeption(String message){
        super(message);
    }
}
