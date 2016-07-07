package com.cyan.controller;

import com.cyan.entity.Student;
import com.cyan.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by cyan on 16/6/22.
 */

@Controller
public class LoginController {

    @Autowired
    private IStudentService studentService;

    @RequestMapping("/login")
    public String userLogin(@RequestParam String id, @RequestParam String pwd, HttpServletRequest req) {
        Student student = studentService.login(id, pwd);
        if (student != null) {
            req.getSession().setAttribute("user", student.getName());
            req.getSession().setAttribute("userId", student.getId());
//            req.getSession().setAttribute("msg","登录成功!欢迎您 "+student.getName()+"!");
        }else{
            req.getSession().setAttribute("msg","登录失败!用户名或密码错误!");
        }
        return "redirect:/index";
    }

}
