package com.a_chat.a_chat.entities.friends.model;

import com.a_chat.a_chat.entities.friends.model.enums.FriendState;
import lombok.Getter;

@Getter
public class UpdateFriendCommand {
    private Integer friendID;
    private FriendState state;

    public UpdateFriendCommand(Integer friendID, FriendState state) {
        this.friendID = friendID;
        this.state = state;
    }
}
