package com.a_chat.a_chat.entities.chats.model;

import com.a_chat.a_chat.entities.chats.model.enums.ChatState;
import com.a_chat.a_chat.entities.users.model.User;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Data
@Table(name = "chats")
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chatID")
    private Integer chatID;

    @ManyToOne
    @JoinColumn(name = "userID1", referencedColumnName = "userID", nullable = false)
    private User user1;

    @ManyToOne
    @JoinColumn(name = "userID2", referencedColumnName = "userID", nullable = false)
    private User user2;

    @Column(name = "created", updatable = false, nullable = false)
    private Timestamp created;

    @Enumerated(EnumType.STRING)
    @Column(name = "state", nullable = false)
    private ChatState state;

    public Chat() {
    }

    @PrePersist
    protected void onCreate() {
        this.created = Timestamp.from(Instant.now());
        this.state = ChatState.ACTIVE;
    }

}
