package com.a_chat.a_chat.categories.model;

import lombok.Data;

@Data
public class CategoryDTO {
    private Integer categoryID;
    private String name;
    private Integer posts;

    public CategoryDTO(Category category) {
        this.categoryID = category.getCategoryID();
        this.name = category.getName();
        this.posts = category.getPosts();
    }
}
