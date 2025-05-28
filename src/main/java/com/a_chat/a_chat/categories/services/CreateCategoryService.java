package com.a_chat.a_chat.categories.services;

import com.a_chat.a_chat.Command;
import com.a_chat.a_chat.categories.CategoryRepository;
import com.a_chat.a_chat.categories.model.Category;
import com.a_chat.a_chat.categories.model.CategoryDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateCategoryService implements Command<Category, CategoryDTO> {
    private final CategoryRepository categoryRepository;

    public CreateCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ResponseEntity<CategoryDTO> execute(Category category) {
        Category savedCategory = categoryRepository.save(category);

        return ResponseEntity.status(HttpStatus.CREATED).body(new CategoryDTO(savedCategory));
    }
}

