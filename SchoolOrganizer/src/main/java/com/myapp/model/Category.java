package com.myapp.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

 // спортивные, образовательные,торжественные, выезные и др. категории типов мероприятий
@Getter
@Setter
@ToString
public class Category {

    private long id;
    private String category;
    private List<ActivityType> activityTypes;

}
