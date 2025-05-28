package com.a_chat.a_chat.categories.services;
import com.a_chat.a_chat.Command;
import com.a_chat.a_chat.categories.CategoryRepository;
import com.a_chat.a_chat.categories.model.Category;
import com.a_chat.a_chat.categories.model.CategoryDTO;
import com.a_chat.a_chat.categories.model.UpdateCategoryCommand;
import com.a_chat.a_chat.chats.model.UpdateChatCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateCategoryService implements Command<UpdateCategoryCommand, CategoryDTO> {

    private final CategoryRepository categoryRepository;

    public UpdateCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ResponseEntity<CategoryDTO> execute(UpdateCategoryCommand updateCategoryCommand) {
        Optional<Category> optionalCategory = categoryRepository.findById(updateCategoryCommand.getCategoryID());
        if (optionalCategory.isPresent()){
            Category category = optionalCategory.get();
            category.setName(updateCategoryCommand.getName());
            categoryRepository.save(category);

            return ResponseEntity.ok(new CategoryDTO(category));
        }

        return null;
    }
}
