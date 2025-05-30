package com.a_chat.a_chat.entities.users;

import com.a_chat.a_chat.entities.users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
}