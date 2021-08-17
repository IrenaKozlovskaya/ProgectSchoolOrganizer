package com.myapp.service.impl;

import com.myapp.model.ActivityType;
import com.myapp.repository.ActivityTypeDao;
import com.myapp.service.ActivityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityTypeServiceImpl implements ActivityTypeService {

    private final ActivityTypeDao activityTypeDao;

    @Autowired
    public ActivityTypeServiceImpl(ActivityTypeDao activityTypeDao) {
        this.activityTypeDao = activityTypeDao;
    }

    @Override
    public void createActivityType(ActivityType activityType) {

        try {
            activityTypeDao.createActivityType(activityType);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public ActivityType getActivityType(String name) {
        try {
            return activityTypeDao.getActivityTypeByName(name);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<ActivityType> getAllActivityTypesByCategory(String category) {
        try {
            return activityTypeDao.getAllActivityTypesByCategory(category);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<ActivityType> getAllActivityTypes() {
        try {
            return activityTypeDao.getAllActivityTypes();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void updateActivityType(ActivityType activityType) {
        try {
            activityTypeDao.updateActivityType(activityType);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void deleteActivityType(long id) {

        try {
            activityTypeDao.deleteActivityType(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
