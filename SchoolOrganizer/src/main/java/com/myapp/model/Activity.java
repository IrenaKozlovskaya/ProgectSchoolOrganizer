package com.myapp.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Activity {

    private long id;
    private String name;
    private String date;
    private long activityTypeId;
    private List<User> managers = new ArrayList<>();
    private List<User> participants = new ArrayList<>();



}
