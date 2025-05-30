package com.a_chat.a_chat.entities.friends;

import com.a_chat.a_chat.entities.friends.model.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendRepository extends JpaRepository<Friend, Integer>{
    @Query("SELECT f FROM Friend f WHERE f.user1.userID = :userId OR f.user2.userID = :userId")
    List<Friend> getFriendsByUser(@Param("userId") Integer userId);


}