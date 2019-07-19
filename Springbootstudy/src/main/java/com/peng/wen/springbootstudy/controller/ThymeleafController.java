package com.peng.wen.springbootstudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试 thymeleaf 模板
 */
@Controller
@RequestMapping("/th")
public class ThymeleafController {

    /**
     * 测试动态页面
     * @param map ModelMap
     * @return 页面地址
     */
    @RequestMapping("/index")
    public String getIndex(ModelMap map){
        map.addAttribute("name","liwpbTest");
        return "thymeleaf/index";
    }

    @RequestMapping("/center")
    public String center(){
        return "/thymeleaf/center/center";
    }
}
