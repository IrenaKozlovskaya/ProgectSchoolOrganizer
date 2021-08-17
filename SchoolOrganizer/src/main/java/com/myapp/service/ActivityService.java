package com.myapp.service;

import com.myapp.model.Activity;

import java.util.List;

public interface ActivityService {

    void createActivity(Activity activity);

    Activity getActivity(String name);

    List<Activity> getActivitiesByUser(long id);

    List<Activity> getActivitiesByActivityType(String name);

    List<Activity> getAllActivities();

    void updateActivity(Activity activity);

    void deleteActivity(long id);
}
