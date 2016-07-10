package com.cyan.service;

import com.cyan.entity.Course;
import com.cyan.entity.Student;
import com.cyan.entity.StudyInfo;

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

    public boolean addCourse(Course course);

    public boolean updateCourse(Course course);

    public void delCourse(Integer id);

    public Course getCourseById(Integer id);

    public List<StudyInfo> getAllStudyInfo();

    public void addStudyInfo(StudyInfo studyInfo);

    public void delStudyInfo(Integer id);

    public StudyInfo getStudyById(Integer id);

}
