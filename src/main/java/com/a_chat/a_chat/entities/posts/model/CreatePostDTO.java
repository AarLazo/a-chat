package com.a_chat.a_chat.entities.posts.model;

import com.a_chat.a_chat.entities.posts.model.enums.PostState;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class CreatePostDTO {
    private Integer postID;

    private Integer userID;

    private Integer categoryID;

    private String title;

    private String description;

    private PostState state;

    private Integer likes;

    private Integer dislikes;

    private Timestamp created;

}
