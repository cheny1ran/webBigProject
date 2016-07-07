package com.cyan.controller;

import com.cyan.entity.Course;
import com.cyan.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 功能描述:
 *
 * @Author cyan
 * @Date 16/7/6.
 */

@Controller
public class SelectController {

    @Autowired
    private IStudentService studentService;

    @RequestMapping("/selectClz")
    public String selectClz(HttpServletRequest req) {
        String sId = (String) req.getSession().getAttribute("userId");
        Course c = (Course) req.getSession().getAttribute("course");

        Integer cId = c.getId();

        String msg = null;
        int rst = studentService.selectCource(sId, cId);
        if (rst==0) {
            msg = "选课成功!";
        } else if(rst==1){
            msg = "已经选过此课!";
        } else if(rst==2){
            msg="该课程已选满!";
        }else{
            msg="未知错误!";
        }
        req.getSession().setAttribute("msg", msg);
        return "detail";
    }

}
