package com.a_chat.a_chat.entities.chats;

import com.a_chat.a_chat.entities.chats.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Integer> {
}
