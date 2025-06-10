package com.a_chat.a_chat.entities.users.validators;

import com.a_chat.a_chat.entities.users.exceptions.UserNotValidExeption;
import com.a_chat.a_chat.entities.users.model.User;
import com.a_chat.a_chat.entities.users.model.enums.UserErrorMessages;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class UserValidator {
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final int MIN_USERNAME_LENGTH = 3;

    private UserValidator() {
    }

    public static void execute(User user) {
        validateRequiredFields(user);
        validateFieldFormats(user);
        validateBusinessRules(user);
    }

    private static void validateRequiredFields(User user) {
        if (user == null) {
            throw new UserNotValidExeption(UserErrorMessages.INVALID_USER_DATA.getMessage());
        }

        if (!StringUtils.hasText(user.getUsername())) {
            throw new UserNotValidExeption(UserErrorMessages.USERNAME_REQUIRED.getMessage());
        }

        if (!StringUtils.hasText(user.getEmail())) {
            throw new UserNotValidExeption(UserErrorMessages.EMAIL_REQUIRED.getMessage());
        }

        if (!StringUtils.hasText(user.getPassword())) {
            throw new UserNotValidExeption(UserErrorMessages.PASSWORD_REQUIRED.getMessage());
        }

        if (user.getBirthdate() == null) {
            throw new UserNotValidExeption(UserErrorMessages.BIRTHDATE_REQUIRED.getMessage());
        }
    }

    private static void validateFieldFormats(User user) {
        if (!EMAIL_PATTERN.matcher(user.getEmail()).matches()) {
            throw new UserNotValidExeption(UserErrorMessages.INVALID_EMAIL_FORMAT.getMessage());
        }
    }

    private static void validateBusinessRules(User user) {
        if (user.getUsername().length() < MIN_USERNAME_LENGTH) {
            throw new UserNotValidExeption(UserErrorMessages.USERNAME_TOO_SHORT.getMessage());
        }

        if (user.getPassword().length() < MIN_PASSWORD_LENGTH) {
            throw new UserNotValidExeption(UserErrorMessages.PASSWORD_TOO_SHORT.getMessage());
        }

        // Validar edad mínima (ejemplo: 13 años)
        if (user.getBirthdate().plusYears(13).isAfter(LocalDate.now())) {
            throw new UserNotValidExeption(UserErrorMessages.MINIMUM_AGE_REQUIRED.getMessage());
        }
    }
}
