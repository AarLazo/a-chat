package com.a_chat.a_chat.entities.posts.model;

import com.a_chat.a_chat.entities.comments.model.CommentDTO;
import lombok.Data;

import java.util.List;

@Data
public class PostComments {
    private Integer postID;
    private List<CommentDTO> comments;
}
