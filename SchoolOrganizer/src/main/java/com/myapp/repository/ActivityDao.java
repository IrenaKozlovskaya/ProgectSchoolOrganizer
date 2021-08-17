package com.myapp.repository;

import com.myapp.model.Activity;

import java.util.List;

public interface ActivityDao {

    void createActivity(Activity activity);

    Activity getActivityByName(String name);

    List<Activity> getAllActivities();

    List<Activity> getActivitiesByUserID(long id);

    List<Activity> getActivitiesByActivityType(String name);

    void updateActivity(Activity activity);

    void deleteActivity(long id);
}
