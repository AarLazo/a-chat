package com.a_chat.a_chat.categories.model;

import lombok.Getter;

@Getter
public class UpdateCategoryCommand {
    private Integer categoryID;
    private String name;

    public UpdateCategoryCommand(Integer categoryID, String name) {
        this.categoryID = categoryID;
        this.name = name;
    }
}
