package com.a_chat.a_chat.friends.model;

import com.a_chat.a_chat.friends.model.enums.FriendState;
import com.a_chat.a_chat.users.model.UserDTO;
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
