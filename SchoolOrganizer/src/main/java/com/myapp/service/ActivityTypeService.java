package com.myapp.service;

import com.myapp.model.ActivityType;

import java.util.List;

public interface ActivityTypeService {

    void createActivityType(ActivityType activityType);

    ActivityType getActivityType(String name);

    List<ActivityType> getAllActivityTypesByCategory(String category);

    List<ActivityType> getAllActivityTypes();

    void updateActivityType(ActivityType activityType);

    void deleteActivityType(long id);
}
