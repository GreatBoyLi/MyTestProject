package com.peng.wen.springbootstudy.controller;

import com.peng.wen.springbootstudy.pojo.JsonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 出错时跳转的控制器
 */
@RestController
public class ErrorController {

    @RequestMapping("/one")
    public JsonResult error(){
        return new JsonResult(500, "页面没有找到", null);
    }
}
