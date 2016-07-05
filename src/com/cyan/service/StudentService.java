package com.cyan.service;

import com.cyan.entity.Student;
import com.cyan.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by cyan on 16/6/24.
 */
public class StudentService implements IStudentService{

    @Autowired
    private StudentMapper mapper;

    @Override
    public boolean login(String id, String pwd) {

        String truePwd=mapper.selectPasswordById(id);
        if(truePwd.equals(pwd)){
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
