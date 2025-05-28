package com.a_chat.a_chat.posts.model;

import com.a_chat.a_chat.posts.model.enums.PostState;
import lombok.Data;

@Data
public class UpdatePostCommand {
    private Integer postID;
    private PostState state;

    public UpdatePostCommand(Integer postID, PostState state) {
        this.postID = postID;
        this.state = state;
    }
}
