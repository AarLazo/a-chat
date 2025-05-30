package com.a_chat.a_chat.entities.users.services;

import com.a_chat.a_chat.Query;
import com.a_chat.a_chat.entities.users.exceptions.UserNotFoundException;
import com.a_chat.a_chat.entities.users.model.UserDTO;
import com.a_chat.a_chat.entities.users.UserRepository;
import com.a_chat.a_chat.entities.users.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetUserService implements Query<Integer, UserDTO> {
    private final UserRepository userRepository;

    public GetUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<UserDTO> execute(Integer userID) {
        Optional<User> optionalUser = userRepository.findById(userID);
        if (optionalUser.isPresent()){
            return ResponseEntity.ok(new UserDTO(optionalUser.get()));
        }
        throw new UserNotFoundException();
    }
}
