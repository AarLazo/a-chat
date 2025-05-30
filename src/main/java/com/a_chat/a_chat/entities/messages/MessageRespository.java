package com.a_chat.a_chat.entities.messages;

import com.a_chat.a_chat.entities.chats.model.Chat;
import com.a_chat.a_chat.entities.messages.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRespository extends JpaRepository<Message,Integer>{
    List<Message> findByChat(Chat chat);
}
