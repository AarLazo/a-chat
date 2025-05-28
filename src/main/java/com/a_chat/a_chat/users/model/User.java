package com.a_chat.a_chat.users.model;


import com.a_chat.a_chat.friends.model.enums.FriendState;
import com.a_chat.a_chat.users.model.enums.UserChat;
import com.a_chat.a_chat.users.model.enums.UserRole;
import com.a_chat.a_chat.users.model.enums.UserState;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-generates id
    @Column(name = "userID")
    private Integer userID;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private UserRole role;

    @Enumerated(EnumType.STRING)
    @Column(name = "state", nullable = false)
    private UserState state;

    @Column(name = "birthdate", nullable = false)
    private LocalDate birthdate;

    @Enumerated(EnumType.STRING)
    @Column(name = "chat", nullable = false)
    private UserChat chat;


    @PrePersist
    protected void onCreate() {
        this.state = UserState.ACTIVE;
        this.role = UserRole.USER;
        this.chat = UserChat.OPEN;
    }
}
