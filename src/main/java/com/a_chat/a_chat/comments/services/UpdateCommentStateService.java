package com.a_chat.a_chat.comments.services;


import com.a_chat.a_chat.Command;
import com.a_chat.a_chat.comments.CommentRepository;
import com.a_chat.a_chat.comments.model.Comment;
import com.a_chat.a_chat.comments.model.CommentDTO;
import com.a_chat.a_chat.comments.model.UpdateCommentCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateCommentStateService implements Command<UpdateCommentCommand, CommentDTO> {
    private final CommentRepository commentRepository;

    public UpdateCommentStateService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }


    @Override
    public ResponseEntity<CommentDTO> execute(UpdateCommentCommand updateCommentCommand) {
        Optional<Comment> optionalComment = commentRepository.findById(updateCommentCommand.getCommentID());
        if (optionalComment.isPresent()) {
            Comment comment = optionalComment.get();
            comment.setState(updateCommentCommand.getState());
            commentRepository.save(comment);

            return ResponseEntity.ok(new CommentDTO(comment));
        }
        return null;
    }
}
