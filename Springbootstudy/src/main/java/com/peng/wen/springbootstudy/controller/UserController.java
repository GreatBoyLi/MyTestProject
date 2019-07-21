package com.peng.wen.springbootstudy.controller;


import com.peng.wen.springbootstudy.pojo.JsonResult;
import com.peng.wen.springbootstudy.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 测试返回JSON对象，使用ResponseBody
 * @author liwpb
 */
@RestController  // @RestController =  @Controller + @ResponseBoy  @Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 测试返回Json对象
     * @return User
     */
    @RequestMapping("/getUser")// @ResponseBody   //此注解标识着，返回的数据是以JSON对象为主
    public User getUser(){
        User user = new User();

        user.setName("liwpb");
        user.setAge(25);
        user.setBirthday(new Date());
        user.setPassword("liwpb");
        user.setDesc("I am testing.");

        return user;
    }

    /**
     * 测试返回Json对象
     * @return User
     */
    @RequestMapping("/getUserJson")
    public JsonResult getUserjson(){
        User user = new User();

        user.setName("liwpb");
        user.setAge(25);
        user.setBirthday(new Date());
        user.setPassword("liwpb");

        return JsonResult.build(500,"ceshiceshi",user);
    }
}
