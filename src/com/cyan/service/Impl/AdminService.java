package com.cyan.service.Impl;

import com.cyan.dao.IAdminDao;
import com.cyan.dao.IClzDao;
import com.cyan.entity.Admin;
import com.cyan.entity.Course;
import com.cyan.entity.Student;
import com.cyan.entity.StudyInfo;
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

    @Autowired
    private IClzDao clzDao;

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
                                if(Integer.parseInt(year)>=1900) {
                                    adminDao.addStudent(student);
                                    return true;
                                }
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
        adminDao.delStudyInfoBySId(id);
    }

    @Override
    public boolean addCourse(Course course) {
        String name=course.getName();
        if(name.length()>0&&name.length()<=100){
            String time=course.getTime();
            if(time.length()>0&&time.length()<=20){
                for (int i = 0; i < time.length(); i++) {
                    if (time.charAt(i) > '9' || time.charAt(i) < '0')
                        if(time.charAt(i)!='('&&time.charAt(i)!=')'&&time.charAt(i)!='/'){
                            return false;
                        }
                }
                String belong=course.getBelong();
                if(belong.length()>0&&belong.length()<=100){
                    String detail=course.getDetail();
                    if(detail.length()>0&&detail.length()<=200){
                        String place=course.getPlace();
                        if(place.length()>0&&place.length()<=30){
                            adminDao.addCourse(course);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void delCourse(Integer id) {
        adminDao.delCourse(id);
        adminDao.delStudyInfoByCId(id);
    }

    @Override
    public Course getCourseById(Integer id) {
        return clzDao.selectById(id);
    }

    @Override
    public boolean updateCourse(Course course) {
        Integer id=course.getId();
        if(id!=null||id>0) {
            String name = course.getName();
            if (name.length() > 0 && name.length() <= 100) {
                String time = course.getTime();
                if (time.length() > 0 && time.length() <= 20) {
                    for (int i = 0; i < time.length(); i++) {
                        if (time.charAt(i) > '9' || time.charAt(i) < '0')
                            if (time.charAt(i) != '(' && time.charAt(i) != ')' && time.charAt(i) != '/') {
                                return false;
                            }
                    }
                    String belong = course.getBelong();
                    if (belong.length() > 0 && belong.length() <= 100) {
                        String detail = course.getDetail();
                        if (detail.length() > 0 && detail.length() <= 200) {
                            String place = course.getPlace();
                            if (place.length() > 0 && place.length() <= 30) {
                                if(course.getAmount()>=course.getSelected()) {
                                    clzDao.update(course);
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public List<StudyInfo> getAllStudyInfo() {
        return adminDao.selectAllStudyInfo();
    }

    @Override
    public void addStudyInfo(StudyInfo studyInfo) {
        adminDao.addStudyInfo(studyInfo);
    }

    @Override
    public void delStudyInfo(Integer id) {
        adminDao.delStudyInfo(id);
    }

    @Override
    public StudyInfo getStudyById(Integer id) {
        return adminDao.selectById(id);
    }
}
