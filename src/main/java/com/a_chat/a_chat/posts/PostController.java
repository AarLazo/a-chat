package com.a_chat.a_chat.posts;

import com.a_chat.a_chat.posts.model.CreatePostDTO;
import com.a_chat.a_chat.posts.model.PostComments;
import com.a_chat.a_chat.posts.model.PostDTO;
import com.a_chat.a_chat.posts.model.UpdatePostCommand;
import com.a_chat.a_chat.posts.model.enums.PostState;
import com.a_chat.a_chat.posts.services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    private final CreatePostService createPostService;
    private final GetAllPostsService getAllPostsService;
    private final GetPostService getPostService;
    private final UpdatePostStateService updatePostStateService;
    private final DeletePostService deletePostService;

    private final LikePostService likePostService;
    private final DislikePostService dislikePostService;

    private final GetPostWithCommentsService getPostWithCommentsService;
    public PostController(
            CreatePostService createPostService,
            GetAllPostsService getAllPostsService,
            GetPostService getPostService,
            UpdatePostStateService updatePostStateService,
            DeletePostService deletePostService,
            LikePostService likePostService,
            DislikePostService dislikePostService,
            GetPostWithCommentsService getPostWithCommentsService

    ) {
        this.createPostService = createPostService;
        this.getAllPostsService = getAllPostsService;
        this.getPostService = getPostService;
        this.updatePostStateService = updatePostStateService;
        this.deletePostService = deletePostService;
        this.likePostService = likePostService;
        this.dislikePostService = dislikePostService;
        this.getPostWithCommentsService = getPostWithCommentsService;
    }

    //CREATE A POST
    @PostMapping("/post")
    public ResponseEntity<PostDTO> createPost(@RequestBody CreatePostDTO post){
        return createPostService.execute(post);
    }

    //READ ALL POSTS
    @GetMapping("/posts")
    public ResponseEntity<List<PostDTO>> getAllPosts(){
        return getAllPostsService.execute(null);
    }

    //READ A POST BY ID
    @GetMapping("/post/{postID}")
    public ResponseEntity<PostDTO> getPost(@PathVariable Integer postID){
        return getPostService.execute(postID);
    }

    //READ A POST WITH ITS COMMENTS
    @GetMapping("/postComments/{postID}")
    public ResponseEntity<PostComments> getPostWithComments(@PathVariable Integer postID){
        return getPostWithCommentsService.execute(postID);
    }

    //UPDATE A POST STATE
    @PutMapping("/postState/{postID}")
    public ResponseEntity<PostDTO> updatePostState(@PathVariable Integer postID, @RequestBody PostState state){
        return updatePostStateService.execute(new UpdatePostCommand(postID, state));
    }

    //ADD A LIKE TO A POST
    @PutMapping("/likePost/{postID}")
    public ResponseEntity<PostDTO> likePost(@PathVariable Integer postID){
        return likePostService.execute(postID);
    }

    //REMOVE A LIKE TO A POST
    @PutMapping("/dislikePost/{postID}")
    public ResponseEntity<PostDTO> dislikePost(@PathVariable Integer postID){
        return dislikePostService.execute(postID);
    }

    //DELETE A POST
    @DeleteMapping("/post/{postID}")
    public ResponseEntity<Void> deletePost(@PathVariable Integer postID){
        return deletePostService.execute(postID);
    }
}
