package com.cyan.mapper;

import com.cyan.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by cyan on 16/6/22.
 */
public interface StudentMapper {

    @Select("select * from student")
    public List<Student> selectUser();
    @Select("select * from student where id=#{id}")
    public Student selectUserById(@Param("id")String username);
    @Select("select password from student where id=#{id}")
    public String selectPasswordById(@Param("id")String username);

}
