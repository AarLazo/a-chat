package com.a_chat.a_chat.entities.messages.model;

import lombok.Data;

@Data
public class CreateMessageDTO {
    private Integer chatID;
    private Integer userID;
    private String messageTxt;
}
