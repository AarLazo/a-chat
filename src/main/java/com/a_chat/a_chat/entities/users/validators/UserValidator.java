package com.a_chat.a_chat.entities.users.validators;

import com.a_chat.a_chat.entities.users.UserRepository;
import com.a_chat.a_chat.entities.users.exceptions.UserNotValidExeption;
import com.a_chat.a_chat.entities.users.model.User;
import com.a_chat.a_chat.entities.users.model.enums.UserErrorMessages;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.regex.Pattern;

@Component
public class UserValidator {
    private final UserRepository userRepository;
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final int MIN_USERNAME_LENGTH = 3;

    public UserValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void validateForCreation(User user) {
        validateRequiredFields(user);
        validateFieldFormats(user);
        validateBusinessRules(user);
        validateUniqueness(user);
    }

    public void validateForUpdate(User user) {
        validateRequiredFields(user);
        validateFieldFormats(user);
        validateBusinessRules(user);
        validateUniquenessForUpdate(user);
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

        if (user.getBirthdate().plusYears(13).isAfter(LocalDate.now())) {
            throw new UserNotValidExeption(UserErrorMessages.MINIMUM_AGE_REQUIRED.getMessage());
        }
    }

    private void validateUniqueness(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new UserNotValidExeption(UserErrorMessages.USERNAME_ALREADY_EXISTS.getMessage());
        }

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new UserNotValidExeption(UserErrorMessages.EMAIL_ALREADY_EXISTS.getMessage());
        }
    }

    private void validateUniquenessForUpdate(User user) {
        if (userRepository.existsByUsernameAndUserIDNot(user.getUsername(), user.getUserID())) {
            throw new UserNotValidExeption(UserErrorMessages.USERNAME_ALREADY_EXISTS.getMessage());
        }

        if (userRepository.existsByEmailAndUserIDNot(user.getEmail(), user.getUserID())) {
            throw new UserNotValidExeption(UserErrorMessages.EMAIL_ALREADY_EXISTS.getMessage());
        }
    }
}
