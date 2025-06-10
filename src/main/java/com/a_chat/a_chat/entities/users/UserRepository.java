package com.a_chat.a_chat.entities.users;

import com.a_chat.a_chat.entities.users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

    //creation
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

    //update
    boolean existsByUsernameAndUserIDNot(String username, Integer userID);
    boolean existsByEmailAndUserIDNot(String email, Integer userID);


    //search
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);


}