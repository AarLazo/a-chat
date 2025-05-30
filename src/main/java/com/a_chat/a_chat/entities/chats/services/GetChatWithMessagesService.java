package com.a_chat.a_chat.entities.chats.services;


import com.a_chat.a_chat.Query;
import com.a_chat.a_chat.entities.chats.ChatRepository;
import com.a_chat.a_chat.entities.chats.model.Chat;
import com.a_chat.a_chat.entities.chats.model.ChatMessages;
import com.a_chat.a_chat.entities.messages.MessageRespository;
import com.a_chat.a_chat.entities.messages.model.Message;
import com.a_chat.a_chat.entities.messages.model.MessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class GetChatWithMessagesService implements Query<Integer, ChatMessages> {
    private final ChatRepository chatRepository;
    private final MessageRespository messageRespository;

    public GetChatWithMessagesService(
            ChatRepository chatRepository,
            MessageRespository messageRespository
    ) {
        this.chatRepository = chatRepository;
        this.messageRespository = messageRespository;
    }

    @Override
    public ResponseEntity<ChatMessages> execute(Integer chatID) {
        Optional<Chat> optionalChat = chatRepository.findById(chatID);
        if (optionalChat.isPresent()){
            List<Message> messages = messageRespository.findByChat(optionalChat.get());
            List<MessageDTO> messageDTOS = messages.stream().map(MessageDTO::new).toList();
            ChatMessages chatMessages = new ChatMessages();
            chatMessages.setChatID(chatID);
            chatMessages.setMessages(messageDTOS);


            return ResponseEntity.status(HttpStatus.OK).body(chatMessages);
        }

        return null;
    }
}
