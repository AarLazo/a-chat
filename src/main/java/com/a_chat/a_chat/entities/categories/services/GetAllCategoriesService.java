package com.a_chat.a_chat.entities.categories.services;

import com.a_chat.a_chat.Query;
import com.a_chat.a_chat.entities.categories.CategoryRepository;
import com.a_chat.a_chat.entities.categories.model.Category;
import com.a_chat.a_chat.entities.categories.model.CategoryDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllCategoriesService implements Query<Void, List<CategoryDTO>> {
    private final CategoryRepository categoryRepository;

    public GetAllCategoriesService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ResponseEntity<List<CategoryDTO>> execute(Void input) {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDTO> categoryDTOS = categories.stream().map(CategoryDTO::new).toList();
        return ResponseEntity.status(HttpStatus.OK).body(categoryDTOS);
    }
}
