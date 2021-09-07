package com.myapp.service.impl;

import com.myapp.model.Category;
import com.myapp.repository.CategoryDao;
import com.myapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryDao categoryDao;

    @Autowired
    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public void createCategory(Category category) {

        try {
            categoryDao.createCategory(category);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Category getCategory(long id) {
        try {
            return categoryDao.getCategoryByID(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Category> getAllActivityTypes() {
        try {
            return categoryDao.getAllCategories();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void updateCategory(Category category) {
        try {
            categoryDao.updateCategory(category);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void deleteCategory(long id) {

        try {
            categoryDao.deleteCategory(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
