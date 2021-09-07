package com.myapp.service.impl;

import com.myapp.model.Activity;
import com.myapp.repository.ActivityDao;
import com.myapp.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {

    private final ActivityDao activityDao;

    @Autowired
    public ActivityServiceImpl(ActivityDao activityDao) {
        this.activityDao = activityDao;
    }

    @Override
    public void createActivity(Activity activity) {

        try {
            activityDao.createActivity(activity);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Activity getActivity(String name) {
        try {
            return activityDao.getActivityByName(name);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Activity> getActivitiesByUser(long id) {
        try {
            return activityDao.getActivitiesByUserID(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Activity> getActivitiesByActivityType(long id) {
        try {
            return activityDao.getActivitiesByActivityType(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Activity> getAllActivities() {
        try {
            return activityDao.getAllActivities();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void updateActivity(Activity activity) {
        try {
            activityDao.updateActivity(activity);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void deleteActivity(long id) {

        try {
            activityDao.deleteActivity(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

