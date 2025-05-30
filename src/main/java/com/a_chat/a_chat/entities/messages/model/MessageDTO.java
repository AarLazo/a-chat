package com.a_chat.a_chat.entities.messages.model;

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
