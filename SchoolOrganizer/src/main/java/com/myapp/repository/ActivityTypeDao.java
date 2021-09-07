package com.myapp.repository;

import com.myapp.model.ActivityType;

import java.util.List;

public interface ActivityTypeDao {

    void createActivityType(ActivityType activityType);

    ActivityType getActivityTypeByID(long id);

    List<ActivityType> getAllActivityTypes();

    List<ActivityType> getAllActivityTypesByCategoryID(long id);

    void updateActivityType(ActivityType activityType);

    void deleteActivityType(long id);
}
