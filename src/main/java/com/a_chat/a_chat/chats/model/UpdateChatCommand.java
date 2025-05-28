package com.a_chat.a_chat.chats.model;

import com.a_chat.a_chat.chats.model.enums.ChatState;
import lombok.Getter;

@Getter
public class UpdateChatCommand {
    private Integer chatID;
    private ChatState state;

    public UpdateChatCommand(Integer chatID, ChatState state) {
        this.chatID = chatID;
        this.state = state;
    }
}
