package com.a_chat.a_chat.users.model;

import com.a_chat.a_chat.users.model.enums.UserChat;
import lombok.Getter;

@Getter
public class UpdateUserChatCommand {
    private Integer userID;
    private String chat;

    public UpdateUserChatCommand(Integer userID, String chat) {
        this.userID = userID;
        this.chat = chat;
    }
}
