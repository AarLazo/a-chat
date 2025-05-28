package com.a_chat.a_chat.chats.services;

import com.a_chat.a_chat.Query;
import com.a_chat.a_chat.chats.ChatRepository;
import com.a_chat.a_chat.chats.model.Chat;
import com.a_chat.a_chat.chats.model.ChatDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllChatsService implements Query<Void, List<ChatDTO>> {

    private final ChatRepository chatRepository;

    public GetAllChatsService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    @Override
    public ResponseEntity<List<ChatDTO>> execute(Void input) {
        List<Chat> chats = chatRepository.findAll();
        List<ChatDTO> chatDTOS = chats.stream().map(ChatDTO::new).toList();

        return ResponseEntity.status(HttpStatus.OK).body(chatDTOS);
    }
}
