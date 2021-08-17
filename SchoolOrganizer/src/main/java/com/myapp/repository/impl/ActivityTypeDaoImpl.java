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

    @Autowired
    public ActivityTypeDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void createActivityType(ActivityType activityType) {
        jdbcTemplate.update(sqlCreateActivityType, activityType.getName(), activityType.getCategory_id());

    }


    @Override
    public ActivityType getActivityTypeByName(String name) {
        ActivityType activityType = jdbcTemplate.query(sqlGetActivityType, new ActivityTypeMapper(), name)
                .stream().findAny().orElse(null);
        return activityType;
    }


    @Override
    public List<ActivityType> getAllActivityTypes() {
        List<ActivityType> activityTypes = jdbcTemplate.query(sqlGetAllActivityTypes, new ActivityTypeMapper());
        return activityTypes;

    }

    @Override
    public List<ActivityType> getAllActivityTypesByCategory(String category) {
        List<ActivityType> activityTypes = jdbcTemplate.query(sqlGetAllActivityTypesByCategory, new ActivityTypeMapper(), category);
        return activityTypes;

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
