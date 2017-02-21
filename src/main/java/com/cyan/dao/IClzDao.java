package com.cyan.dao;

import com.cyan.entity.Course;

import java.util.List;

/**
 * 功能描述:
 *
 * @Author cyan
 * @Date 16/7/6.
 */
public interface IClzDao {

    public List<Course> selectAll();

    public Course selectById(Integer id);

    public void update(Course course);


}
