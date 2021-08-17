package com.myapp.repository.impl;

import com.myapp.model.Category;
import com.myapp.repository.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDaoImpl implements CategoryDao {

    private final String sqlCreateCategory = "INSERT INTO category(category) value (?)";
    private final String sqlGetAllCategories = "SELECT * FROM category";
    private final String sqlGetCategory = sqlGetAllCategories + " WHERE category = ?";
    private final String sqlUpdateCategory = "UPDATE FROM category (category) value(?) WHERE id = ?";
    private final String sqlDeleteCategory = "DELETE * FROM category WHERE id = ?";

    private final JdbcTemplate jdbcTemplate;
    private final CategoryMapper categoryMapper;

    @Autowired
    public CategoryDaoImpl(JdbcTemplate jdbcTemplate, CategoryMapper categoryMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public void createCategory(Category category) {
        jdbcTemplate.update(sqlCreateCategory, category.getCategory());

    }

    @Override
    public Category getCategoryByName(String name) {
        return jdbcTemplate.query(sqlGetCategory, categoryMapper, name)
                .stream().findAny().orElse(null);
    }

    @Override
    public List<Category> getAllCategories() {
        return jdbcTemplate.query(sqlGetAllCategories, categoryMapper);

    }

    @Override
    public void updateCategory(Category category) {
        jdbcTemplate.update(sqlUpdateCategory, category.getCategory(), category.getId());

    }

    @Override
    public void deleteCategory(long id) {
        jdbcTemplate.update(sqlDeleteCategory, id);

    }


}
