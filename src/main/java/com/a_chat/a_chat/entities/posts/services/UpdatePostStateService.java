package com.a_chat.a_chat.entities.posts.services;

import com.a_chat.a_chat.Command;
import com.a_chat.a_chat.entities.posts.model.Post;
import com.a_chat.a_chat.entities.posts.model.UpdatePostCommand;
import com.a_chat.a_chat.entities.posts.PostRepository;
import com.a_chat.a_chat.entities.posts.model.PostDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdatePostStateService implements Command<UpdatePostCommand, PostDTO> {

    private final PostRepository postRepository;

    public UpdatePostStateService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    @Override
    public ResponseEntity<PostDTO> execute(UpdatePostCommand updatePostCommand) {
        Optional<Post> optionalPost = postRepository.findById(updatePostCommand.getPostID());
        if (optionalPost.isPresent()){
            Post post = optionalPost.get();
            post.setState(updatePostCommand.getState());
            postRepository.save(post);

            return ResponseEntity.status(HttpStatus.OK).body(new PostDTO(post));
        }
        return null;
    }
}
