package com.cyan.controller;

import com.cyan.entity.Course;
import com.cyan.entity.Student;
import com.cyan.entity.StudyInfo;
import com.cyan.service.IAdminService;
import com.cyan.service.IStudentService;
import com.cyan.service.IStudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

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

    @Autowired
    private IStudyService studyService;

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

        req.getSession().setAttribute("msg", msg);

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

        req.getSession().setAttribute("msg", msg);

        return "redirect:/studentManage";
    }

    @RequestMapping("delStudent")
    public String delStudent(@RequestParam String id, HttpServletRequest req) {
        adminService.delStudent(id);
        req.getSession().setAttribute("msg", "删除成功");
        return "redirect:/studentManage";
    }

    @RequestMapping(value = "addCourse", method = RequestMethod.POST)
    public String addCourse(HttpServletRequest req) {
        String msg = null;
        try {
            req.setCharacterEncoding("utf-8");

            Course course = new Course();
            course.setName(req.getParameter("name"));
            course.setSelected(0);
            course.setAmount(Integer.parseInt(req.getParameter("amount")));
            course.setBelong(req.getParameter("belong"));
            course.setCredit(Integer.parseInt(req.getParameter("credit")));
            course.setPlace(req.getParameter("place"));
            course.setDetail(req.getParameter("detail"));
            course.setTime(req.getParameter("time"));
            if (adminService.addCourse(course)) {
                msg = "添加成功";
            } else {
                msg = "添加失败";
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            msg = "添加失败";
        } finally {
            req.getSession().setAttribute("msg", msg);
            return "redirect:/courseManage";
        }
    }

    @RequestMapping("adminDelCourse")
    public String delCourse(@RequestParam String id, HttpServletRequest req) {
        adminService.delCourse(Integer.parseInt(id));
        req.getSession().setAttribute("msg", "删除成功");
        return "redirect:/courseManage";
    }

    @RequestMapping(value = "/changeCourse", method = RequestMethod.GET)
    public String changeCourse(@RequestParam String id, HttpServletRequest req) {
        Course course = adminService.getCourseById(Integer.parseInt(id));
        req.getSession().setAttribute("course", course);
        return "changeClz";
    }

    @RequestMapping(value = "/changeCourse", method = RequestMethod.POST)
    public String changeCourse(HttpServletRequest req) {
        String msg = null;
        try {
            req.setCharacterEncoding("utf-8");


            Integer id = (Integer) req.getSession().getAttribute("id");

            Course course = adminService.getCourseById(id);

            course.setName(req.getParameter("name"));
            course.setAmount(Integer.parseInt(req.getParameter("amount")));
            course.setBelong(req.getParameter("belong"));
            course.setCredit(Integer.parseInt(req.getParameter("credit")));
            course.setPlace(req.getParameter("place"));
            course.setDetail(req.getParameter("detail"));
            course.setTime(req.getParameter("time"));

            if (adminService.updateCourse(course)) {
                msg = "更新成功";
            } else {
                msg = "更新失败";
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            msg = "更新失败";
            e.printStackTrace();
        } finally {
            req.getSession().setAttribute("msg", msg);
            return "redirect:/courseManage";
        }
    }


    @RequestMapping("/chooseManage")
    public String chooseManage(HttpServletRequest req) {
        List<StudyInfo> records = adminService.getAllStudyInfo();
        req.getSession().setAttribute("records", records);
        return "allChoose";
    }

    @RequestMapping("/delStudyInfo")
    public String delStudyInfo(HttpServletRequest req, @RequestParam String id) {
        String msg = null;
        try {
            Integer stdId = Integer.parseInt(id);
            StudyInfo info = adminService.getStudyById(stdId);
            Course c = adminService.getCourseById(info.getC_id());
            c.setSelected(c.getSelected() - 1);
            adminService.updateCourse(c);
            adminService.delStudyInfo(stdId);
            msg = "删除成功";
        } catch (Exception e) {
            msg = "删除失败";
            e.printStackTrace();
        } finally {
            req.getSession().setAttribute("msg", msg);
            return "redirect:/chooseManage";
        }
    }


    @RequestMapping("/addChoose")
    public String addChoose(HttpServletRequest req, @RequestParam String stuId, @RequestParam String clzId) {
        String msg = null;
        try {
            Integer cId = Integer.parseInt(clzId);
            Student s = adminService.getStudentById(stuId);
            Course c = adminService.getCourseById(cId);
            if (s != null && c != null) {
                if(c.getAmount()>c.getSelected()) {
                    int rst = studentService.selectCource(stuId, cId);
                    if (rst==0) {
                        msg = "添加成功";
                    } else if(rst==1){
                        msg = "已经选过此课!";
                    } else if(rst==2){
                        msg="该课程已选满!";
                    }else{
                        msg="未知错误!";
                    }
                }
            }else{
                msg="添加失败";
            }
        } catch (Exception e) {
            msg = "添加失败";
            e.printStackTrace();
        } finally {
            req.getSession().setAttribute("msg", msg);
            return "redirect:/chooseManage";
        }
    }

}
