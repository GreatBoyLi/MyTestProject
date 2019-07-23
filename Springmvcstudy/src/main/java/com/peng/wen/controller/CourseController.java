package com.peng.wen.controller;

import com.peng.wen.model.Course;
import com.peng.wen.service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 课程ConTroller，测试
 */
@Controller
@RequestMapping("/courses")
public class CourseController {

    private static Logger logger = LoggerFactory.getLogger(CourseController.class);

    @Resource
    private CourseService courseService;

    /**
     * 本方法将处理 /courses/view?courseId=123
     * @param courseId 课程ID
     * @param model Model
     * @return 页面地址
     */
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String viewCourse(@RequestParam("courseId") Integer courseId, Model model){

        logger.debug("In viewCourse, courseId = {}", courseId);

        Course course = courseService.getCourseById(courseId);
        model.addAttribute(course);
        return "course_overview";
    }

    /**
     * 本方法将处理 /courses/view/{courseId}
     * @param courseId 课程id
     * @param model Map
     * @return 页面地址
     */
    @RequestMapping(value = "/view/{courseId}", method = RequestMethod.GET)
    public String viewCourse(@PathVariable("courseId") Integer courseId, Map<String,Object> model){

        logger.debug("In viewCourse, courseId = {}", courseId);

        Course course = courseService.getCourseById(courseId);
        model.put("course",course);
        return "course_overview";
    }

    /**
     * 通过传统的HttpServeltRequest请求方式处理
     * @param request HttpServletRequest请求
     * @return 页面地址
     */
    @RequestMapping("/view1")
    public String viewCourse(HttpServletRequest request){
        Integer courseId = Integer.valueOf(request.getParameter("courseId"));
        Course course = courseService.getCourseById(courseId);
        request.setAttribute("course",course);
        System.out.println("liwpb" + request.getContextPath());
        return "course_overview";
    }

}
