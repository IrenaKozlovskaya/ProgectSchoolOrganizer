package com.myapp.service;

import com.myapp.model.ActivityType;

import java.util.List;

public interface ActivityTypeService {

    void createActivityType(ActivityType activityType);

    ActivityType getActivityType(long id);

    List<ActivityType> getAllActivityTypesByCategory(long id);

    List<ActivityType> getAllActivityTypes();

    void updateActivityType(ActivityType activityType);

    void deleteActivityType(long id);
}
