package com.peng.wen.springbootstudy.service;

import com.peng.wen.springbootstudy.pojo.SysUser;

import java.util.List;

public interface SysUserService {

    void saveUser(SysUser user);

    void updateUser(SysUser user);

    void deleteUser(int name);

    SysUser querySysUser(String name);

    List<SysUser> querySysUserList(SysUser user);

    List<SysUser> querySysUserListPage(SysUser user, Integer page, Integer pageSize);

    SysUser queryUserInfo(Integer id);
}