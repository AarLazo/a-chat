package com.a_chat.a_chat.entities.users.model.enums;

import java.util.Arrays;

public enum UserChat {
    OPEN, CLOSED;
    public static boolean contains(String input) {
        if (input == null) return false;
        return Arrays.stream(UserChat.values())
                .anyMatch(chat -> chat
                        .name()
                        .equalsIgnoreCase(input));
    }
}
