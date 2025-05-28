package com.a_chat.a_chat.posts.services;

import com.a_chat.a_chat.Query;
import com.a_chat.a_chat.posts.PostRepository;
import com.a_chat.a_chat.posts.model.Post;
import com.a_chat.a_chat.posts.model.PostDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllPostsService implements Query<Void, List<PostDTO>> {

    private final PostRepository postRepository;

    public GetAllPostsService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public ResponseEntity<List<PostDTO>> execute(Void input) {
        List<Post> posts = postRepository.findAll();
        List<PostDTO> postDTOS = posts.stream().map(PostDTO::new).toList();

        return ResponseEntity.status(HttpStatus.OK).body(postDTOS);
    }


}
