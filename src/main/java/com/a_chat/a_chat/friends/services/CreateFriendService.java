package com.a_chat.a_chat.friends.services;

import com.a_chat.a_chat.Command;
import com.a_chat.a_chat.friends.FriendRepository;
import com.a_chat.a_chat.friends.model.CreateFriendDTO;
import com.a_chat.a_chat.friends.model.Friend;
import com.a_chat.a_chat.friends.model.FriendDTO;
import com.a_chat.a_chat.users.UserRepository;
import com.a_chat.a_chat.users.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateFriendService implements Command<CreateFriendDTO, FriendDTO> {
    private final FriendRepository friendRepository;
    private final UserRepository userRepository;

    public CreateFriendService(
            FriendRepository friendRepository,
            UserRepository userRepository
    ) {
        this.friendRepository = friendRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<FriendDTO> execute(CreateFriendDTO friend) {
        Optional<User> optionalUser1 = userRepository.findById(friend.getUserID1());
        Optional<User> optionalUser2 = userRepository.findById(friend.getUserID2());
        if (optionalUser1.isPresent() && optionalUser2.isPresent()){
            Friend savedFriend = new Friend();
            savedFriend.setUser1(optionalUser1.get());
            savedFriend.setUser2(optionalUser2.get());
            friendRepository.save(savedFriend);

            return ResponseEntity.status(HttpStatus.CREATED).body(new FriendDTO(savedFriend));
        }
        return null;
    }
}
