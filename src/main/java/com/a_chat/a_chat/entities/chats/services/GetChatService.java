package com.a_chat.a_chat.entities.chats.services;

import com.a_chat.a_chat.Query;
import com.a_chat.a_chat.entities.chats.ChatRepository;
import com.a_chat.a_chat.entities.chats.model.Chat;
import com.a_chat.a_chat.entities.chats.model.ChatDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetChatService implements Query<Integer, ChatDTO> {
    private final ChatRepository chatRepository;

    public GetChatService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    @Override
    public ResponseEntity<ChatDTO> execute(Integer chatID) {
        Optional<Chat> optionalChat = chatRepository.findById(chatID);
        if (optionalChat.isPresent()){
            return ResponseEntity.ok(new ChatDTO(optionalChat.get()));
        }

        return null;
    }
}
