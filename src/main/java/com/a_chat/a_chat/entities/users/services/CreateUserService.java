package com.a_chat.a_chat.entities.users.services;

import com.a_chat.a_chat.Command;
import com.a_chat.a_chat.entities.users.model.CreateUserCommand;
import com.a_chat.a_chat.entities.users.model.UserDTO;
import com.a_chat.a_chat.entities.users.UserRepository;
import com.a_chat.a_chat.entities.users.model.User;
import com.a_chat.a_chat.entities.users.validators.UserValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateUserService implements Command<CreateUserCommand, UserDTO> {
    private final UserRepository userRepository;

    public CreateUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<UserDTO> execute(CreateUserCommand createUserCommand) {

        /*UserValidator.execute(user);
        User savedUser = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(new UserDTO(savedUser));*/
        return null;
    }
}
