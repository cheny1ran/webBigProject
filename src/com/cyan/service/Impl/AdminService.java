package com.cyan.service.Impl;

import com.cyan.dao.IAdminDao;
import com.cyan.entity.Admin;
import com.cyan.entity.Course;
import com.cyan.entity.Student;
import com.cyan.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能描述:
 *
 * @Author cyan
 * @Date 16/7/8.
 */

@Service
public class AdminService implements IAdminService {

    @Autowired
    private IAdminDao adminDao;

    @Override
    public boolean login(String username, String pwd) {
        Admin admin = adminDao.selectById(username);
        if (admin != null && admin.getPwd().equals(pwd)) {
            return true;
        }
        return false;
    }

    @Override
    public List<Student> getAllStudents() {
        return adminDao.selectAllStudents();
    }

    @Override
    public List<Course> getAllCourses() {
        return adminDao.selectAllCourses();
    }

    @Override
    public boolean updateStudent(Student student) {
        if (student.getId() != null && student.getId().length() != 0) {
            String name = student.getName().trim();
            if (name != null && name.length() <= 20 && name.length() > 0) {
                String pwd = student.getPwd().trim();
                if (pwd != null && pwd.length() <= 20 && pwd.length() > 0) {
                    String major = student.getMajor().trim();
                    if (major != null && major.length() <= 100 && major.length() > 0) {
                        String year = student.getYear();
                        if (year.length() == 4) {
                            for (int i = 0; i < 4; i++) {
                                if (year.charAt(i) > '9' || year.charAt(i) < '0')
                                    return false;
                            }
                            adminDao.updateStudent(student);
                            return true;
                        }

                    }
                }
            }
        }
        return false;
    }

    @Override
    public Student getStudentById(String id) {
        return adminDao.selectStuById(id);
    }

    @Override
    public boolean addStudent(Student student) {
        if (student.getId() != null && student.getId().length() > 0 && student.getId().length() <= 20) {
            if (adminDao.selectStuById(student.getId()) == null) {
                String name = student.getName().trim();
                if (name != null && name.length() <= 20 && name.length() > 0) {
                    String pwd = student.getPwd().trim();
                    if (pwd != null && pwd.length() <= 20 && pwd.length() > 0) {
                        String major = student.getMajor().trim();
                        if (major != null && major.length() <= 100 && major.length() > 0) {
                            String year = student.getYear();
                            if (year.length() == 4) {
                                for (int i = 0; i < 4; i++) {
                                    if (year.charAt(i) > '9' || year.charAt(i) < '0')
                                        return false;
                                }
                                adminDao.addStudent(student);
                                return true;
                            }

                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void delStudent(String id) {
        adminDao.delStudent(id);
    }
}
