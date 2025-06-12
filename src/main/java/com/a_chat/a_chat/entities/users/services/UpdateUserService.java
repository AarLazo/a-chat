package com.a_chat.a_chat.entities.users.services;


import com.a_chat.a_chat.Command;
import com.a_chat.a_chat.entities.users.exceptions.UserNotFoundException;
import com.a_chat.a_chat.entities.users.model.UpdateUserCommand;
import com.a_chat.a_chat.entities.users.model.UserDTO;
import com.a_chat.a_chat.entities.users.UserRepository;
import com.a_chat.a_chat.entities.users.model.User;
import com.a_chat.a_chat.entities.users.validators.UserValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateUserService implements Command<UpdateUserCommand, UserDTO> {

    private final UserRepository userRepository;
    private final UserValidator userValidator;

    public UpdateUserService(UserRepository userRepository,
                             UserValidator userValidator
    ) {
        this.userRepository = userRepository;
        this.userValidator = userValidator;
    }

    @Override
    public ResponseEntity<UserDTO> execute(UpdateUserCommand updateUserCommand) {
        System.out.println(updateUserCommand.getUser().getBirthdate());

        Optional<User> userOptional = userRepository.findById(updateUserCommand.getUserID());
        if (userOptional.isPresent()){
            User userCommand = updateUserCommand.getUser();
            User user = userOptional.get();

            user.setUsername(userCommand.getUsername());
            user.setEmail(userCommand.getEmail());
            user.setPassword(userCommand.getPassword());
            user.setBirthdate(userCommand.getBirthdate());

            userValidator.validateForUpdate(user);

            userRepository.save(user);

            return ResponseEntity.ok(new UserDTO(user));
        }
        throw new UserNotFoundException();
    }
}
