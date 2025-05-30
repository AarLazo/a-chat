package com.a_chat.a_chat.entities.categories.services;

import com.a_chat.a_chat.Command;
import com.a_chat.a_chat.entities.categories.CategoryRepository;
import com.a_chat.a_chat.entities.categories.model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteCategoryService implements Command<Integer, Void> {
    private final CategoryRepository categoryRepository;

    public DeleteCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public ResponseEntity<Void> execute(Integer categoryID) {
        Optional<Category> optionalCategory = categoryRepository.findById(categoryID);
        if (optionalCategory.isPresent()){
            categoryRepository.deleteById(categoryID);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return null;
    }
}
