package com.a_chat.a_chat.comments.services;


import com.a_chat.a_chat.Query;
import com.a_chat.a_chat.comments.CommentRepository;
import com.a_chat.a_chat.comments.model.Comment;
import com.a_chat.a_chat.comments.model.CommentDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllCommentsService implements Query<Void, List<CommentDTO>> {
    private final CommentRepository commentRepository;

    public GetAllCommentsService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public ResponseEntity<List<CommentDTO>> execute(Void input) {
        List<Comment> comments = commentRepository.findAll();
        List<CommentDTO> commentDTOS = comments.stream().map(CommentDTO::new).toList();

        return ResponseEntity.status(HttpStatus.OK).body(commentDTOS);
    }
}
