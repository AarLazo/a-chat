package com.a_chat.a_chat.chats.model;

import com.a_chat.a_chat.users.model.User;
import lombok.Data;

@Data
public class CreateChatDTO {
    private Integer userID1;
    private Integer userID2;
}
