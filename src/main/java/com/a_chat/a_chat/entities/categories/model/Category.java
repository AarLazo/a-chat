package com.a_chat.a_chat.entities.categories.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoryID")
    private Integer categoryID;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "posts")
    private Integer posts;

    @PrePersist
    protected void onCreate() {
        this.posts = 0;
    }

}
