package com.a_chat.a_chat.users.services;

import com.a_chat.a_chat.Query;
import com.a_chat.a_chat.users.UserRepository;
import com.a_chat.a_chat.users.model.User;
import com.a_chat.a_chat.users.model.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetUserDTOService implements Query<Integer, UserDTO> {
    private final UserRepository userRepository;

    public GetUserDTOService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<UserDTO> execute(Integer userID) {
        Optional<User> optionalUser = userRepository.findById(userID);

        if (optionalUser.isPresent()){
            return ResponseEntity.ok(new UserDTO(optionalUser.get()));
        }
        return null;
    }
}
