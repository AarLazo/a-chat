package com.a_chat.a_chat.entities.friends.services;

import com.a_chat.a_chat.Query;
import com.a_chat.a_chat.entities.friends.FriendRepository;
import com.a_chat.a_chat.entities.friends.model.Friend;
import com.a_chat.a_chat.entities.friends.model.FriendDTO;
import com.a_chat.a_chat.entities.users.model.User;
import com.a_chat.a_chat.entities.users.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetFriendsByUser implements Query<Integer, List<FriendDTO>> {
    private final FriendRepository friendRepository;
    private final UserRepository userRepository;

    public GetFriendsByUser(
            FriendRepository friendRepository,
            UserRepository userRepository
    ) {
        this.friendRepository = friendRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<List<FriendDTO>> execute(Integer userID) {
        Optional<User> optionalUser = userRepository.findById(userID);
        if (optionalUser.isPresent()){
            List<Friend> friends = friendRepository.getFriendsByUser(userID);
            List<FriendDTO> friendDTOS = friends.stream().map(FriendDTO::new).toList();

            return ResponseEntity.status(HttpStatus.OK).body(friendDTOS);
        }

        return null;
    }
}
