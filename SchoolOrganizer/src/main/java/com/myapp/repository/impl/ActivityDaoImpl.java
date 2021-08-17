package com.myapp.repository.impl;

import com.myapp.model.Activity;
import com.myapp.repository.ActivityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ActivityDaoImpl implements ActivityDao {

    private final String sqlCreateActivity = "INSERT INTO activity(name, date) values (?, ?)";
    private final String sqlGetAllActivities = "SELECT a.id, a.name, a.date, a_t.name FROM activity a LEFT JOIN activity_type a_t ON a.activity_type_id = a_t.id ";
    private final String sqlGetActivity = sqlGetAllActivities + " WHERE a.name = ?";
    private final String sqlGetActivitiesByActivityType = sqlGetAllActivities + " WHERE a_t.name = ?";
    private final String sqlGetActivitiesByUserID = sqlGetAllActivities + "INNER JOIN activity_users a_u ON a.id = a_u.activity_id INNER JOIN user u ON u.id=a_u.user_id WHERE u.id = ?";
    private final String sqlUpdateActivity = "UPDATE FROM activity (name, date) value(?,?) WHERE id = ? ";
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
    public List<Activity> getActivitiesByActivityType(String name) {
        return jdbcTemplate.query(sqlGetActivitiesByActivityType, new ActivityMapper(), name);
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
