package com.a_chat.a_chat.entities.users.model;

import lombok.Getter;

@Getter
public class UserErrorResponse {
    private String message;

    public UserErrorResponse(String message) {
        this.message = message;
    }
}
