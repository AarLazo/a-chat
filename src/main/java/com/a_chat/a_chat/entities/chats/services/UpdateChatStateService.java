package com.a_chat.a_chat.entities.chats.services;

import com.a_chat.a_chat.Command;
import com.a_chat.a_chat.entities.chats.ChatRepository;
import com.a_chat.a_chat.entities.chats.model.Chat;
import com.a_chat.a_chat.entities.chats.model.ChatDTO;
import com.a_chat.a_chat.entities.chats.model.UpdateChatCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateChatStateService implements Command<UpdateChatCommand, ChatDTO> {

    private final ChatRepository chatRepository;

    public UpdateChatStateService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    @Override
    public ResponseEntity<ChatDTO> execute(UpdateChatCommand updateChatCommand) {
        Optional<Chat> optionalChat = chatRepository.findById(updateChatCommand.getChatID());
        if (optionalChat.isPresent()){
            Chat chat = optionalChat.get();
            chat.setState(updateChatCommand.getState());
            chatRepository.save(chat);

            return ResponseEntity.ok(new ChatDTO(chat));
        }


        return null;
    }
}
