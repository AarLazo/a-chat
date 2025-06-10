package com.a_chat.a_chat.entities.users.services;

import com.a_chat.a_chat.Command;
import com.a_chat.a_chat.entities.users.model.CreateUserCommand;
import com.a_chat.a_chat.entities.users.model.UserDTO;
import com.a_chat.a_chat.entities.users.UserRepository;
import com.a_chat.a_chat.entities.users.model.User;
import com.a_chat.a_chat.entities.users.validators.UserFactory;
import com.a_chat.a_chat.entities.users.validators.UserValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateUserService implements Command<CreateUserCommand, UserDTO> {
    private final UserRepository userRepository;
    private final UserValidator userValidator;

    public CreateUserService(UserRepository userRepository, UserValidator userValidator) {
        this.userRepository = userRepository;
        this.userValidator = userValidator;
    }

    @Override
    public ResponseEntity<UserDTO> execute(CreateUserCommand createUserCommand) {
        User user = UserFactory.createFromCommand(createUserCommand);
        userValidator.validateForCreation(user);
        User savedUser = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(new UserDTO(savedUser));
    }
}
