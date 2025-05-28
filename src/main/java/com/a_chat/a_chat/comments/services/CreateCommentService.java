package com.a_chat.a_chat.comments.services;

import com.a_chat.a_chat.Command;
import com.a_chat.a_chat.comments.CommentRepository;
import com.a_chat.a_chat.comments.model.Comment;
import com.a_chat.a_chat.comments.model.CommentDTO;
import com.a_chat.a_chat.comments.model.CreateCommentDTO;
import com.a_chat.a_chat.posts.PostRepository;
import com.a_chat.a_chat.posts.model.Post;
import com.a_chat.a_chat.users.UserRepository;
import com.a_chat.a_chat.users.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateCommentService implements Command<CreateCommentDTO, CommentDTO> {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public CreateCommentService(
            CommentRepository commentRepository,
            UserRepository userRepository,
            PostRepository postRepository
    ) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @Override
    public ResponseEntity<CommentDTO> execute(CreateCommentDTO createCommentDTO) {

        Optional<User> optionalUser = userRepository.findById(createCommentDTO.getUserID());
        Optional<Post> optionalPost = postRepository.findById(createCommentDTO.getPostID());

        Integer respComment = createCommentDTO.getRespCommentID();

        if (optionalUser.isPresent() && optionalPost.isPresent()){
            Comment savedComment = new Comment();
            savedComment.setUser(optionalUser.get());
            savedComment.setPost(optionalPost.get());
            if (respComment != null){
                Optional<Comment> optionalComment = commentRepository.findById(respComment);
                if (optionalComment.isPresent()){
                    savedComment.setRespCommentID(createCommentDTO.getRespCommentID());
                }
            }else{
                savedComment.setRespCommentID(null);
            }
            savedComment.setDescription(createCommentDTO.getDescription());
            commentRepository.save(savedComment);

            return ResponseEntity.status(HttpStatus.CREATED).body(new CommentDTO(savedComment));

        }

        return null;
    }
}
