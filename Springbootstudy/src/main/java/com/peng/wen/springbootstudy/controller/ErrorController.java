package com.peng.wen.springbootstudy.controller;

import com.peng.wen.springbootstudy.pojo.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 设置发生异常的Controller
 * @author liwpb
 */
@Controller
@RequestMapping("/err")
public class ErrorController {

    /**
     * 发生异常的发放
     * @return String
     */
    @RequestMapping("/error")
    public String error(){
        int a = 1 / 0;
        return "thyeleaf/error";
    }

    /**
     * Ajax发生异常
     * @return String
     */
    @RequestMapping("ajaxerror")
    public String ajaxError(){
        return "/thymeleaf/ajaxerror";
    }

    /**
     * 获得Ajax异常
     * @return JsonResult
     */
    @RequestMapping("/getAjaxerror")
    @ResponseBody
    public JsonResult getAjaxError(){
        int a = 1 / 0;
        return JsonResult.success();
    }
}
