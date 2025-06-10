package com.a_chat.a_chat.entities.users.model.enums;

public enum UserErrorMessages {
    // Not found errors
    USER_NOT_FOUND("The requested user could not be found"),

    // Required field errors
    USERNAME_REQUIRED("Username is required"),
    EMAIL_REQUIRED("Email address is required"),
    PASSWORD_REQUIRED("Password is required"),
    BIRTHDATE_REQUIRED("Date of birth is required"),

    // Format validation errors
    INVALID_EMAIL_FORMAT("Please provide a valid email address"),
    INVALID_DATE_FORMAT("Invalid date format provided"),

    // Business rule errors
    USERNAME_TOO_SHORT("Username must be at least 3 characters long"),
    PASSWORD_TOO_SHORT("Password must be at least 8 characters long"),
    MINIMUM_AGE_REQUIRED("You must be at least 13 years old to register"),

    // Data validation errors
    INVALID_USER_DATA("Invalid user data provided"),
    USERNAME_ALREADY_EXISTS("This username is already taken"),
    EMAIL_ALREADY_EXISTS("An account with this email already exists");
    private final String message;

    UserErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
