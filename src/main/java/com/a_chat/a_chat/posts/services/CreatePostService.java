package com.a_chat.a_chat.posts.services;

import com.a_chat.a_chat.Command;
import com.a_chat.a_chat.categories.CategoryRepository;
import com.a_chat.a_chat.categories.model.Category;
import com.a_chat.a_chat.posts.PostRepository;
import com.a_chat.a_chat.posts.model.CreatePostDTO;
import com.a_chat.a_chat.posts.model.Post;
import com.a_chat.a_chat.posts.model.PostDTO;
import com.a_chat.a_chat.users.UserRepository;
import com.a_chat.a_chat.users.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreatePostService implements Command<CreatePostDTO, PostDTO> {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    public CreatePostService(
            PostRepository postRepository,
            UserRepository userRepository,
            CategoryRepository categoryRepository
    ) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ResponseEntity<PostDTO> execute(CreatePostDTO post) {
        Optional<User> optionalUser = userRepository.findById(post.getUserID());
        Optional<Category> optionalCategory = categoryRepository.findById(post.getCategoryID());

        if (optionalCategory.isPresent()&&optionalUser.isPresent()){
            Post savedPost = new Post();
            savedPost.setUser(optionalUser.get());
            savedPost.setCategory(optionalCategory.get());
            savedPost.setTitle(post.getTitle());
            savedPost.setDescription(post.getDescription());
            postRepository.save(savedPost);

            return ResponseEntity.status(HttpStatus.CREATED).body(new PostDTO(savedPost));
        }

        return null;
    }
}
