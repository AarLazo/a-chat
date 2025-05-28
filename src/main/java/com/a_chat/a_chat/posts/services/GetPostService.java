package com.a_chat.a_chat.posts.services;

import com.a_chat.a_chat.Query;
import com.a_chat.a_chat.posts.PostRepository;
import com.a_chat.a_chat.posts.model.Post;
import com.a_chat.a_chat.posts.model.PostDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetPostService implements Query<Integer, PostDTO> {
    private final PostRepository postRepository;

    public GetPostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    @Override
    public ResponseEntity<PostDTO> execute(Integer postID) {
        Optional<Post> optionalPost = postRepository.findById(postID);
        if (optionalPost.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(new PostDTO(optionalPost.get()));
        }
        return null;
    }
}
