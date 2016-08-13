package com.cyan.service;

import com.cyan.entity.Course;

import java.util.List;

/**
 * 功能描述:
 *
 * @Author wenli
 * @Date 16/7/6.
 */
public interface IClzService {

    public List<Course> getAllClz();

    public Course getClzById(Integer id);

    public void update(Course course);

}
