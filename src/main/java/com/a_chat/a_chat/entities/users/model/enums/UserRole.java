package com.a_chat.a_chat.entities.users.model.enums;

import java.util.Arrays;

public enum UserRole {
    USER, ADMIN;

    public static boolean contains(String input) {
        if (input == null) return false;
        return Arrays.stream(UserRole.values())
                .anyMatch(role -> role
                        .name()
                        .equalsIgnoreCase(input));
    }
}
