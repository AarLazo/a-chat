package com.a_chat.a_chat.posts.model;

import com.a_chat.a_chat.categories.model.Category;
import com.a_chat.a_chat.posts.model.enums.PostState;
import com.a_chat.a_chat.users.model.User;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.Instant;

@Data
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "postID")
    private Integer postID;

    @ManyToOne
    @JoinColumn(name = "userID", referencedColumnName = "userID", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "categoryID", referencedColumnName = "categoryID", nullable = false)
    private Category category;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;


    @Enumerated(EnumType.STRING)
    @Column(name = "state", nullable = false)
    private PostState state;

    @Column(name = "likes", nullable = false)
    private Integer likes;

    @Column(name = "dislikes", nullable = false)
    private Integer dislikes;

    @Column(name = "created", nullable = false)
    private Timestamp created;

    public Post() {
    }

    @PrePersist
    protected void onCreate() {
        this.state = PostState.POSTED;
        this.likes = 0;
        this.dislikes = 0;
        this.created = Timestamp.from(Instant.now());
    }
}
