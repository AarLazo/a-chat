package com.a_chat.a_chat.entities.categories.services;

import com.a_chat.a_chat.Query;
import com.a_chat.a_chat.entities.categories.CategoryRepository;
import com.a_chat.a_chat.entities.categories.model.Category;
import com.a_chat.a_chat.entities.categories.model.CategoryDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetCategoryService implements Query<Integer, CategoryDTO> {
    private final CategoryRepository categoryRepository;

    public GetCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ResponseEntity<CategoryDTO> execute(Integer categoryID) {
        Optional<Category> optionalCategory = categoryRepository.findById(categoryID);
        if (optionalCategory.isPresent()){
            return ResponseEntity.ok(new CategoryDTO(optionalCategory.get()));
        }
        return null;
    }
}
