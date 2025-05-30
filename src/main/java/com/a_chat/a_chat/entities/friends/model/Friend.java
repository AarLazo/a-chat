package com.a_chat.a_chat.entities.friends.model;

import com.a_chat.a_chat.entities.friends.model.enums.FriendState;
import com.a_chat.a_chat.entities.users.model.User;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "friends")
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "friendID")
    private Integer friendID;

    @ManyToOne
    @JoinColumn(name = "userID1", referencedColumnName = "userID", nullable = false)
    private User user1;

    @ManyToOne
    @JoinColumn(name = "userID2", referencedColumnName = "userID", nullable = false)
    private User user2;

    @Enumerated(EnumType.STRING)
    @Column(name = "state", nullable = false)
    private FriendState state;

    @PrePersist
    protected void onCreate() {
        this.state = FriendState.REQUESTED;
    }
}

