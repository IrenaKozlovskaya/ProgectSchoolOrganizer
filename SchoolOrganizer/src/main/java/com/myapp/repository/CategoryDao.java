package com.myapp.repository;

import com.myapp.model.Category;

import java.util.List;

public interface CategoryDao {

    void createCategory(Category category);

    Category getCategoryByName(String name);

    List<Category> getAllCategories();

    void updateCategory(Category category);

    void deleteCategory(long id);
}
