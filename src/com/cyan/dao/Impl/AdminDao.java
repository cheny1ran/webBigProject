package com.cyan.dao.Impl;

import com.cyan.dao.IAdminDao;
import com.cyan.entity.Admin;
import com.cyan.entity.Course;
import com.cyan.entity.Student;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 功能描述:
 *
 * @Author cyan
 * @Date 16/7/8.
 */

@Repository
public class AdminDao extends SqlSessionDaoSupport implements IAdminDao {

    private static final String SQL_NAMESPACE = "Admin";

    @Override
    public Admin selectById(String id) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("id", id);
        return this.getSqlSession().selectOne(SQL_NAMESPACE + ".selectById", map);
    }

    @Override
    public List<Student> selectAllStudents() {
        return this.getSqlSession().selectList(SQL_NAMESPACE + ".selectAllStudents");
    }

    @Override
    public List<Course> selectAllCourses() {
        return this.getSqlSession().selectList(SQL_NAMESPACE + ".selectAllCourses");
    }

    @Override
    public void updateStudent(Student student) {
        Map<String,Student> map=new HashMap<String, Student>();
        map.put("s",student);
        this.getSqlSession().update(SQL_NAMESPACE+".updateStudent",map);
    }

    @Override
    public Student selectStuById(String id) {
        Map<String,String> map=new HashMap<String, String>();
        map.put("id",id);
        return this.getSqlSession().selectOne(SQL_NAMESPACE+".selectStuById",map);
    }

    @Override
    public void addStudent(Student student) {
        this.getSqlSession().insert(SQL_NAMESPACE + ".insertStudent", student);
    }

    @Override
    public void delStudent(String id) {
        Map<String,String> map=new HashMap<String, String>();
        map.put("id",id);
        this.getSqlSession().delete(SQL_NAMESPACE + ".delStudent", map);

    }
}
