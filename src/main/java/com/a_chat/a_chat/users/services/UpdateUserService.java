package com.a_chat.a_chat.users.services;


import com.a_chat.a_chat.Command;
import com.a_chat.a_chat.users.UserRepository;
import com.a_chat.a_chat.users.model.UpdateUserCommand;
import com.a_chat.a_chat.users.model.User;
import com.a_chat.a_chat.users.model.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
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
