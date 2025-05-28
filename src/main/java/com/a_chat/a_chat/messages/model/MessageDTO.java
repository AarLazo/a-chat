package com.a_chat.a_chat.messages.model;

import com.a_chat.a_chat.chats.model.ChatDTO;
import com.a_chat.a_chat.users.model.UserDTO;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class MessageDTO {
    private Integer messageID;
    private String username;
    private String messageTxt;
    private Timestamp created;

    public MessageDTO(Message message) {
        this.messageID = message.getMessageID();
        this.username = message.getUser().getUsername();
        this.messageTxt = message.getMessageTxt();
        this.created = message.getCreated();
    }
}
