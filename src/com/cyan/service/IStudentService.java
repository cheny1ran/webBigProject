package com.cyan.service;

import com.cyan.entity.Student;

/**
 * Created by cyan on 16/6/22.
 */
public interface IStudentService {

    public Student login(String id,String pwd);
    public boolean update(Student student);
    public boolean delete(String id);

    public boolean selectCource();
}
