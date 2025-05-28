package com.a_chat.a_chat.users.services;

import com.a_chat.a_chat.Command;
import com.a_chat.a_chat.users.UserRepository;
import com.a_chat.a_chat.users.model.User;
import com.a_chat.a_chat.users.model.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateUserService implements Command<User, UserDTO> {
    private final UserRepository userRepository;

    public CreateUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<UserDTO> execute(User user) {

        User savedUser = userRepository.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(new UserDTO(savedUser));
    }
}
