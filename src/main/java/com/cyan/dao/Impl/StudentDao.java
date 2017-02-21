package com.cyan.dao.Impl;

import com.cyan.dao.IStudentDao;
import com.cyan.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cyan on 16/6/22.
 */

@Repository
public class StudentDao extends SqlSessionDaoSupport implements IStudentDao {

    private static final String SQL_NAMESPACE = "Student";

    @Override
    public void insert(Student student) {
        this.getSqlSession().insert(SQL_NAMESPACE + ".insert", student);
    }

    @Override
    public void update(Student student) {
        this.getSqlSession().update(SQL_NAMESPACE + ".update", student);
    }

    @Override
    public void delete(@Param("id")String id) {
        this.getSqlSession().delete(SQL_NAMESPACE + ".delete", id);
    }

    @Override
    public Student selectById(@Param("id")String id) {
        Map<String,String> map=new HashMap<String, String>();
        map.put("id",id);
        return this.getSqlSession().selectOne(SQL_NAMESPACE + ".selectById", map);
    }
}
