package com.a_chat.a_chat.comments.model;

import com.a_chat.a_chat.comments.model.enums.CommentState;
import com.a_chat.a_chat.posts.model.Post;
import com.a_chat.a_chat.users.model.User;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class CommentDTO {
    private Integer commentID;

    private String username;

    private String postID;

    private Integer respCommentID;

    private String description;

    private CommentState state;

    private Integer likes;

    private Integer dislikes;

    private Boolean opLiked;

    private Boolean pinned;

    private Timestamp created;

    public CommentDTO(Comment comment){
        this.commentID = comment.getCommentID();
        this.username = comment.getUser().getUsername();
        this.postID = comment.getPost().getTitle();
        this.respCommentID = comment.getRespCommentID();
        this.description = comment.getDescription();
        this.state = comment.getState();
        this.likes = comment.getLikes();
        this.dislikes = comment.getDislikes();
        this.opLiked = comment.getOpLiked();
        this.pinned = comment.getPinned();
        this.created = comment.getCreated();
    }
}
