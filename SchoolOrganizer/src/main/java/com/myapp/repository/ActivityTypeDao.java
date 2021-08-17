package com.myapp.repository;

import com.myapp.model.ActivityType;

import java.util.List;

public interface ActivityTypeDao {

    void createActivityType(ActivityType activityType);

    ActivityType getActivityTypeByName(String name);

    List<ActivityType> getAllActivityTypes();

    List<ActivityType> getAllActivityTypesByCategory(String category);

    void updateActivityType(ActivityType activityType);

    void deleteActivityType(long id);
}
