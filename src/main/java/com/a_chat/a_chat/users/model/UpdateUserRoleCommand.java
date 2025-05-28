package com.a_chat.a_chat.users.model;

import com.a_chat.a_chat.users.model.enums.UserRole;
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
