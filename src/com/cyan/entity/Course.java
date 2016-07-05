package com.cyan.entity;

/**
 * Created by cyan on 16/6/22.
 */
public class Course {
    //课程名
    private String name;
    //课程开课学期
    private String time;
    //课程时长+课时
    private String during;
    //课程所属社团
    private String belong;
    //课程类别
    private String type;
    //课程开课地点
    private String place;
    //课程总招收人数
    int amount;

    public Course(String name,String time,String during,String belong,String type,String place,int amount){
        this.name=name;
        this.time=name;
        this.during=during;
        this.belong=belong;
        this.type=type;
        this.place=place;
        this.amount=amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDuring() {
        return during;
    }

    public void setDuring(String during) {
        this.during = during;
    }

    public String getBelong() {
        return belong;
    }

    public void setBelong(String belong) {
        this.belong = belong;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
