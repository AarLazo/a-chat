package com.a_chat.a_chat.categories;

import com.a_chat.a_chat.categories.model.Category;
import com.a_chat.a_chat.categories.model.CategoryDTO;
import com.a_chat.a_chat.categories.model.UpdateCategoryCommand;
import com.a_chat.a_chat.categories.services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    private final CreateCategoryService createCategoryService;
    private final GetAllCategoriesService getAllCategoriesService;
    private final GetCategoryService getCategoryService;
    private final UpdateCategoryService updateCategoryService;
    private final DeleteCategoryService deleteCategoryService;

    public CategoryController(
            CreateCategoryService createCategoryService,
            GetAllCategoriesService getAllCategoriesService,
            GetCategoryService getCategoryService,
            UpdateCategoryService updateCategoryService,
            DeleteCategoryService deleteCategoryService
    ) {
        this.createCategoryService = createCategoryService;
        this.getAllCategoriesService = getAllCategoriesService;
        this.getCategoryService = getCategoryService;
        this.updateCategoryService = updateCategoryService;
        this.deleteCategoryService = deleteCategoryService;
    }

    //CREATE A CATEGORY
    @PostMapping("/category")
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody Category category){
        return createCategoryService.execute(category);
    }

    //READ ALL CATEGORIES
    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDTO>> getAllCategories(){
        return getAllCategoriesService.execute(null);
    }

    //READ A CATEGORY BY ID
    @GetMapping("/category/{categoryID}")
    public ResponseEntity<CategoryDTO> getCategory(@PathVariable Integer categoryID){
        return getCategoryService.execute(categoryID);
    }


    //UPDATE A CATEGORY
    @PutMapping("/category/{categoryID}")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable Integer categoryID, @RequestBody Category category){
        return updateCategoryService.execute(new UpdateCategoryCommand(categoryID, category.getName()));
    }

    //DELETE A CATEGORY
    @DeleteMapping("/category/{categoryID}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Integer categoryID){
        return deleteCategoryService.execute(categoryID);
    }


}
