package com.example.deparments.services;

import com.example.deparments.entities.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {

    List<Category> getCategories();
    Optional<Category> getCategoryById(Long id);
    List<Category> getCategoriesByTitle(String title);
    Category saveCategory(Category category);
    Category updateCategory(Category category);
    void deleteCategory(Long id);

}
