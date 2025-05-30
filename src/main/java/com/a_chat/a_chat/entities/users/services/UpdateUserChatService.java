package com.a_chat.a_chat.entities.users.services;

import com.a_chat.a_chat.Command;
import com.a_chat.a_chat.entities.users.model.UpdateUserChatCommand;
import com.a_chat.a_chat.entities.users.model.UserDTO;
import com.a_chat.a_chat.entities.users.UserRepository;
import com.a_chat.a_chat.entities.users.model.User;
import com.a_chat.a_chat.entities.users.model.enums.UserChat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateUserChatService implements Command<UpdateUserChatCommand, UserDTO> {
    private final UserRepository userRepository;

    public UpdateUserChatService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<UserDTO> execute(UpdateUserChatCommand updateUserChatCommand) {
        Optional<User> optionalUser = userRepository.findById(updateUserChatCommand.getUserID());
        String cleanedChat = updateUserChatCommand.getChat()
                .replace("\"", "")
                .trim()
                .toUpperCase();

        if (optionalUser.isPresent()){
            User user = optionalUser.get();

            if (UserChat.contains(cleanedChat)){
                user.setChat(UserChat.valueOf(cleanedChat));
                userRepository.save(user);
            }else {
                return null;
            }
            return ResponseEntity.status(HttpStatus.OK).body(new UserDTO(user));
        }
        return null;
    }
}
