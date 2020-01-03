package com.springboot.bean;

import java.util.Date;

public class Activity {

    private Integer id;
    private String activityName;
    private String activityDetail;
    private Date startTime;
    private Date endTime;
    private String str_startTime;
    private String str_endTime;

    public String getStr_startTime() {
        return str_startTime;
    }

    public void setStr_startTime(String str_startTime) {
        this.str_startTime = str_startTime;
    }

    public String getStr_endTime() {
        return str_endTime;
    }

    public void setStr_endTime(String str_endTime) {
        this.str_endTime = str_endTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityDetail() {
        return activityDetail;
    }

    public void setActivityDetail(String activityDetail) {
        this.activityDetail = activityDetail;
    }

}
