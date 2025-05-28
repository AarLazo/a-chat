package com.a_chat.a_chat.posts.services;

import com.a_chat.a_chat.Command;
import com.a_chat.a_chat.posts.PostRepository;
import com.a_chat.a_chat.posts.model.Post;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeletePostService implements Command<Integer, Void> {
    private final PostRepository postRepository;

    public DeletePostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public ResponseEntity<Void> execute(Integer postID) {
        Optional<Post> optionalPost = postRepository.findById(postID);

        if (optionalPost.isPresent()){
            postRepository.deleteById(postID);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return null;
    }
}
