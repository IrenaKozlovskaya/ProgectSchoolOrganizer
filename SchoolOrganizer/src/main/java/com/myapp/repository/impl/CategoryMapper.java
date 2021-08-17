package com.myapp.repository.impl;

import com.myapp.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class CategoryMapper implements RowMapper<Category> {

    private final ActivityTypeDaoImpl activityTypeDao;

    @Autowired
    public CategoryMapper(ActivityTypeDaoImpl activityTypeDao) {
        this.activityTypeDao = activityTypeDao;
    }


    @Override
    public Category mapRow(ResultSet resultSet, int i) throws SQLException {

        Category category = new Category();
        category.setId(resultSet.getLong("id"));
        category.setCategory(resultSet.getString("category"));
        category.setActivityTypes(activityTypeDao.getAllActivityTypesByCategory(resultSet.getString("category")));

        return category;
    }
}
