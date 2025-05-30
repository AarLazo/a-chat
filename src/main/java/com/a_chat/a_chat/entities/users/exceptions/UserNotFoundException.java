package com.a_chat.a_chat.entities.users.exceptions;

import com.a_chat.a_chat.entities.users.model.enums.UserErrorMessages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException{

    private static final Logger logger = LoggerFactory.getLogger(UserNotFoundException.class);

    public UserNotFoundException() {
        super(UserErrorMessages.USER_NOT_FOUND.getMessage());
        logger.error("Exception " + getClass() + "thrown");
    }
}
