package com.myapp.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


// футбол, похд в кино и др. типы мероприятий
@Getter
@Setter
@ToString
public class ActivityType {

    private long id;
    private String name;
    private long category_id;
    private List<Activity> activities;


}
