package com.myapp.service;

import com.myapp.model.Category;

import java.util.List;

public interface CategoryService {

    void createCategory(Category category);

    Category getCategory(long id);

    List<Category> getAllActivityTypes();

    void updateCategory(Category category);

    void deleteCategory(long id);
}
