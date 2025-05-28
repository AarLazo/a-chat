package com.a_chat.a_chat.users.model;

import com.a_chat.a_chat.users.model.enums.UserState;
import lombok.Getter;

@Getter
public class UpdateUserStateCommand {
    private Integer userID;
    private String state;

    public UpdateUserStateCommand(Integer userID, String state) {
        this.userID = userID;
        this.state = state;
    }
}
