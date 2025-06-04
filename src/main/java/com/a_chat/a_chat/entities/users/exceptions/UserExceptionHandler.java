package com.a_chat.a_chat.entities.users.exceptions;

import com.a_chat.a_chat.entities.users.model.UserErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UserExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public UserErrorResponse handleProductNotFoundException(UserNotFoundException exception){
        return new UserErrorResponse(exception.getMessage());
    }
    @ExceptionHandler(UserNotValidExeption.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public UserErrorResponse handleProductNotValidException(UserNotValidExeption exception){
        return new UserErrorResponse(exception.getMessage());
    }
}
