package com.cyan.dao;

import com.cyan.entity.Admin;
import com.cyan.entity.Course;
import com.cyan.entity.Student;

import java.util.List;

/**
 * 功能描述:
 *
 * @Author cyan
 * @Date 16/7/8.
 */
public interface IAdminDao {

    public Admin selectById(String id);

    public List<Student> selectAllStudents();

    public List<Course> selectAllCourses();

    public void updateStudent(Student student);

    public Student selectStuById(String id);

    public void addStudent(Student student);

    public void delStudent(String id);

}
