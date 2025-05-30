package com.a_chat.a_chat.entities.messages.services;

import com.a_chat.a_chat.Command;
import com.a_chat.a_chat.entities.chats.ChatRepository;
import com.a_chat.a_chat.entities.chats.model.Chat;
import com.a_chat.a_chat.entities.messages.MessageRespository;
import com.a_chat.a_chat.entities.messages.model.CreateMessageDTO;
import com.a_chat.a_chat.entities.messages.model.Message;
import com.a_chat.a_chat.entities.messages.model.MessageDTO;
import com.a_chat.a_chat.entities.users.UserRepository;
import com.a_chat.a_chat.entities.users.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateMessageService implements Command<CreateMessageDTO, MessageDTO> {
    private final MessageRespository messageRespository;
    private final ChatRepository chatRepository;
    private final UserRepository userRepository;

    public CreateMessageService(MessageRespository messageRespository,
                                ChatRepository chatRepository,
                                UserRepository userRepository) {
        this.messageRespository = messageRespository;
        this.chatRepository = chatRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<MessageDTO> execute(CreateMessageDTO message) {
        Optional<Chat> optionalChat = chatRepository.findById(message.getChatID());
        Optional<User> optionalUser = userRepository.findById(message.getUserID());

        if (optionalChat.isPresent() && optionalUser.isPresent()){
            Chat chat = optionalChat.get();
            User user = optionalUser.get();
            Message savedMessage = new Message();
            savedMessage.setChat(chat);
            savedMessage.setUser(user);
            savedMessage.setMessageTxt(message.getMessageTxt());
            messageRespository.save(savedMessage);

            return ResponseEntity.status(HttpStatus.CREATED).body(new MessageDTO(savedMessage));
        }

        return null;
    }
}
