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
            return "index";
        }
        return "404";
    }

}
