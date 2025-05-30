package com.a_chat.a_chat.entities.chats.model;

import com.a_chat.a_chat.entities.messages.model.MessageDTO;
import lombok.Data;

import java.util.List;

@Data
public class ChatMessages {
    private Integer chatID;
    private List<MessageDTO> messages;
}