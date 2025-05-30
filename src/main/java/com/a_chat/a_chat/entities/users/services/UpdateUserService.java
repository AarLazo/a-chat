package com.a_chat.a_chat.entities.users.services;


import com.a_chat.a_chat.Command;
import com.a_chat.a_chat.entities.users.model.UpdateUserCommand;
import com.a_chat.a_chat.entities.users.model.UserDTO;
import com.a_chat.a_chat.entities.users.UserRepository;
import com.a_chat.a_chat.entities.users.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateUserService implements Command<UpdateUserCommand, UserDTO> {

    private final UserRepository userRepository;

    public UpdateUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<UserDTO> execute(UpdateUserCommand updateUserCommand) {

        Optional<User> userOptional = userRepository.findById(updateUserCommand.getUserID());
        if (userOptional.isPresent()){
            User userCommand = updateUserCommand.getUser();
            User user = userOptional.get();

            user.setUsername(userCommand.getUsername());
            user.setEmail(userCommand.getEmail());
            user.setPassword(userCommand.getPassword());
            user.setBirthdate(userCommand.getBirthdate());

            userRepository.save(user);

            return ResponseEntity.ok(new UserDTO(user));
        }
        return null;
    }
}
