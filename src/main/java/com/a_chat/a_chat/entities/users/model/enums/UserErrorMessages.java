package com.a_chat.a_chat.entities.users.model.enums;

public enum UserErrorMessages {
    USER_NOT_FOUND("User not Found"),
    USERNAME_REQUIRED("Username is required"),
    EMAIL_REQUIRED("Email is required"),
    PASSWORD_REQUIRED("Password is required"),
    BIRTHDATE_REQUIRED("Birthdate is required");

    private final String message;

    UserErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
