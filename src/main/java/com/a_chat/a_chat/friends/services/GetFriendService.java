package com.a_chat.a_chat.friends.services;

import com.a_chat.a_chat.Query;
import com.a_chat.a_chat.friends.FriendRepository;
import com.a_chat.a_chat.friends.model.Friend;
import com.a_chat.a_chat.friends.model.FriendDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetFriendService implements Query<Integer, FriendDTO> {
    private final FriendRepository friendRepository;

    public GetFriendService(FriendRepository friendRepository) {
        this.friendRepository = friendRepository;
    }

    @Override
    public ResponseEntity<FriendDTO> execute(Integer friendID) {
        Optional<Friend> optionalFriend = friendRepository.findById(friendID);
        if (optionalFriend.isPresent()){
            return ResponseEntity.ok(new FriendDTO(optionalFriend.get()));
        }

        return null;
    }
}
