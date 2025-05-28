package com.a_chat.a_chat.users.services;

import com.a_chat.a_chat.Command;
import com.a_chat.a_chat.users.UserRepository;
import com.a_chat.a_chat.users.model.UpdateUserRoleCommand;
import com.a_chat.a_chat.users.model.User;
import com.a_chat.a_chat.users.model.UserDTO;
import com.a_chat.a_chat.users.model.enums.UserRole;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateUserRoleService implements Command<UpdateUserRoleCommand, UserDTO> {
    private final UserRepository userRepository;

    public UpdateUserRoleService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<UserDTO> execute(UpdateUserRoleCommand updateUserRoleCommand) {
        Optional<User> optionalUser = userRepository.findById(updateUserRoleCommand.getUserID());
        String cleanedRole = updateUserRoleCommand.getRole()
                .replace("\"", "")
                .trim()
                .toUpperCase();

        if (optionalUser.isPresent()){
            User user = optionalUser.get();

            if (UserRole.contains(cleanedRole)){
                user.setRole(UserRole.valueOf(cleanedRole));
                userRepository.save(user);
            }else {
                return null;
            }
            return ResponseEntity.status(HttpStatus.OK).body(new UserDTO(user));
        }
        return null;
    }
}