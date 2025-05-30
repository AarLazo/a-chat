package com.a_chat.a_chat.entities.comments.services;

import com.a_chat.a_chat.Command;
import com.a_chat.a_chat.entities.comments.CommentRepository;
import com.a_chat.a_chat.entities.comments.model.Comment;
import com.a_chat.a_chat.entities.comments.model.CommentDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OPLikeCommentService implements Command<Integer, CommentDTO> {
    private final CommentRepository commentRepository;

    public OPLikeCommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public ResponseEntity<CommentDTO> execute(Integer commentID) {
        Optional<Comment> optionalComment = commentRepository.findById(commentID);

        if (optionalComment.isPresent()){
            Comment comment = optionalComment.get();
            comment.setOpLiked(!comment.getOpLiked());
            commentRepository.save(comment);

            return ResponseEntity.status(HttpStatus.OK).body(new CommentDTO(comment));
        }
        return null;
    }
}
