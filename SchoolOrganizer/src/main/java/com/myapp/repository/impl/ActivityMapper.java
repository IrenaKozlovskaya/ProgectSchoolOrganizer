package com.myapp.repository.impl;

import com.myapp.model.Activity;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ActivityMapper implements RowMapper<Activity> {
    @Override
    public Activity mapRow(ResultSet resultSet, int i) throws SQLException {
        Activity activity = new Activity();
        activity.setId(resultSet.getLong("id"));
        activity.setName(resultSet.getString("name"));
        activity.setDate(resultSet.getString("date"));
        return activity;
    }
}
