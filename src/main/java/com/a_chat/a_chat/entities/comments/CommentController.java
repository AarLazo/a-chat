package com.a_chat.a_chat.entities.comments;

import com.a_chat.a_chat.entities.comments.model.CommentDTO;
import com.a_chat.a_chat.entities.comments.model.CreateCommentDTO;
import com.a_chat.a_chat.entities.comments.model.UpdateCommentCommand;
import com.a_chat.a_chat.entities.comments.model.enums.CommentState;
import com.a_chat.a_chat.entities.comments.services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    private final CreateCommentService createCommentService;
    private final GetAllCommentsService getAllCommentsService;
    private final GetCommentService getCommentService;
    private final UpdateCommentStateService updateCommentStateService;
    private final PinnedCommentService pinnedCommentService;
    private final DeleteCommentService deleteCommentService;
    private final OPLikeCommentService opLikeCommentService;


    public CommentController(
            CreateCommentService createCommentService,
            GetAllCommentsService getAllCommentsService,
            GetCommentService getCommentService,
            UpdateCommentStateService updateCommentStateService,
            DeleteCommentService deleteCommentService,
            PinnedCommentService pinnedCommentService,
            OPLikeCommentService opLikeCommentService
    ) {
        this.createCommentService = createCommentService;
        this.getAllCommentsService = getAllCommentsService;
        this.getCommentService = getCommentService;
        this.updateCommentStateService = updateCommentStateService;
        this.deleteCommentService = deleteCommentService;
        this.pinnedCommentService = pinnedCommentService;
        this.opLikeCommentService = opLikeCommentService;
    }

    //CREATE A COMMENT
    @PostMapping("/comment")
    private ResponseEntity<CommentDTO> createComment(@RequestBody CreateCommentDTO comment){
        return createCommentService.execute(comment);
    }

    //READ ALL COMMENTS
    @GetMapping("/comments")
    public ResponseEntity<List<CommentDTO>> getAllComments(){
        return getAllCommentsService.execute(null);
    }

    //READ A COMMENT BY ID
    @GetMapping("/comment/{commentID}")
    public ResponseEntity<CommentDTO> getComment(@PathVariable Integer commentID){
        return getCommentService.execute(commentID);
    }

    //UPDATE A COMMENT STATE
        @PutMapping("/commentState/{commentID}")
    public ResponseEntity<CommentDTO> updateCommentState(@PathVariable Integer commentID, @RequestBody CommentState state){
        return updateCommentStateService.execute(new UpdateCommentCommand(commentID, state));
    }

    //PIN or UNPIN A COMMENT
    @PutMapping("/pinComment/{commentID}")
    public ResponseEntity<CommentDTO> pinComment(@PathVariable Integer commentID){
        return pinnedCommentService.execute(commentID);
    }
    //LIKE or UNLIKE A COMMENT BY OP
    @PutMapping("/OPLikeComment/{commentID}")
    public ResponseEntity<CommentDTO> likeCommentByOP(@PathVariable Integer commentID){
        return opLikeCommentService.execute(commentID);
    }

    //DELETE A COMMENT
    @DeleteMapping("/comment/{commentID}")
    public ResponseEntity<Void> deleteComment(@PathVariable Integer commentID){
        return deleteCommentService.execute(commentID);
    }

}
