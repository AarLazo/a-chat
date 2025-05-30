package com.a_chat.a_chat.entities.chats.model;
import com.a_chat.a_chat.entities.chats.model.enums.ChatState;
import com.a_chat.a_chat.entities.users.model.UserDTO;
import lombok.Data;

@Data
public class ChatDTO {

    private Integer chatID;
    private UserDTO user1;
    private UserDTO user2;
    private ChatState state;

    public ChatDTO(Chat chat) {
        this.chatID = chat.getChatID();
        this.user1 = new UserDTO(chat.getUser1());
        this.user2 = new UserDTO(chat.getUser2());
        this.state = chat.getState();
    }
}
