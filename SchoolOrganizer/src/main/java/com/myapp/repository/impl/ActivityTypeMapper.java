package com.myapp.repository.impl;

import com.myapp.model.ActivityType;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ActivityTypeMapper implements RowMapper<ActivityType> {


    @Override
    public ActivityType mapRow(ResultSet resultSet, int i) throws SQLException {

        ActivityType activityType = new ActivityType();
        activityType.setId(resultSet.getLong("id"));
        activityType.setName(resultSet.getString("name"));
        activityType.setCategory_id(resultSet.getLong("category_id"));
        return activityType;
    }
}
