package com.a_chat.a_chat.comments.model;

import com.a_chat.a_chat.comments.model.enums.CommentState;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class CreateCommentDTO {
    private Integer userID;
    private Integer postID;
    private Integer respCommentID;
    private String description;
}
