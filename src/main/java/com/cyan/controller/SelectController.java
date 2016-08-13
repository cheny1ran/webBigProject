package com.cyan.controller;

import com.cyan.entity.Course;
import com.cyan.service.IClzService;
import com.cyan.service.IStudentService;
import com.cyan.service.IStudyService;
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

    @Autowired
    private IStudyService studyService;

    @Autowired
    private IClzService clzService;


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

    @RequestMapping("/delCourse")
    public synchronized String delClz(HttpServletRequest req){
        try {
            String stuId = (String) req.getSession().getAttribute("userId");
            Integer clzId =Integer.parseInt(req.getParameter("id"));

            studyService.delCourse(stuId,clzId);
            Course c=clzService.getClzById(clzId);
            c.setSelected(c.getSelected()-1);

            clzService.update(c);

        }catch (NumberFormatException e){
            e.printStackTrace();
            return "404";
        }
        req.getSession().setAttribute("msg","删除成功!");
        return "redirect:/showMyClasses";
    }

}
