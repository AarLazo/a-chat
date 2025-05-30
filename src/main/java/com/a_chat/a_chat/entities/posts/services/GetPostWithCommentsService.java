package com.a_chat.a_chat.entities.posts.services;

import com.a_chat.a_chat.Query;
import com.a_chat.a_chat.entities.comments.CommentRepository;
import com.a_chat.a_chat.entities.comments.model.Comment;
import com.a_chat.a_chat.entities.comments.model.CommentDTO;
import com.a_chat.a_chat.entities.posts.PostRepository;
import com.a_chat.a_chat.entities.posts.model.Post;
import com.a_chat.a_chat.entities.posts.model.PostComments;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetPostWithCommentsService implements Query<Integer, PostComments> {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public GetPostWithCommentsService(
            PostRepository postRepository,
            CommentRepository commentRepository
    ) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }


    @Override
    public ResponseEntity<PostComments> execute(Integer postID) {
        Optional<Post> optionalPost = postRepository.findById(postID);
        if (optionalPost.isPresent()){
            List<Comment> comments = commentRepository.findByPost(optionalPost.get());
            List<CommentDTO> commentDTOS = comments.stream().map(CommentDTO::new).toList();
            PostComments postComments = new PostComments();
            postComments.setPostID(postID);
            postComments.setComments(commentDTOS);

            return ResponseEntity.status(HttpStatus.OK).body(postComments);
        }
        return null;
    }
}
