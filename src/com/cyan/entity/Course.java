package com.cyan.entity;

/**
 * Created by cyan on 16/6/22.
 */
public class Course {

    //课程id
    private Integer id;
    //课程名
    private String name;
    //课程开课学期
    private String time;
    //课程时长+课时
    private Integer credit;
    //课程所属社团
    private String belong;
    //课程类别
    private String type;
    //课程开课地点
    private String place;
    //课程总招收人数
    private Integer amount;

    public Course(Integer id, String name,String time,Integer credit,String belong,String type,String place,Integer amount){
        this.id=id;
        this.name=name;
        this.time=name;
        this.credit=credit;
        this.belong=belong;
        this.type=type;
        this.place=place;
        this.amount=amount;
    }

    public Course(){};

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getDuring() {
        return credit;
    }

    public void setDuring(Integer credit) {
        this.credit = credit;
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

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getAmount() {
        return amount;
    }

}
