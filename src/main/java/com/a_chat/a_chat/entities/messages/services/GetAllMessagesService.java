package com.a_chat.a_chat.entities.messages.services;

import com.a_chat.a_chat.Query;
import com.a_chat.a_chat.entities.messages.MessageRespository;
import com.a_chat.a_chat.entities.messages.model.Message;
import com.a_chat.a_chat.entities.messages.model.MessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllMessagesService implements Query<Void, List<MessageDTO>> {
    private final MessageRespository messageRespository;

    public GetAllMessagesService(MessageRespository messageRespository) {
        this.messageRespository = messageRespository;
    }

    @Override
    public ResponseEntity<List<MessageDTO>> execute(Void input) {
        List<Message> messages = messageRespository.findAll();
        List<MessageDTO> messageDTOS = messages.stream().map(MessageDTO::new).toList();

        return ResponseEntity.status(HttpStatus.OK).body(messageDTOS);
    }
}
