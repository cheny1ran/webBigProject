package com.cyan.controller;

import com.cyan.entity.Course;
import com.cyan.service.IClzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    IClzService clzService;

    @RequestMapping("/index")
    public String displayAll(HttpServletRequest req) {

        List<Course> clzs = clzService.getAllClz();
        req.getSession().setAttribute("clzs", clzs);

        return "index";
    }

}
