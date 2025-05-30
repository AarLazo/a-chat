package com.a_chat.a_chat.entities.messages.services;

import com.a_chat.a_chat.Query;
import com.a_chat.a_chat.entities.messages.MessageRespository;
import com.a_chat.a_chat.entities.messages.model.Message;
import com.a_chat.a_chat.entities.messages.model.MessageDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetMessageService implements Query<Integer, MessageDTO> {
    private final MessageRespository messageRespository;

    public GetMessageService(MessageRespository messageRespository) {
        this.messageRespository = messageRespository;
    }

    @Override
    public ResponseEntity<MessageDTO> execute(Integer messageID) {
        Optional<Message> optionalMessage = messageRespository.findById(messageID);
        if (optionalMessage.isPresent()){
            return ResponseEntity.ok(new MessageDTO(optionalMessage.get()));
        }

        return null;
    }
}
