package com.peng.wen.springbootstudy.controller;

import com.peng.wen.springbootstudy.pojo.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * freemarker 模板引擎测试
 */
@Controller
@RequestMapping("/ftl")
public class FreemarkerController {

    /**
     * 资源文件对象
     */
    @Autowired
    private Resource resource;

    /**
     * 测试index页面
     * @param map ModuleMap
     * @return String .ftl文件的位置
     */
    @RequestMapping("/index")
    public String index(ModelMap map){ // ModelMap 与ModelAndView类似
        map.addAttribute("resource",resource);
        return "freemarker/index";
    }

    /**
     * 测试center页面
     * @return center页面的位置
     */
    @RequestMapping("/center")
    public String Center(){
        return "freemarker/center/center";
    }

}
