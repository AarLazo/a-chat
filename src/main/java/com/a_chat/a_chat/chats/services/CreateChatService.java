package com.a_chat.a_chat.chats.services;

import com.a_chat.a_chat.Command;
import com.a_chat.a_chat.chats.ChatRepository;
import com.a_chat.a_chat.chats.model.Chat;
import com.a_chat.a_chat.chats.model.ChatDTO;
import com.a_chat.a_chat.chats.model.CreateChatDTO;
import com.a_chat.a_chat.users.UserRepository;
import com.a_chat.a_chat.users.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateChatService implements Command<CreateChatDTO, ChatDTO> {
    private final ChatRepository chatRepository;
    private final UserRepository userRepository;

    public CreateChatService(ChatRepository chatRepository, UserRepository userRepository) {
        this.chatRepository = chatRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<ChatDTO>  execute(CreateChatDTO chat) {
        Optional<User> optionalUser1 = userRepository.findById(chat.getUserID1());
        Optional<User> optionalUser2 = userRepository.findById(chat.getUserID2());

        if (optionalUser1.isPresent() && optionalUser2.isPresent()) {
            Chat savedChat = new Chat();
            savedChat.setUser1(optionalUser1.get());
            savedChat.setUser2(optionalUser2.get());
            chatRepository.save(savedChat);

            return ResponseEntity.status(HttpStatus.CREATED).body(new ChatDTO(savedChat));
        }

        return null;
    }
}
