package com.myapp.repository.impl;


import com.myapp.model.ActivityType;
import com.myapp.repository.ActivityTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class ActivityTypeDaoImpl implements ActivityTypeDao {

    private final String sqlCreateActivityType = "INSERT INTO activity_type(name, category_id) values (?, ?)";
    private final String sqlGetAllActivityTypes = "SELECT * FROM activity_type";
    private final String sqlGetAllActivityTypesByCategory = sqlGetAllActivityTypes + "WHERE category_id = ?";
    private final String sqlGetActivityType = sqlGetAllActivityTypes + " WHERE id = ?";
    private final String sqlUpdateActivityType = "UPDATE FROM activity_type (name, category_id) value(?,?) WHERE id = ? ";
    private final String sqlDeleteActivityType = "DELETE * FROM activity_type WHERE id=?";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ActivityTypeDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public ActivityType mapRow(ResultSet resultSet) throws SQLException {

        ActivityType activityType = new ActivityType();
        activityType.setId(resultSet.getLong("id"));
        activityType.setName(resultSet.getString("name"));
        activityType.setCategoryId(resultSet.getLong("category_id"));
        return activityType;
    }

    @Override
    public void createActivityType(ActivityType activityType) {
        jdbcTemplate.update(sqlCreateActivityType, activityType.getName(), activityType.getCategoryId());

    }


    @Override
    public ActivityType getActivityTypeByID(long id) {
        return jdbcTemplate.query(sqlGetActivityType, (rs, rowNum) ->
                mapRow(rs), id)
                .stream().findAny().orElse(null);
    }


    @Override
    public List<ActivityType> getAllActivityTypes() {
        return jdbcTemplate.query(sqlGetAllActivityTypes, (rs, rowNum) ->
                mapRow(rs));

    }

    @Override
    public List<ActivityType> getAllActivityTypesByCategoryID(long id) {
        return jdbcTemplate.query(sqlGetAllActivityTypesByCategory, (rs, rowNum) ->
                mapRow(rs), id);

    }

    @Override
    public void updateActivityType(ActivityType activityType) {
        jdbcTemplate.update(sqlUpdateActivityType, activityType.getName(), activityType.getCategoryId(), activityType.getId());

    }

    @Override
    public void deleteActivityType(long id) {
        jdbcTemplate.update(sqlDeleteActivityType, id);

    }

}
