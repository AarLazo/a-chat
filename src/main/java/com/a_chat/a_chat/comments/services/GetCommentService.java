package com.a_chat.a_chat.comments.services;


import com.a_chat.a_chat.Command;
import com.a_chat.a_chat.comments.CommentRepository;
import com.a_chat.a_chat.comments.model.Comment;
import com.a_chat.a_chat.comments.model.CommentDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetCommentService implements Command<Integer, CommentDTO> {
    private final CommentRepository commentRepository;

    public GetCommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }


    @Override
    public ResponseEntity<CommentDTO> execute(Integer commentID) {
        Optional<Comment> optionalComment = commentRepository.findById(commentID);
        if (optionalComment.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(new CommentDTO(optionalComment.get()));
        }
        return null;
    }
}
