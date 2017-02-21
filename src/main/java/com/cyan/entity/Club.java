package com.cyan.entity;

/**
 * Created by cyan on 16/6/22.
 */
public class Club {

    //课程编号 登录号
    private String id;
    //课程名
    private String name;
    //课程负责人
    private String manager;
    //负责人电话
    private String tel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
