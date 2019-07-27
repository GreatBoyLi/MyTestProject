package com.peng.wen.springbootstudy.controller;

import com.peng.wen.springbootstudy.pojo.JsonResult;
import com.peng.wen.springbootstudy.pojo.SysUser;
import com.peng.wen.springbootstudy.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 通过mybatis对SysUser进行增删改查操作
 */
@RestController
@RequestMapping("mybatis")
public class MybatisCRUDSysUserController {

    @Autowired
    SysUserService sysUserService;

    /**
     * 新增信息
     * @return
     */
    @RequestMapping("addUser")
    public JsonResult saveUser(){
        SysUser user = new SysUser();

        for (int i = 2; i < 200; i++){
            user.setId(i);
            user.setAge(19);
            user.setName("liwpb");
            user.setDescr("测试第 " + i + "次");

            sysUserService.saveUser(user);
        }


        return JsonResult.success("保存成功");
    }

    /**
     * 更新操作
     * @return
     */
    @RequestMapping("updateUser")
    public JsonResult updateUser(){
        SysUser user = new SysUser();

        user.setId(2);
        user.setAge(220);

        sysUserService.updateUser(user);
        return JsonResult.success("更新成功");
    }

    /**
     * 删除操作
     * @return
     */
    @RequestMapping("deleteUser")
    public JsonResult deleteUser(){
        sysUserService.deleteUser(2);
        return JsonResult.success("删除成功");
    }

    /**
     * 分页查询
     * @param page
     * @return
     */
    @RequestMapping("userPage")
    public JsonResult queryUserListPage(Integer page){
        if (page == null){
            page = 1;
        }
        int pageSize = 10;

        SysUser user = new SysUser();

        List<SysUser> userList = sysUserService.querySysUserListPage(user,page,pageSize);
        return JsonResult.success(userList);
    }

    /**
     * 自定义查询
     * @return
     */
    @RequestMapping("customquery")
    public JsonResult queryCustom(){
        return JsonResult.success(sysUserService.queryUserInfo(2));
    }
}
