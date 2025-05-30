package com.a_chat.a_chat.entities.messages.services;

import com.a_chat.a_chat.Command;
import com.a_chat.a_chat.entities.messages.MessageRespository;
import com.a_chat.a_chat.entities.messages.model.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteMessageService implements Command<Integer, Void> {
    private final MessageRespository messageRespository;

    public DeleteMessageService(MessageRespository messageRespository) {
        this.messageRespository = messageRespository;
    }

    @Override
    public ResponseEntity<Void> execute(Integer messageID) {
        Optional<Message> optionalMessage = messageRespository.findById(messageID);
        if (optionalMessage.isPresent()){
            messageRespository.deleteById(messageID);

            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return null;
    }
}
