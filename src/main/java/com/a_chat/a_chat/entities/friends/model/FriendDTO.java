package com.a_chat.a_chat.entities.friends.model;

import com.a_chat.a_chat.entities.users.model.UserDTO;
import com.a_chat.a_chat.entities.friends.model.enums.FriendState;
import lombok.Data;

@Data
public class FriendDTO {
    private Integer friendID;
    private UserDTO user1;
    private UserDTO user2;
    private FriendState state;

    public FriendDTO(Friend friend) {
        this.friendID = friend.getFriendID();
        this.user1 = new UserDTO(friend.getUser1());
        this.user2 = new UserDTO(friend.getUser2());
        this.state = friend.getState();
    }
}
