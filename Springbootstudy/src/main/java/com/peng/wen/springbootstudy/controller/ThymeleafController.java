package com.peng.wen.springbootstudy.controller;

import com.peng.wen.springbootstudy.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 测试 thymeleaf 模板
 * @author liwpb
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
        return "/thymeleaf/index";
    }

    /**
     * 测试静态界面
     * @return String
     */
    @RequestMapping("/center")
    public String center(){
        return "/thymeleaf/center/center";
    }

    /**
     * 测试Thymeleaf常用标签
     * @param map ModelMap
     * @return String
     */
    @RequestMapping("/user")
    public String user(ModelMap map){
        map.addAttribute("title","Test");
        User user = new User();
        user.setAge(18);
        user.setName("liwpb1");
        user.setDesc("<font color='green'><b>hello</b></font>");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        Date birthday = null;
        try {
            birthday = sdf.parse("1995-11-01");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setBirthday(birthday);
        map.addAttribute("user",user);

        User u1 = new User();
        u1.setName("李文鹏");
        u1.setAge(25);
        u1.setBirthday(new Date());
        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(u1);

        map.addAttribute("userList",userList);
        return "/thymeleaf/user";
    }

    /**
     * 测试表格超链接
     * @param u 表格上送的信息
     * @return String
     */
    @RequestMapping("postform")
    public String postfrom(User u){
        System.out.println(u.getName());

        return "redirect:/th/index";
    }
}
