package com.a_chat.a_chat.entities.posts.services;

import com.a_chat.a_chat.Command;
import com.a_chat.a_chat.entities.posts.PostRepository;
import com.a_chat.a_chat.entities.posts.model.Post;
import com.a_chat.a_chat.entities.posts.model.PostDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LikePostService  implements Command<Integer, PostDTO> {
    private final PostRepository postRepository;

    public LikePostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public ResponseEntity<PostDTO> execute(Integer postID) {
        Optional<Post> optionalPost = postRepository.findById(postID);
        if (optionalPost.isPresent()){
            Post post = optionalPost.get();
            post.setLikes(post.getLikes()+1);
            postRepository.save(post);

            return ResponseEntity.status(HttpStatus.OK).body(new PostDTO(post));
        }
        return null;
    }
}
