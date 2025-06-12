package com.a_chat.a_chat.entities.users.validators;

import com.a_chat.a_chat.entities.users.exceptions.UserNotValidExeption;
import com.a_chat.a_chat.entities.users.model.CreateUserCommand;
import com.a_chat.a_chat.entities.users.model.User;
import com.a_chat.a_chat.entities.users.model.enums.UserErrorMessages;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class UserFactory {
    private UserFactory() {
    }

    public static User createFromCommand(CreateUserCommand createUserCommand) {
        if (createUserCommand == null) {
            throw new UserNotValidExeption(UserErrorMessages.INVALID_USER_DATA.getMessage());
        }

        User user = new User();
        user.setUsername(createUserCommand.getUsername());
        user.setEmail(createUserCommand.getEmail());
        user.setPassword(createUserCommand.getPassword());

        try {
            user.setBirthdate(LocalDate.parse(createUserCommand.getBirthdate()));
        } catch (DateTimeParseException e) {
            throw new UserNotValidExeption(
                    UserErrorMessages.INVALID_DATE_FORMAT.getMessage() +
                            ". Expected format: YYYY-MM-DD"
            );
        }

        return user;
    }
}
