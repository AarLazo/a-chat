package com.a_chat.a_chat.entities.posts;

import com.a_chat.a_chat.entities.posts.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
}
