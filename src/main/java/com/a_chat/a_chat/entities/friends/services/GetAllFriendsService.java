package com.a_chat.a_chat.entities.friends.services;

import com.a_chat.a_chat.Query;
import com.a_chat.a_chat.entities.friends.FriendRepository;
import com.a_chat.a_chat.entities.friends.model.Friend;
import com.a_chat.a_chat.entities.friends.model.FriendDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllFriendsService implements Query<Integer, List<FriendDTO>> {
    private final FriendRepository friendRepository;

    public GetAllFriendsService(FriendRepository friendRepository) {
        this.friendRepository = friendRepository;
    }

    @Override
    public ResponseEntity<List<FriendDTO>> execute(Integer input) {
        List<Friend> friends = friendRepository.findAll();
        List<FriendDTO> friendDTOS = friends.stream().map(FriendDTO::new).toList();


        return ResponseEntity.status(HttpStatus.OK).body(friendDTOS);
    }
}
