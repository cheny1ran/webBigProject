package com.cyan.service.Impl;

import com.cyan.dao.IStudentDao;
import com.cyan.entity.Student;
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

    @Override
    public boolean login(String id, String pwd) {

        String truePwd = studentDao.selectById(id).getPwd();
        if (truePwd.equals(pwd)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Student student) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public boolean selectCource() {
        return false;
    }
}
