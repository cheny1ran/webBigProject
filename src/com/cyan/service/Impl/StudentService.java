package com.cyan.service.Impl;

import com.cyan.dao.IClzDao;
import com.cyan.dao.IStudentDao;
import com.cyan.dao.IStudyInfoDao;
import com.cyan.entity.Course;
import com.cyan.entity.Student;
import com.cyan.entity.StudyInfo;
import com.cyan.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cyan on 16/6/24.
 */

@Service
public class StudentService implements IStudentService {

    @Autowired
    private IStudentDao studentDao;

    @Autowired
    private IStudyInfoDao studyInfoDao;

    @Autowired
    private IClzDao clzDao;

    @Override
    public Student login(String id, String pwd) {

        Student student = studentDao.selectById(id);
        if (student != null) {
            if (student.getPwd().equals(pwd)) {
                return student;
            }
        }
        return null;
    }

    @Override
    public boolean update(Student student) {

        studentDao.update(student);
        return true;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public synchronized int selectCource(String stuId, Integer clzId) {

        //查看人数是否已满
        Course c = clzDao.selectById(clzId);
        Student s = studentDao.selectById(stuId);
        if (c != null && s != null) {
            if (c.getSelected() < c.getAmount()) {

                //查询是否已经选过
                StudyInfo checkIfExist = studyInfoDao.check(stuId, clzId);
                if (checkIfExist == null) {

                    StudyInfo studyInfo = new StudyInfo();
                    studyInfo.setC_id(c.getId());
                    studyInfo.setC_name(c.getName());
                    studyInfo.setC_belong(c.getBelong());
                    studyInfo.setS_id(stuId);
                    studyInfo.setS_name(s.getName());
                    studyInfo.setS_major(s.getMajor());
                    studyInfo.setC_credit(c.getCredit());
                    studyInfo.setC_time(c.getTime());
                    studyInfoDao.insert(studyInfo);

                    c.setSelected(c.getSelected() + 1);
                    clzDao.update(c);

                    return 0;
                } else {
                    return 1;
                }
            } else {
                return 2;
            }
        }
        return -1;
    }

    @Override
    public boolean changePwd(String stuId, String old, String newpwd) {
        Student s = login(stuId, old);
        if (s != null) {
            s.setPwd(newpwd);
            studentDao.update(s);
            return true;
        }
        return false;
    }
}
