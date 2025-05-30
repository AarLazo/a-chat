package com.a_chat.a_chat.entities.comments;

import com.a_chat.a_chat.entities.comments.model.Comment;
import com.a_chat.a_chat.entities.posts.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findByPost(Post post);
}
