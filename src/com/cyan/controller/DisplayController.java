package com.cyan.controller;

import com.cyan.entity.Course;
import com.cyan.entity.Student;
import com.cyan.entity.StudyInfo;
import com.cyan.service.IAdminService;
import com.cyan.service.IClzService;
import com.cyan.service.IStudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 功能描述:
 *
 * @Author cyan
 * @Date 16/7/5.
 */

@Controller
public class DisplayController {

    @Autowired
    private IClzService clzService;

    @Autowired
    private IStudyService studyService;

    @Autowired
    private IAdminService adminService;


    @RequestMapping("/index")
    public String displayAll(HttpServletRequest req) {

        List<Course> clzs = clzService.getAllClz();
        req.getSession().setAttribute("clzs", clzs);
        return "index";
    }

    @RequestMapping("/showDetail")
    public String showDetail(@RequestParam String id, HttpServletRequest req) {
        Course course = clzService.getClzById(Integer.parseInt(id));
        req.getSession().setAttribute("course", course);
        return "detail";
    }

    @RequestMapping("/showStudent")
    public String showStudents(HttpServletRequest req) {
        try {
            Integer clzId = Integer.parseInt(req.getParameter("id"));
            List<StudyInfo> students = studyService.getAllStuByClzId(clzId);

            req.getSession().setAttribute("students", students);

        } catch (NumberFormatException e) {
            e.printStackTrace();
            return "404";
        }

        return "stulist";

    }

    @RequestMapping("/showAllClasses")
    public String showAllClzs(HttpServletRequest req) {
        List<Course> courses = clzService.getAllClz();
        req.getSession().setAttribute("courses", courses);
        return "clzList";
    }

    @RequestMapping("/showMyClasses")
    public String showMyClzs(HttpServletRequest req) {
        String id = (String) req.getSession().getAttribute("userId");
        List<StudyInfo> studyInfos=null;
        if(id!=null){
            studyInfos = studyService.getAllClzByStuId(id);
        }
        req.getSession().setAttribute("clzs", studyInfos);
        return "myClzs";
    }

    @RequestMapping("/studentManage")
    public String studentManage(HttpServletRequest req){
        List<Student> students=adminService.getAllStudents();
        req.getSession().setAttribute("students", students);
        return "allStudents";
    }

}
