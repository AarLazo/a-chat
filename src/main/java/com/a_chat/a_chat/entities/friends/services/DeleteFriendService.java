package com.a_chat.a_chat.entities.friends.services;

import com.a_chat.a_chat.Command;
import com.a_chat.a_chat.entities.friends.FriendRepository;
import com.a_chat.a_chat.entities.friends.model.Friend;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteFriendService implements Command<Integer, Void> {
    private final FriendRepository friendRepository;

    public DeleteFriendService(FriendRepository friendRepository) {
        this.friendRepository = friendRepository;
    }

    @Override
    public ResponseEntity<Void> execute(Integer friendID) {
        Optional<Friend> optionalFriend = friendRepository.findById(friendID);
        if (optionalFriend.isPresent()){
            friendRepository.deleteById(friendID);

            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return null;
    }
}
