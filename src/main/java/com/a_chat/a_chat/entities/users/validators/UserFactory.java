package com.a_chat.a_chat.entities.users.validators;

import com.a_chat.a_chat.entities.users.exceptions.UserNotValidExeption;
import com.a_chat.a_chat.entities.users.model.CreateUserCommand;
import com.a_chat.a_chat.entities.users.model.User;
import com.a_chat.a_chat.entities.users.model.enums.UserErrorMessages;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class UserFactory {
    private UserFactory() {
        // Constructor privado para clase de utilidad
    }

    public static User createFromCommand(CreateUserCommand createUserCommand) {
        validateCommand(createUserCommand);

        User user = new User();
        user.setUsername(createUserCommand.getUsername());
        user.setEmail(createUserCommand.getEmail());
        user.setPassword(createUserCommand.getPassword());
        user.setBirthdate(parseBirthdate(createUserCommand.getBirthdate()));

        // Validar DESPUÉS de establecer todos los campos
        UserValidator.execute(user);

        return user;
    }

    private static void validateCommand(CreateUserCommand command) {
        if (command == null) {
            throw new UserNotValidExeption(UserErrorMessages.INVALID_USER_DATA.getMessage());
        }
    }

    private static LocalDate parseBirthdate(String birthdate) {
        try {
            return LocalDate.parse(birthdate);
        } catch (DateTimeParseException e) {
            throw new UserNotValidExeption(
                    UserErrorMessages.INVALID_DATE_FORMAT.getMessage() +
                            ". Expected format: YYYY-MM-DD"
            );
        }
    }
}
