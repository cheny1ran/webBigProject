package com.cyan.service;

import com.cyan.entity.Course;
import com.cyan.entity.Student;

import java.util.List;

/**
 * 功能描述:
 *
 * @Author cyan
 * @Date 16/7/8.
 */
public interface IAdminService {
    public boolean login(String username, String pwd);

    public List<Student> getAllStudents();

    public List<Course> getAllCourses();

    public boolean updateStudent(Student student);

    public Student getStudentById(String id);

    public boolean addStudent(Student student);

    public void delStudent(String id);
}
