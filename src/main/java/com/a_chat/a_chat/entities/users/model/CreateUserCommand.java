package com.a_chat.a_chat.entities.users.model;

import lombok.Getter;
import lombok.ToString;

@Getter
public class CreateUserCommand {
    private String username;
    private String email;
    private String password;
    private String birthdate;

    public CreateUserCommand(String username, String email, String password, String birthdate) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.birthdate = birthdate;
    }
}
