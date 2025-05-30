package com.a_chat.a_chat.entities.users.model;

import lombok.Getter;

@Getter
public class UpdateUserCommand {
    private Integer userID;
    private User user;

    public UpdateUserCommand(Integer userID, User user) {
        this.userID = userID;
        this.user = user;
    }
}
