package com.peng.wen.springbootstudy.mapper;

import com.peng.wen.springbootstudy.pojo.SysUser;
import com.peng.wen.springbootstudy.utils.MyMapper;
import org.springframework.stereotype.Component;

@Component
public interface SysUserMapperCustomer extends MyMapper<SysUser> {

    SysUser queryUserInfo(Integer id);
}