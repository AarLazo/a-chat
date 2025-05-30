package com.a_chat.a_chat.entities.users.model;

import lombok.Getter;

@Getter
public class UpdateUserRoleCommand {
    private Integer userID;
    private String role;

    public UpdateUserRoleCommand(Integer userID, String role) {
        this.userID = userID;
        this.role = role;
    }
}
