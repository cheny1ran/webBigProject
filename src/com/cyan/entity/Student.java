package com.cyan.entity;

/**
 * Created by cyan on 16/6/22.
 */
public class Student {
    //学生学号
    private String id;
    //学生密码
    private String pwd;
    //学生姓名
    private String name;
    //学生性别
    private char sex;
    //学生年级
    private String year;
    //学生专业
    private String major;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
