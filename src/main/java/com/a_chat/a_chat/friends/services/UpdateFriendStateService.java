package com.a_chat.a_chat.friends.services;

import com.a_chat.a_chat.Command;
import com.a_chat.a_chat.friends.FriendRepository;
import com.a_chat.a_chat.friends.model.Friend;
import com.a_chat.a_chat.friends.model.FriendDTO;
import com.a_chat.a_chat.friends.model.UpdateFriendCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateFriendStateService implements Command<UpdateFriendCommand, FriendDTO> {
    private final FriendRepository friendRepository;

    public UpdateFriendStateService(FriendRepository friendRepository) {
        this.friendRepository = friendRepository;
    }

    @Override
    public ResponseEntity<FriendDTO> execute(UpdateFriendCommand updateFriendCommand) {
        Optional<Friend> optionalFriend = friendRepository.findById(updateFriendCommand.getFriendID());
        if (optionalFriend.isPresent()){
            Friend friend = optionalFriend.get();
            friend.setState(updateFriendCommand.getState());
            friendRepository.save(friend);

            return ResponseEntity.ok(new FriendDTO(friend));
        }

        return null;
    }
}
