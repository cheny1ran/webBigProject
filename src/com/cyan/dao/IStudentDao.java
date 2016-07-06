package com.cyan.dao;

import com.cyan.entity.Student;

/**
 * 功能描述:
 *
 * @Author cyan
 * @Date 16/7/5.
 */
public interface IStudentDao {

    /**
     * 添加学生信息
     */
    public void insert(Student student);

    /**
     * 更新学生信息
     */
    public void update(Student student);

    /**
     * 根据学号删除学生信息
     */
    public void delete(String id);

    /**
     * 根据id查找学生
     */
    public Student selectById(String id);

}
