package com.peng.wen.springbootstudy.service.impl;

import com.github.pagehelper.PageHelper;
import com.peng.wen.springbootstudy.mapper.SysUserMapper;
import com.peng.wen.springbootstudy.mapper.SysUserMapperCustomer;
import com.peng.wen.springbootstudy.pojo.SysUser;
import com.peng.wen.springbootstudy.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService{

    @Autowired
    private SysUserMapper sysUserMapper;

    @Resource
    private SysUserMapperCustomer sysUserMapperCustomer;

    @Override
    public void saveUser(SysUser user) {
        sysUserMapper.insert(user);
    }

    @Override
    public void updateUser(SysUser user) {
        sysUserMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void deleteUser(int name) {
        sysUserMapper.deleteByPrimaryKey(name);
    }

    @Override
    public SysUser querySysUser(String name) {
        return sysUserMapper.selectByPrimaryKey(name);
    }

    @Override
    public List<SysUser> querySysUserList(SysUser user) {
        return sysUserMapper.select(user);
    }

    @Override
    public List<SysUser> querySysUserListPage(SysUser user, Integer page, Integer pageSize) {
        //开始分页
        PageHelper.startPage(page, pageSize);

        Example example = new Example(SysUser.class);
        Example.Criteria criteria = example.createCriteria();
        example.orderBy("id").desc();
        List<SysUser> userList = sysUserMapper.selectByExample(example);
        return userList;
    }

    @Override
    public SysUser queryUserInfo(Integer id) {
        return sysUserMapperCustomer.queryUserInfo(id);
    }
}
