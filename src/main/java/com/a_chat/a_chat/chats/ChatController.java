package com.a_chat.a_chat.chats;

import com.a_chat.a_chat.chats.model.*;
import com.a_chat.a_chat.chats.model.enums.ChatState;
import com.a_chat.a_chat.chats.services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChatController {

    private final CreateChatService createChatService;
    private final GetAllChatsService getAllChatsService;
    private final GetChatService getChatService;
    private final UpdateChatStateService updateChatStateService;
    private final DeleteChatService deleteChatService;

    private final GetChatWithMessagesService getChatWithMessagesService;

    public ChatController(
            CreateChatService createChatService,
            GetAllChatsService getAllChatsService,
            GetChatService getChatService,
            UpdateChatStateService updateChatStateService,
            DeleteChatService deleteChatService,

            GetChatWithMessagesService getChatWithMessagesService
    ) {
        this.createChatService = createChatService;
        this.getAllChatsService = getAllChatsService;
        this.getChatService = getChatService;
        this.updateChatStateService = updateChatStateService;
        this.deleteChatService = deleteChatService;

        this.getChatWithMessagesService = getChatWithMessagesService;
    }

    //CREATE A CHAT
    @PostMapping("/chat")
    public ResponseEntity<ChatDTO> createChat(@RequestBody CreateChatDTO chat){
        return createChatService.execute(chat);
    }

    //READ ALL CHATS
    @GetMapping("/chats")
    public ResponseEntity<List<ChatDTO>> getAllChats(){
        return getAllChatsService.execute(null);
    }

    //READ A CHAT BY ID
    @GetMapping("/chat/{chatID}")
    public ResponseEntity<ChatDTO> getChat(@PathVariable Integer chatID){
        return getChatService.execute(chatID);
    }

    //READ A CHAT WITH ITS MESSAGES
    @GetMapping("/chats/{chatID}")
    public ResponseEntity<ChatMessages> getChatMessages(@PathVariable Integer chatID){
        return getChatWithMessagesService.execute(chatID);
    }

    //UPDATE A CHAT STATE
    @PutMapping("/chat/{chatID}")
    public ResponseEntity<ChatDTO> updateChat(@PathVariable Integer chatID, @RequestBody ChatState state){
        return updateChatStateService.execute(new UpdateChatCommand(chatID, state));
    }

    //DELETE A CHAT
    @DeleteMapping("/chat/{chatID}")
    public ResponseEntity<Void> deleteChat(@PathVariable Integer chatID){
        return deleteChatService.execute(chatID);
    }
}
