package com.a_chat.a_chat.entities.comments.model;

import lombok.Data;

@Data
public class CreateCommentDTO {
    private Integer userID;
    private Integer postID;
    private Integer respCommentID;
    private String description;
}
