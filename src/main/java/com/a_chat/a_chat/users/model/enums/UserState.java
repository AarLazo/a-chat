package com.a_chat.a_chat.users.model.enums;

import java.util.Arrays;

public enum UserState {
    ACTIVE, INACTIVE, BANNED;

    public static boolean contains(String input) {
        if (input == null) return false;
        return Arrays.stream(UserState.values())
                .anyMatch(state -> state
                        .name()
                        .equalsIgnoreCase(input));
    }
}

