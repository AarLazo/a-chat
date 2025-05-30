package com.a_chat.a_chat.entities.users.services;

import com.a_chat.a_chat.Command;
import com.a_chat.a_chat.entities.users.UserRepository;
import com.a_chat.a_chat.entities.users.exceptions.UserNotFoundException;
import com.a_chat.a_chat.entities.users.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteUserService implements Command<Integer, Void> {

    private final UserRepository userRepository;

    public DeleteUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<Void> execute(Integer userID) {
        Optional<User> optionalUser = userRepository.findById(userID);

        if (optionalUser.isPresent()) {
            userRepository.deleteById(userID);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        throw new UserNotFoundException();
    }
}
