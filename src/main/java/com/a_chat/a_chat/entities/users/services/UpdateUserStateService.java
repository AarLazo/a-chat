package com.a_chat.a_chat.entities.users.services;

import com.a_chat.a_chat.Command;
import com.a_chat.a_chat.entities.users.exceptions.UserNotFoundException;
import com.a_chat.a_chat.entities.users.model.UpdateUserStateCommand;
import com.a_chat.a_chat.entities.users.model.UserDTO;
import com.a_chat.a_chat.entities.users.UserRepository;
import com.a_chat.a_chat.entities.users.model.User;
import com.a_chat.a_chat.entities.users.model.enums.UserState;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateUserStateService implements Command<UpdateUserStateCommand, UserDTO> {
    private final UserRepository userRepository;

    public UpdateUserStateService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<UserDTO> execute(UpdateUserStateCommand updateUserStateCommand) {
        Optional<User> optionalUser = userRepository.findById(updateUserStateCommand.getUserID());
        String cleanedState = updateUserStateCommand.getState()
                .replace("\"", "")
                .trim()
                .toUpperCase();

        if (optionalUser.isPresent()){
            User user = optionalUser.get();

            if (UserState.contains(cleanedState)){
                user.setState(UserState.valueOf(cleanedState));
                userRepository.save(user);
            }else {
                return null;
            }

            return ResponseEntity.status(HttpStatus.OK).body(new UserDTO(user));
        }
        throw new UserNotFoundException();
    }
}
