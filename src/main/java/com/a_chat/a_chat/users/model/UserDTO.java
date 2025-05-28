package com.a_chat.a_chat.users.model;

import com.a_chat.a_chat.users.model.enums.UserChat;
import com.a_chat.a_chat.users.model.enums.UserRole;
import com.a_chat.a_chat.users.model.enums.UserState;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;

@Data
public class UserDTO {
    private Integer userID;

    private String username;

    private UserRole role;

    private UserState state;

    private LocalDate birthdate;

    private UserChat chat;


    public UserDTO(User user) {
        this.userID = user.getUserID();
        this.username = user.getUsername();
        this.role = user.getRole();
        this.state = user.getState();
        this.birthdate = user.getBirthdate();
        this.chat = user.getChat();
    }



}
