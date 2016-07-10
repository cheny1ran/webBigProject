package com.cyan.controller;

import com.cyan.entity.Student;
import com.cyan.service.IAdminService;
import com.cyan.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * 功能描述:
 *
 * @Author cyan
 * @Date 16/7/8.
 */

@Controller
public class AdminController {

    @Autowired
    private IAdminService adminService;

    @Autowired
    private IStudentService studentService;

    @RequestMapping(value = "/changeStudent", method = RequestMethod.GET)
    public String changeStu(@RequestParam String id, HttpServletRequest req) {
        Student student = adminService.getStudentById(id);
        req.getSession().setAttribute("student", student);
        return "changeStu";
    }

    @RequestMapping(value = "/changeStudent", method = RequestMethod.POST)
    public String changeStudent(HttpServletRequest req) {
        try {
            req.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Student student = new Student();
        student.setId(req.getParameter("id"));
        student.setName(req.getParameter("name"));
        student.setPwd(req.getParameter("pwd"));
        student.setMajor(req.getParameter("major"));
        student.setYear(req.getParameter("year"));
        student.setSex(req.getParameter("sex").charAt(0));

        String msg = null;
        if (adminService.updateStudent(student)) {
            msg = "更新成功";
        } else {
            msg = "更新失败";
        }

        req.getSession().setAttribute("msg",msg);

        return "redirect:/studentManage";
    }

    @RequestMapping(value = "addStudent", method = RequestMethod.POST)
    public String addStudent(HttpServletRequest req) {
        try {
            req.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Student student = new Student();
        student.setId(req.getParameter("id"));
        student.setName(req.getParameter("name"));
        student.setPwd(req.getParameter("pwd"));
        student.setMajor(req.getParameter("major"));
        student.setYear(req.getParameter("year"));
        student.setSex(req.getParameter("sex").charAt(0));

        String msg = null;
        if (adminService.addStudent(student)) {
            msg = "添加成功";
        } else {
            msg = "添加失败";
        }

        req.getSession().setAttribute("msg",msg);

        return "redirect:/studentManage";
    }

    @RequestMapping("delStudent")
    public String delStudent(@RequestParam String id,HttpServletRequest req){
        adminService.delStudent(id);
        req.getSession().setAttribute("msg","删除成功");
        return "redirect:/studentManage";
    }


}
