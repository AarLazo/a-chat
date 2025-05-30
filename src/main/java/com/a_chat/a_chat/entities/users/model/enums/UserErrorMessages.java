package com.a_chat.a_chat.entities.users.model.enums;

public enum UserErrorMessages {
    USER_NOT_FOUND("User not Found");

    private final String message;

    UserErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
