package com.peng.wen.springbootstudy.controller;

import com.peng.wen.springbootstudy.pojo.JsonResult;
import com.peng.wen.springbootstudy.pojo.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 返回Json对象，资源文件的对象
 */
@RestController
public class HelloController {
    @Autowired
    private Resource resource;

    @RequestMapping("/hello")
    public JsonResult getResource(){
        Resource bean = new Resource();
        BeanUtils.copyProperties(resource,bean);

        return new JsonResult(bean);
    }
}
