package com.a_chat.a_chat.entities.comments.model;

import com.a_chat.a_chat.entities.comments.model.enums.CommentState;
import lombok.Getter;

@Getter
public class UpdateCommentCommand {
    private Integer commentID;
    private CommentState state;

    public UpdateCommentCommand(Integer commentID, CommentState state) {
        this.commentID = commentID;
        this.state = state;
    }
}
