package com.myapp.repository.impl;

import com.myapp.model.Activity;
import com.myapp.repository.ActivityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ActivityDaoImpl implements ActivityDao {

    private final String sqlCreateActivity = "INSERT INTO activity(name, date, activity_type_id) values (?,?,?)";
    private final String sqlGetAllActivities = "SELECT * FROM activity";
    private final String sqlGetActivity = sqlGetAllActivities + " WHERE name = ?";
    private final String sqlGetActivitiesByActivityType = sqlGetAllActivities + " WHERE activity_type_id = ?";
    private final String sqlGetActivitiesByUserID = sqlGetAllActivities + "INNER JOIN activity_users a_u ON a.id = a_u.activity_id INNER JOIN user u ON u.id=a_u.user_id WHERE u.id = ?";
    private final String sqlUpdateActivity = "UPDATE FROM activity (name, date, activity_type_id) value(?,?,?) WHERE id = ? ";
    private final String sqlDeleteActivity = "DELETE * FROM activity a WHERE a.id=?";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ActivityDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void createActivity(Activity activity) {
        jdbcTemplate.update(sqlCreateActivity, activity.getName(), activity.getDate());

    }

    @Override
    public Activity getActivityByName(String name) {
        return jdbcTemplate.query(sqlGetActivity, new ActivityMapper(), name)
                .stream().findAny().orElse(null);
    }

    @Override
    public List<Activity> getActivitiesByUserID(long id) {
        return jdbcTemplate.query(sqlGetActivitiesByUserID, new ActivityMapper(), id);

    }

    @Override
    public List<Activity> getActivitiesByActivityType(long id) {
        return jdbcTemplate.query(sqlGetActivitiesByActivityType, new ActivityMapper(), id);
    }

    @Override
    public List<Activity> getAllActivities() {
        return jdbcTemplate.query(sqlGetAllActivities, new ActivityMapper());

    }

    @Override
    public void updateActivity(Activity activity) {
        jdbcTemplate.update(sqlUpdateActivity, activity.getName(), activity.getDate(), activity.getId());

    }

    @Override
    public void deleteActivity(long id) {
        jdbcTemplate.update(sqlDeleteActivity, id);

    }
}
