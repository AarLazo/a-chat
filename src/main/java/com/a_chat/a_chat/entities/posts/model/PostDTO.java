package com.a_chat.a_chat.entities.posts.model;

import com.a_chat.a_chat.entities.posts.model.enums.PostState;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class PostDTO {

    private Integer postID;

    private String username;

    private String categoryname;

    private String title;

    private String description;

    private PostState state;

    private Integer likes;

    private Integer dislikes;

    private Timestamp created;

    public PostDTO(Post post) {
        this.postID = post.getPostID();
        this.username = post.getUser().getUsername();
        this.categoryname = post.getCategory().getName();
        this.title = post.getTitle();
        this.description = post.getDescription();
        this.state = post.getState();
        this.likes = post.getLikes();
        this.dislikes = post.getDislikes();
        this.created = post.getCreated();
    }
}
