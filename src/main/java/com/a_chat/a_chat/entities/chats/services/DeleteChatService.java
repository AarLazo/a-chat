package com.a_chat.a_chat.entities.chats.services;

import com.a_chat.a_chat.Command;
import com.a_chat.a_chat.entities.chats.ChatRepository;
import com.a_chat.a_chat.entities.chats.model.Chat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteChatService implements Command<Integer, Void> {

    private final ChatRepository chatRepository;

    public DeleteChatService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    @Override
    public ResponseEntity<Void> execute(Integer chatID) {
        Optional<Chat> optionalChat = chatRepository.findById(chatID);
        if (optionalChat.isPresent()){
            chatRepository.deleteById(chatID);

            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return null;
    }
}
