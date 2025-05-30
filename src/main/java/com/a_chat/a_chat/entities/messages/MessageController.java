package com.a_chat.a_chat.entities.messages;

import com.a_chat.a_chat.entities.messages.model.CreateMessageDTO;
import com.a_chat.a_chat.entities.messages.model.MessageDTO;
import com.a_chat.a_chat.entities.messages.services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {
    private final CreateMessageService createMessageService;
    private final GetMessageService getMessageService;
    private final GetAllMessagesService getAllMessagesService;
    private final UpdateMessageService updateMessageService;
    private final DeleteMessageService deleteMessageService;

    public MessageController(
            CreateMessageService createMessageService,
            GetMessageService getMessageService,
            GetAllMessagesService getAllMessagesService,
            UpdateMessageService updateMessageService,
            DeleteMessageService deleteMessageService
    ) {
        this.createMessageService = createMessageService;
        this.getMessageService = getMessageService;
        this.getAllMessagesService = getAllMessagesService;
        this.updateMessageService = updateMessageService;
        this.deleteMessageService = deleteMessageService;
    }

    //CREATE A MESSAGE
    @PostMapping("/message")
    public ResponseEntity<MessageDTO> createMessage(@RequestBody CreateMessageDTO createMessageDTO){
        return createMessageService.execute(createMessageDTO);
    }

    //READ ALL MESSAGES
    @GetMapping("/messages")
    public ResponseEntity<List<MessageDTO>> getAllMessages(){
        return getAllMessagesService.execute(null);
    }

    //READ A MESSAGE BY ID
    @GetMapping("/message/{messageID}")
    public ResponseEntity<MessageDTO> getMessage(@PathVariable Integer messageID){
        return getMessageService.execute(messageID);
    }

    //DELETE A MESSAGE
    @DeleteMapping("/message/{messageID}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Integer messageID){
        return deleteMessageService.execute(messageID);
    }

}
