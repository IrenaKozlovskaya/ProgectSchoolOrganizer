package com.myapp.repository.impl;


import com.myapp.model.ActivityType;
import com.myapp.repository.ActivityTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ActivityTypeDaoImpl implements ActivityTypeDao {

    private final String sqlCreateActivityType = "INSERT INTO activity_type(name, category_id) values (?, ?)";
    private final String sqlGetAllActivityTypes = "SELECT a_t.id, a_t.name, c.category FROM activity_type a_t LEFT JOIN category c ON a_t.category_id = c.id";
    private final String sqlGetAllActivityTypesByCategory = sqlGetAllActivityTypes + "WHERE c.category = ?";
    private final String sqlGetActivityType = sqlGetAllActivityTypes + " WHERE a_t.name = ?";
    private final String sqlUpdateActivityType = "UPDATE FROM activity_type (name) value(?) WHERE id = ? ";
    private final String sqlDeleteActivityType = "DELETE * FROM activity_type a_t WHERE a_t.id=?";

    private final JdbcTemplate jdbcTemplate;
    private final ActivityTypeMapper activityTypeMapper;

    @Autowired
    public ActivityTypeDaoImpl(JdbcTemplate jdbcTemplate, ActivityTypeMapper activityTypeMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.activityTypeMapper = activityTypeMapper;
    }


    @Override
    public void createActivityType(ActivityType activityType) {
        jdbcTemplate.update(sqlCreateActivityType, activityType.getName(), activityType.getCategory_id());

    }


    @Override
    public ActivityType getActivityTypeByName(String name) {
        return jdbcTemplate.query(sqlGetActivityType, activityTypeMapper, name)
                .stream().findAny().orElse(null);
    }


    @Override
    public List<ActivityType> getAllActivityTypes() {
        return jdbcTemplate.query(sqlGetAllActivityTypes, activityTypeMapper);

    }

    @Override
    public List<ActivityType> getAllActivityTypesByCategory(String category) {
        return jdbcTemplate.query(sqlGetAllActivityTypesByCategory, activityTypeMapper, category);

    }

    @Override
    public void updateActivityType(ActivityType activityType) {
        jdbcTemplate.update(sqlUpdateActivityType, activityType.getName(), activityType.getId());

    }

    @Override
    public void deleteActivityType(long id) {
        jdbcTemplate.update(sqlDeleteActivityType, id);

    }

}
