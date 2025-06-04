package com.a_chat.a_chat.entities.users.validators;

import com.a_chat.a_chat.entities.users.exceptions.UserNotValidExeption;
import com.a_chat.a_chat.entities.users.model.User;
import com.a_chat.a_chat.entities.users.model.enums.UserErrorMessages;
import org.springframework.util.StringUtils;

public class UserValidator {
    private  UserValidator() {
    }

    public static void execute(User user){
        //exists
        if (StringUtils.isEmpty(user.getUsername())){
            throw new UserNotValidExeption(UserErrorMessages.USERNAME_REQUIRED.getMessage());
        }
        if (StringUtils.isEmpty(user.getEmail())){
            throw new UserNotValidExeption(UserErrorMessages.EMAIL_REQUIRED.getMessage());
        }
        if (StringUtils.isEmpty(user.getPassword())){
            throw new UserNotValidExeption(UserErrorMessages.PASSWORD_REQUIRED.getMessage());
        }
        if (StringUtils.isEmpty(user.getBirthdate())){
            throw new UserNotValidExeption(UserErrorMessages.BIRTHDATE_REQUIRED.getMessage());
        }

        //length
    }
}
