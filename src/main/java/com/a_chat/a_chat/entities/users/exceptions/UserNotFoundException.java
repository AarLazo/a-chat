package com.a_chat.a_chat.entities.users.exceptions;

import com.a_chat.a_chat.entities.users.model.enums.UserErrorMessages;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException() {
        super(UserErrorMessages.USER_NOT_FOUND.getMessage());
    }
}
