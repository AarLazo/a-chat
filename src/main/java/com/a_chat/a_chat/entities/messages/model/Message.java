package com.a_chat.a_chat.entities.messages.model;

import com.a_chat.a_chat.entities.chats.model.Chat;
import com.a_chat.a_chat.entities.users.model.User;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Data
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "messageID")
    private Integer messageID;

    @ManyToOne
    @JoinColumn(name = "chatID", referencedColumnName = "chatID", nullable = false)
    private Chat chat;

    @ManyToOne
    @JoinColumn(name = "userID", referencedColumnName = "userID", nullable = false)
    private User user;

    @Column(name = "messagetxt", nullable = false)
    private String messageTxt;

    @Column(name = "created", nullable = false)
    private Timestamp created;

    public Message() {
    }

    @PrePersist
    protected void onCreate() {
        this.created = Timestamp.from(Instant.now());
    }

}
