package com.a_chat.a_chat.entities.comments.model;

import com.a_chat.a_chat.entities.comments.model.enums.CommentState;
import com.a_chat.a_chat.entities.posts.model.Post;
import com.a_chat.a_chat.entities.users.model.User;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.Instant;

@Data
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commentID")
    private Integer commentID;

    @ManyToOne
    @JoinColumn(name = "userID", referencedColumnName = "userID", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "postID", referencedColumnName = "postID", nullable = false)
    private Post post;

    @Column(name = "respcommentID", nullable = true)
    private Integer respCommentID;

    @Column(name = "description", nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "state", nullable = false)
    private CommentState state;

    @Column(name = "likes", nullable = false)
    private Integer likes;

    @Column(name = "dislikes", nullable = false)
    private Integer dislikes;

    @Column(name = "opliked", nullable = false)
    private Boolean opLiked;

    @Column(name = "pinned", nullable = false)
    private Boolean pinned;

    @Column(name = "created", nullable = false)
    private Timestamp created;

    public Comment(){
    }

    @PrePersist
    protected void onCreate() {
        this.state = CommentState.ACTIVE;
        this.likes = 0;
        this.dislikes = 0;
        this.opLiked = false;
        this.pinned = false;
        this.created = Timestamp.from(Instant.now());
    }
}
