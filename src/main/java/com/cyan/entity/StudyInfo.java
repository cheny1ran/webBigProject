package com.cyan.entity;

/**
 * 功能描述:
 *
 * @Author cyan
 * @Date 16/7/7.
 */
public class StudyInfo {

    //选课信息编号
    private Integer id;
    //学生id
    private String s_id;
    //学生姓名
    private String s_name;
    //学生专业
    private String s_major;
    //课程编号
    private Integer c_id;
    //课程名
    private String c_name;
    //课程所属社团
    private String c_belong;
    //学分
    private Integer c_credit;
    //开课学期
    private String c_time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getS_id() {
        return s_id;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getS_major() {
        return s_major;
    }

    public void setS_major(String s_major) {
        this.s_major = s_major;
    }

    public Integer getC_id() {
        return c_id;
    }

    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_belong() {
        return c_belong;
    }

    public void setC_belong(String c_belong) {
        this.c_belong = c_belong;
    }

    public Integer getC_credit() {
        return c_credit;
    }

    public void setC_credit(Integer c_credit) {
        this.c_credit = c_credit;
    }

    public String getC_time() {
        return c_time;
    }

    public void setC_time(String c_time) {
        this.c_time = c_time;
    }
}
